package com.ralph.second;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 果占先 on 2016/6/22.
 */
public interface Ex60StudentService {
    @GET("/Test/findStudentByPage.do")
    Call<Page> findStudentByPage(@Query("pageNo") int currentPage);
}
