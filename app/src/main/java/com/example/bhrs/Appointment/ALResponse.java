package com.example.bhrs.Appointment;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ALResponse {

    @JsonProperty("Date")
    public String date;
    @JsonProperty("DoctorName")
    public String doctorName;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("PoliklinikName")
    public String poliklinikName;
    @JsonProperty("Status")
    public String status;
}
