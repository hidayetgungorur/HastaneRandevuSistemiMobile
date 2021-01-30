package com.example.bhrs.Account;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ARequest {

    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("UserId")
    public int userId;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("TC")
    public String tC;
    @JsonProperty("BirthDate")
    public String birthDate;
    @JsonProperty("Phone")
    public String phone;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("GenderType")
    public int genderType;
    @JsonProperty("Password")
    public String password;

}
