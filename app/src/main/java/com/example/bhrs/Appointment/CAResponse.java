package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
public class CAResponse {
    @JsonProperty("Date")
    public String date;
    @JsonProperty("Id")
    public int id;
}
