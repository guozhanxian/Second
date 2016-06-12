package com.ralph.second;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by 果占先 on 2016/6/12.
 */
public interface Ex53BaiduPhone {
    @GET("/apistore/mobilenumber/mobilenumber")
    Call<PhoneCity> getPhoneInfo(@Header("apikey") String apikey, @Query("phone") String phoneNumber);
}
