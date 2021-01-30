package com.example.bhrs.Appointment.Poliklinik;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PoliklinikResponse {

    @JsonProperty("ErrorCode")
    public Object errorCode;
    @JsonProperty("ErrorMessage")
    public Object errorMessage;
    @JsonProperty("HasError")
    public boolean hasError;
    @JsonProperty("Response")
    public List<PResponse> response;
}
