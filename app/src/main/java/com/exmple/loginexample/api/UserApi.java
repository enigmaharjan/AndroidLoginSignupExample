package com.exmple.loginexample.api;

import com.exmple.loginexample.model.User;
import com.exmple.loginexample.serverResponse.LoginSignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/signup")
    Call<LoginSignupResponse> registerUser(@Body User users);

    @POST("user/login")
    Call<LoginSignupResponse> checkUser(@Body User users);
}
