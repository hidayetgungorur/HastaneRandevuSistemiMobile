package com.example.bhrs.Appointment;
import com.example.bhrs.General.HeaderRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class CARequest {
    @JsonProperty("HeaderRequest")
    public HeaderRequest headerRequest;
    @JsonProperty("PatientId")
    public String patientId;
    @JsonProperty("Id")
    public String id;
}
