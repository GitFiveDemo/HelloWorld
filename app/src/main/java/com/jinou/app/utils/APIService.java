package com.jinou.app.utils;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * author: ShiChenguang
 * date : 2018/5/8 18:46
 */
public interface APIService {
    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);
    @GET("{url}")
    Observable<ResponseBody> doGet(@Path(value = "url", encoded = true) String url);
}
