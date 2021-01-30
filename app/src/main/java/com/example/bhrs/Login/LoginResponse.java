package com.example.bhrs.Login;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse{
    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public UserInfo response;
}
