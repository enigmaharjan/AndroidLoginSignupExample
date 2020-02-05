package com.exmple.loginexample.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exmple.loginexample.R;
import com.exmple.loginexample.api.UserApi;
import com.exmple.loginexample.bll.loginBll;
import com.exmple.loginexample.model.User;
import com.exmple.loginexample.serverResponse.LoginSignupResponse;
import com.exmple.loginexample.strictmode.StrictMode;
import com.exmple.loginexample.url.url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin, btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
//                loginBll loginBll = new loginBll();
//                StrictMode.StrictMode();
//                boolean check = loginBll.checkUser(username, password);
                User user = new User(username, password);
                UserApi userApi = url.getInstance().create(UserApi.class);
                Call<LoginSignupResponse> call = userApi.checkUser(user);
                call.enqueue(new Callback<LoginSignupResponse>() {
                    @Override
                    public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                        if(response.body().getStatus()){
                            Toast.makeText(MainActivity.this, "login Successful ", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Either Username or Password is Incorrect ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "login UnSuccessful "+t, Toast.LENGTH_SHORT).show();

                    }
                });



            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
//                finish();
            }
        });
    }
}
