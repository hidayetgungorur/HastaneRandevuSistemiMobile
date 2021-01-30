package com.example.bhrs.Appointment.Poliklinik;
import com.fasterxml.jackson.annotation.JsonProperty;
public class PResponse {
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Name")
    public String name;
}
