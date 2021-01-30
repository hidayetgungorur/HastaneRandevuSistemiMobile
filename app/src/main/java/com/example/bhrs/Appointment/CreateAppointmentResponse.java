package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
public class CreateAppointmentResponse {
    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public CAResponse response;
}
