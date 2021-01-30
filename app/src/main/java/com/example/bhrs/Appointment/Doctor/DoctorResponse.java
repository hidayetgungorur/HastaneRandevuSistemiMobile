package com.example.bhrs.Appointment.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DoctorResponse {
    @JsonProperty("ErrorCode")
    public Object errorCode;
    @JsonProperty("ErrorMessage")
    public Object errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public List<DResponse> response;
}
