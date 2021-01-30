package com.example.bhrs.Appointment.Poliklinik;

import com.example.bhrs.Appointment.ALRequest;
import com.example.bhrs.Appointment.AppointmentListRequest;
import com.example.bhrs.Appointment.AppointmentListResponse;
import com.example.bhrs.General.AccountManager;
import com.example.bhrs.General.ServiceManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.example.bhrs.General.ServiceManager.GenerateHeaderRequest;

public class PoliklinikManager {


    public  static PoliklinikResponse GetPolikliniks()  {

        try {

            PoliklinikRequest lr = new PoliklinikRequest();
            lr.request = new PRequest();
            lr.request.headerRequest = GenerateHeaderRequest();

            String result = ServiceManager.sendPostRequest("GetPolikliniks",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            PoliklinikResponse response = objectMapper.readValue(result, PoliklinikResponse.class);

            return  response;
        }
        catch (Exception e)
        {
            return  new PoliklinikResponse();
        }
    }
}
