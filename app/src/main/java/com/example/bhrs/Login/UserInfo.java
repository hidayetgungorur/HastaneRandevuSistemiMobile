package com.example.bhrs.Login;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("DoctorId")
    public String doctorId;
    @JsonProperty("PatientId")
    public String patientId;
    @JsonProperty("UserId")
    public String userId;
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
