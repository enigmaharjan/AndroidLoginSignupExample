package com.exmple.loginexample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exmple.loginexample.R;
import com.exmple.loginexample.api.UserApi;
import com.exmple.loginexample.model.User;
import com.exmple.loginexample.serverResponse.LoginSignupResponse;
import com.exmple.loginexample.url.url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    Button btnSignup;
    EditText etUsername, etFullName, etPassword, etPhone,etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.etNewUserName);
        etEmail = findViewById(R.id.etEmail);
        etFullName = findViewById(R.id.etFullName);
        etPassword = findViewById(R.id.etNewPassword);
        etPhone = findViewById(R.id.etPhone);
        btnSignup = findViewById(R.id.btnNewSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = etFullName.getText().toString();
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(fullName,username,email,password,phone);

                UserApi userApi = url.getInstance().create(UserApi.class);
                Call<LoginSignupResponse> call = userApi.registerUser(user);
                call.enqueue(new Callback<LoginSignupResponse>() {
                    @Override
                    public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                        if(response.body().getStatus()){
                            Toast.makeText(RegisterActivity.this, "Signed Up Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Can't Signup", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Error: " + t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
