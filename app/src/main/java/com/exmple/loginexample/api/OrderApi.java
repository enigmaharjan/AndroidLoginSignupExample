package com.exmple.loginexample.api;

import com.exmple.loginexample.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderApi {
    @GET("order/{id}")
    Call<List<Order>> listOrder(@Path("id")String id);

    @PUT("order/{id}")
    Call<Order> editOrder(@Path("id")String id);
}
