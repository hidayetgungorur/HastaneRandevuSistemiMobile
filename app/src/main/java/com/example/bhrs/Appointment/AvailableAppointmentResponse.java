package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AvailableAppointmentResponse {

    @JsonProperty("ErrorCode")
    public String errorCode;
    @JsonProperty("ErrorMessage")
    public String errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public List<AAResponse> response;

}
