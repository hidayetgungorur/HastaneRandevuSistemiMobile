package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
public class CancelAppointmentResponse{
    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public boolean response;
}
