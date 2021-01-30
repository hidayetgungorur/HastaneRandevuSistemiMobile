package com.example.bhrs.Login;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Request {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("UserName")
    public String userName;
    @JsonProperty("Password")
    public String password;
    @JsonProperty("IsDoctor")
    public boolean isDoctor;
}
