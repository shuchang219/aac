package com.senon.mvpretrofitrx.mvp.api;

import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import java.util.List;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * api service
 */
public interface ApiService {

    @POST("query")
//    @POST("province-count")
    Observable<BaseResponse<List<Login>>> login(@QueryMap Map<String, String> map);

    @POST("query")
    Observable<BaseResponse<List<Login>>> logout(@QueryMap Map<String, String> map);

//    //上传图片
//    @POST("file/up")
//    @Multipart
//    Observable<BaseResponse<List<UploadFile>>> upload(@Part List<MultipartBody.Part> parts);


    @GET("wxarticle/chapters/json")
    Observable<BaseResponse> getChapters();
}
