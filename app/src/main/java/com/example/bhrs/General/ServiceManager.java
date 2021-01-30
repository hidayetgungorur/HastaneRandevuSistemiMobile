package com.example.bhrs.General;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ServiceManager {
    public  static  String ServiceUrl="http://192.168.1.75:122/BHRSService.svc/rest/json";
    public static <T> String sendPostRequest(String methodType, T request) {
        try {

            String payload=GenerateRequest(request);

            URL url = new URL(ServiceUrl+ "/"+methodType);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
    public  static <T> String GenerateRequest(T object)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        }
        catch (Exception e)
        {
            return "";
        }
    }

    public   static  HeaderRequest GenerateHeaderRequest()
    {
        HeaderRequest rq = new HeaderRequest();
        rq.channelCode = "BHRSWeb";
        rq.channelPassword="SHFYM2020";
        return  rq;
    }



    // public  static <T> T GenerateResponse(String result)
    // {
    //  try {
    //       ObjectMapper objectMapper = new ObjectMapper();
    //      return objectMapper.readValue(result,T);
    // }
    //  catch (Exception e)
    //  {
    //      return null;
    // }
    //}



}
