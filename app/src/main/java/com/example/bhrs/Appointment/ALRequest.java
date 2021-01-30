package com.example.bhrs.Appointment;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ALRequest {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("Id")
    public int id;
}
