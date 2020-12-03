package com.bytedance.toutiao.retrofit;

import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.SearchHotModel;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.TopicModel;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.bean.basebean.ResponseModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Data : 2020/10/29
 * Time : 15:36
 * Author : 刘朝阳
 */
public interface RetrofitApiService {

    @POST("mock/7451/byte/dance/v1.0/base/login")
    @FormUrlEncoded
    Observable<ResponseModel<User>> login(@FieldMap HashMap<String, String> map);

    @POST("mock/7451/byte/dance/v1.0/base/register")
    @FormUrlEncoded
    Observable<ResponseModel<User>> register(@FieldMap HashMap<String, String> map);

    @GET("mock/7451/byte/dance/v1.0/getRecommentVideos")
    Observable<ResponseModel<List<VideoModel>>> getRecommentVideos();

    @GET("mock/7451/byte/dance/v1.0/home/news/list")
    Observable<ResponseModel<List<NewsModel>>> listNews(@Query("type") String type);

    @GET("mock/7451/byte/dance/v1.0/home/news/detail/{id}")
    Observable<ResponseModel<NewsModel>> newsDetail(@Path("id") String id);

    //信息界面评论列表
    @GET("mock/7451/byte/dance/v1.0/message/comment/items")
    Observable<ResponseModel<List<MessageCommentModel>>> getMsgComments(@Query("type") String type);

    //信息界面关注列表
    @GET("mock/7451/byte/dance/v1.0/message/focus/items")
    Observable<ResponseModel<List<MsgFocusModel>>> getMsgFocus();

    //搜索界面列表
    @GET("mock/7451/byte/dance/v1.0/search/hot/items")
    Observable<ResponseModel<List<SearchHotModel>>> getSearchHot(@Query("type") String type);

    //获取话题广场帖子
    @POST("mock/7451/byte/dance/v1.0/getPostDetailByEventId")
    @FormUrlEncoded
    Observable<ResponseModel<List<PostDetailModel>>> getPostsByEventId(@Field("eventId") String eventId);

    //获取视频
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getMyVideos")
    @FormUrlEncoded
    Observable<ResponseModel<List<VideoModel>>> getMyVideos(@Field("id") int id, @Field("state")String state);

    //获取资讯
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getMyInfos")
    @FormUrlEncoded
    Observable<ResponseModel<List<NewsModel>>> getMyInfos(@Field("id") int id, @Field("state")String state);

    //获取话题
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getMyTopics")
    @FormUrlEncoded
    Observable<ResponseModel<List<TopicModel>>> getMyTopics(@Field("id") int id);

    //修改个人信息
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/my/myUpdate")
    @FormUrlEncoded
    Observable<ResponseModel<String>> myUpdate(@Field("id")int id, @Field("nickname")String nickname, @Field("sex")String sex, @Field("introduction")String introduction);

    //修改绑定手机
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/my/myTel")
    @FormUrlEncoded
    Observable<ResponseModel<String>> myTel(@Field("id")int id, @Field("phoneNum")String phoneNum, @Field("code")String code);

    //修改绑定手机
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/my/myEmail")
    @FormUrlEncoded
    Observable<ResponseModel<String>> myEmail(@Field("id")int id, @Field("email")String email, @Field("code")String code);

    //修改密码
    @POST("mock/7451/byte/dance/v1.0/byte/dance/v1.0/my/updatePassword")
    @FormUrlEncoded
    Observable<ResponseModel<String>> updatePassword(@Field("id")int id, @Field("password")String password);
}

