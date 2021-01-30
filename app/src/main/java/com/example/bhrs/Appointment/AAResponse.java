package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AAResponse {
    @JsonProperty("Date")
    public String date;
    @JsonProperty("Id")
    public String id;
}
