package com.example.bhrs.Appointment.Doctor;

import com.example.bhrs.Appointment.Poliklinik.PRequest;
import com.example.bhrs.Appointment.Poliklinik.PoliklinikRequest;
import com.example.bhrs.Appointment.Poliklinik.PoliklinikResponse;
import com.example.bhrs.General.ServiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.bhrs.General.ServiceManager.GenerateHeaderRequest;

public class DoctorManager {


    public  static DoctorResponse GetPoliklinikDoctors(String poliklinikId)  {

        try {

            DoctorRequest lr = new DoctorRequest();
            lr.request = new DRequest();
            lr.request.poliklinikId = poliklinikId;
            lr.request.headerRequest = GenerateHeaderRequest();

            String result = ServiceManager.sendPostRequest("GetPoliklinikDoctors",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            DoctorResponse response = objectMapper.readValue(result, DoctorResponse.class);

            return  response;
        }
        catch (Exception e)
        {
            return  new DoctorResponse();
        }
    }

}
