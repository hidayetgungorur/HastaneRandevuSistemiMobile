package com.example.bhrs.Appointment.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;
public class DResponse {
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
}
