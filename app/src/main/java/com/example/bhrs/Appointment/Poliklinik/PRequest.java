package com.example.bhrs.Appointment.Poliklinik;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class PRequest {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
}
