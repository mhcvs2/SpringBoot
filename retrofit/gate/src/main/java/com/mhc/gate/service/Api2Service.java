package com.mhc.gate.service;

import com.mhc.api1.model.User;
import com.mhc.api2.model.Phone;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface Api2Service {

    @GET("/phone")
    public Phone getPhone();  //@Query @Body

    @POST("/phone")
    public String addPhone(@Body Phone phone);

}
