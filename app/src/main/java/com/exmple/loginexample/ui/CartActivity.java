package com.exmple.loginexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.exmple.loginexample.R;
import com.exmple.loginexample.adapter.OrderAdapter;
import com.exmple.loginexample.api.OrderApi;
import com.exmple.loginexample.model.Order;
import com.exmple.loginexample.url.url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    RecyclerView rvRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        rvRecycler = findViewById(R.id.rvRecycler);

        OrderApi orderApi = url.getInstance().create(OrderApi.class);
        Call<List<Order>> order  = orderApi.listOrder("1");
        order.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                List<Order> orders  = response.body();
                OrderAdapter orderAdapter = new OrderAdapter(CartActivity.this, orders);
                rvRecycler.setAdapter(orderAdapter);
                rvRecycler.setLayoutManager(new LinearLayoutManager(CartActivity.this));

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(CartActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
