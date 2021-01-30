package com.example.bhrs.Account;
import com.example.bhrs.Login.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AccountResponse {

    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public UserInfo response;

}
