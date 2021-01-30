package com.example.bhrs.Appointment;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AARequest {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("DoctorId")
    public String doctorId;
    @JsonProperty("PoliklinikId")
    public String poliklinikId;
    @JsonProperty("Date")
    public String date;
}
