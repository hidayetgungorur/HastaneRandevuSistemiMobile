package com.example.bhrs.Appointment;

import com.example.bhrs.General.AccountManager;
import com.example.bhrs.General.ServiceManager;
import com.example.bhrs.Login.LoginRequest;
import com.example.bhrs.Login.LoginResponse;
import com.example.bhrs.Login.Request;
import com.example.bhrs.Login.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static com.example.bhrs.General.ServiceManager.GenerateHeaderRequest;

public class AppointmentManager {


    public  static AppointmentListResponse GetAppointmentList()  {

        try {

            AppointmentListRequest lr = new AppointmentListRequest();
            lr.request = new ALRequest();
            lr.request.headerRequest = GenerateHeaderRequest();
            lr.request.id =Integer.parseInt( AccountManager.User.patientId);

            String result = ServiceManager.sendPostRequest("GetAppointmentList",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            AppointmentListResponse response = objectMapper.readValue(result, AppointmentListResponse.class);

            return  response;
        }
        catch (Exception e)
        {
            return  new AppointmentListResponse();
        }
    }


    public  static boolean CancelAppointment(String id)  {

        try {

            AppointmentListRequest lr = new AppointmentListRequest();
            lr.request = new ALRequest();
            lr.request.headerRequest = GenerateHeaderRequest();
            lr.request.id =Integer.parseInt(id);

            String result = ServiceManager.sendPostRequest("CancelAppointment",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            CancelAppointmentResponse response = objectMapper.readValue(result, CancelAppointmentResponse.class);
            if(response.hasError)
                throw  new Exception(response.errorMessage);

            return  response.response;
        }
        catch (Exception e)
        {
            return  false;
        }
    }


    public  static AvailableAppointmentResponse GetAvailableAppointments(String doctorId,String poliklinikId, String date)  {

        try {

            AvailableAppointmentRequest lr = new AvailableAppointmentRequest();
            lr.request = new AARequest();
            lr.request.headerRequest = GenerateHeaderRequest();
            lr.request.doctorId = doctorId;
            lr.request.poliklinikId = poliklinikId;
            lr.request.date = date;

            String result = ServiceManager.sendPostRequest("GetAvailableAppointments",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            AvailableAppointmentResponse response = objectMapper.readValue(result, AvailableAppointmentResponse.class);
            if(response.hasError)
                throw  new Exception(response.errorMessage);

            return  response;
        }
        catch (Exception e)
        {
            return  new AvailableAppointmentResponse();
        }
    }


    public  static boolean CreateAppointment(String id)  {

        try {

            CreateAppointmentRequest lr = new CreateAppointmentRequest();
            lr.request = new CARequest();
            lr.request.headerRequest = GenerateHeaderRequest();
            lr.request.id =id;
            lr.request.patientId = AccountManager.User.patientId;

            String result = ServiceManager.sendPostRequest("CreateAppointment",lr);

            ObjectMapper objectMapper = new ObjectMapper();
            CreateAppointmentResponse response = objectMapper.readValue(result, CreateAppointmentResponse.class);
            if(response.hasError)
                throw  new Exception(response.errorMessage);

            return  true;
        }
        catch (Exception e)
        {
            return  false;
        }
    }


}
