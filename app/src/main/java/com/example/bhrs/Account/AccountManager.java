package com.example.bhrs.Account;

import com.example.bhrs.General.ServiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.bhrs.General.ServiceManager.GenerateHeaderRequest;

public class AccountManager {


    public  static  boolean CreateAccount(AccountRequest req)  {

        try {
            req.request.headerRequest = GenerateHeaderRequest();

            String result = ServiceManager.sendPostRequest("CreateAccount",req);

            ObjectMapper objectMapper = new ObjectMapper();
            AccountResponse response = objectMapper.readValue(result, AccountResponse.class);
            if(response.hasError)
                throw  new Exception(response.errorMessage);

            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }

    public  static  boolean UpdateAccount(AccountRequest req)  {

        try {
            req.request.headerRequest = GenerateHeaderRequest();

            String result = ServiceManager.sendPostRequest("UpdateAccount",req);

            ObjectMapper objectMapper = new ObjectMapper();
            AccountResponse response = objectMapper.readValue(result, AccountResponse.class);
            if(response.hasError)
                throw  new Exception(response.errorMessage);

            com.example.bhrs.General.AccountManager.User=response.response;

            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }



}
