package com.mhc.gate.service;

import com.mhc.api1.model.User;
import retrofit.http.*;

public interface Api1Service {

    @GET("/user/{id}")
    public User getUser(@Path("id") int id);  //@Query @Body

    @Headers({"a1: lala", "a2: baba"})
    @POST("/user/add")
    public int addUser(@Body User user);

    @POST("/user/{path}")
    public Object anyPost(@Path("path") String action, @Body Object object);

}
