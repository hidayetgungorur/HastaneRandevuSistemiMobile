package com.example.bhrs.Appointment.Doctor;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class DRequest {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("PoliklinikId")
    public String poliklinikId;

}
