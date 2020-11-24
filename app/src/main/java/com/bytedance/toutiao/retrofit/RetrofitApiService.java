package com.bytedance.toutiao.retrofit;

import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.bean.basebean.ResponseModel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

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
    //信息界面评论列表数据接口
    @GET("mock/7451/byte/dance/v1.0/message/comment/items")
    Observable<ResponseModel<List<MessageCommentModel>>> getMsgComments();

    //获取话题广场帖子
    @POST("mock/7451/byte/dance/v1.0/getPostDetailByEventId")
    @FormUrlEncoded
    Observable<ResponseModel<List<PostDetailModel>>> getPostsByEventId(@Field("eventId") String eventId);

    //获取草稿箱视频
    @GET("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getDraftsVideos")
    Observable<ResponseModel<List<VideoModel>>> getDraftsVideos(@Field("id") String id);

    //获取待审批视频
    @GET("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getPreApprovalVideos")
    Observable<ResponseModel<List<VideoModel>>> getPreApprovalVideos(@Field("id") String id);

    //获取未通过视频
    @GET("mock/7451/byte/dance/v1.0/byte/dance/v1.0/getFailedVideos")
    Observable<ResponseModel<List<VideoModel>>> getFailedVideos(@Field("id") String id);

    //获取已发布视频

    Observable<ResponseModel<List<VideoModel>>> getPublishedVideos(@Field("id") String id);
}
