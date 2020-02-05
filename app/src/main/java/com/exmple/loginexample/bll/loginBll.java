package com.exmple.loginexample.bll;

import com.exmple.loginexample.api.UserApi;
import com.exmple.loginexample.model.User;
import com.exmple.loginexample.serverResponse.LoginSignupResponse;
import com.exmple.loginexample.url.url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class loginBll {

    boolean isSuccess = false;

    public boolean checkUser(String email, String password){

        UserApi userApi = url.getInstance().create(UserApi.class);
        User user = new User(email,password);
        Call<LoginSignupResponse> userCall =userApi.checkUser(user);

        try {
            Response<LoginSignupResponse> loginResponse = userCall.execute();
            if (loginResponse.isSuccessful()) {
                if(loginResponse.body().getStatus()) {
                    isSuccess = true;
                }
//                else if(loginResponse.body().getStatus().equals("false") ){
//                    isSuccess = false;
//                }
            }
            else{
                isSuccess = false;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return isSuccess;
    }
}
