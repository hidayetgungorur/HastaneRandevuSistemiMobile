package com.example.bhrs.Login;

import com.example.bhrs.General.AccountManager;
import com.example.bhrs.General.HeaderRequest;
import com.example.bhrs.General.ServiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.bhrs.General.ServiceManager.GenerateHeaderRequest;

public  class LoginManager {

    public  static  boolean Login(String userName ,String password,boolean isDoctor)  {

        try {
            LoginRequest lr = new LoginRequest();
            lr.request = new Request();
            lr.request.headerRequest = GenerateHeaderRequest();
            lr.request.userName = userName;
            lr.request.password=password;
            lr.request.isDoctor =isDoctor;

            String result = ServiceManager.sendPostRequest("Login",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            LoginResponse response = objectMapper.readValue(result, LoginResponse.class);
               if(response.hasError)
                   throw  new Exception(response.errorMessage);

            AccountManager.User=response.response;

            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }



}
