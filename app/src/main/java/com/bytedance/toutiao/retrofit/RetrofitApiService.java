package com.bytedance.toutiao.retrofit;


import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.bean.basebean.ResponseModel;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

    @GET("mock/7451/byte/dance/v1.0/home/news/s")
    Observable<ResponseModel<List<NewsModel>>> listNews();

    @GET("mock/7451/byte/dance/v1.0/home/news/follow/{id}")
    Observable<ResponseModel<List<NewsModel>>> followNews(String id);

    @GET("mock/7451/byte/dance/v1.0/home/news/samecity/{id}")
    Observable<ResponseModel<List<NewsModel>>> sameCityNews(String id);

    @GET("mock/7451/byte/dance/v1.0/home/news/detail/{id}")
    Observable<ResponseModel<NewsModel>> newsDetail(String id);

}
