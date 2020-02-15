package com.exmple.loginexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exmple.loginexample.R;
import com.exmple.loginexample.api.OrderApi;
import com.exmple.loginexample.model.Order;
import com.exmple.loginexample.url.url;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    Context context;
    List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view,parent,false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final Order order = orders.get(position);
        holder.tvUserId.setText(order.get_id());
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderApi orderApi = url.getInstance().create(OrderApi.class);
                Order o = new Order("1","1","1",null,null);
                Call<Order> orderCall = orderApi.editOrder("5e4802a0bd1d807892b57d51");
                orderCall.enqueue(new Callback<Order>() {
                    @Override
                    public void onResponse(Call<Order> call, Response<Order> response) {
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Order> call, Throwable t) {
                        Toast.makeText(context, ""+t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId;
        Button btnBuy;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            btnBuy = itemView.findViewById(R.id.btnBuy);
            tvUserId = itemView.findViewById(R.id.tvUserId);
        }
    }
}
