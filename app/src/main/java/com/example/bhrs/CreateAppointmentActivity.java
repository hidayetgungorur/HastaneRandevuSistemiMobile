package com.example.bhrs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bhrs.Appointment.AARequest;
import com.example.bhrs.Appointment.AAResponse;
import com.example.bhrs.Appointment.ALResponse;
import com.example.bhrs.Appointment.AppointmentListResponse;
import com.example.bhrs.Appointment.AppointmentManager;
import com.example.bhrs.Appointment.AvailableAppointmentResponse;
import com.example.bhrs.Appointment.Doctor.DResponse;
import com.example.bhrs.Appointment.Doctor.DoctorManager;
import com.example.bhrs.Appointment.Doctor.DoctorResponse;
import com.example.bhrs.Appointment.Poliklinik.PResponse;
import com.example.bhrs.Appointment.Poliklinik.PoliklinikManager;
import com.example.bhrs.Appointment.Poliklinik.PoliklinikResponse;
import com.example.bhrs.General.AccountManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateAppointmentActivity extends AppCompatActivity {
    private Spinner spPoliklinik ,spDoctor,spAvailableDate;
    private ArrayList<String> poliklinikIds  ;
    private ArrayList<String> doctorIds  ;
    private ArrayList<String> appointmentIds  ;
    private  String poliklinikId;
    private  String doctorId;
    private  String appointmentId;
    private CalendarView cVAvailable;
    private  String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment);

        spPoliklinik = (Spinner) findViewById(R.id.spPoliklinik);
        spDoctor = (Spinner) findViewById(R.id.spDoctor);
        spAvailableDate = (Spinner) findViewById(R.id.spAvailableDate);
        cVAvailable = (CalendarView) findViewById(R.id.cVAvailable);
        LoadPolikliniks();

        spPoliklinik.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                poliklinikId = poliklinikIds.get(position).toString();
                LoadPoliklinikDoctors();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        spDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                doctorId = doctorIds.get(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        spAvailableDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                appointmentId = appointmentIds.get(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        cVAvailable.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "." + (month+1) + "." + year;

            }
        });


    }

    public  void LoadPolikliniks()
    {
        ArrayList<String> poliklinikNames = new ArrayList<>();
        poliklinikIds = new ArrayList<>();
        PoliklinikResponse result   = PoliklinikManager.GetPolikliniks();
        if(!result.hasError)
        {
            for (PResponse res: result.response)
            {
                poliklinikIds.add( res.id);
                poliklinikNames.add(res.name);
            }
             ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
             android.R.layout.simple_spinner_item, poliklinikNames);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spPoliklinik.setAdapter(dataAdapter);
        }
        else Toast.makeText(CreateAppointmentActivity.this,"Poliklinik Bulunamadı.",Toast.LENGTH_SHORT).show();

    }


    public  void LoadPoliklinikDoctors()
    {
        ArrayList<String> doctorNames = new ArrayList<>();
        doctorIds = new ArrayList<>();
        DoctorResponse result   = DoctorManager.GetPoliklinikDoctors(poliklinikId);
        if(!result.hasError)
        {
            for (DResponse res: result.response)
            {
                doctorIds.add( res.id);
                doctorNames.add(res.name);
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, doctorNames);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spDoctor.setAdapter(dataAdapter);
        }
        else Toast.makeText(CreateAppointmentActivity.this,"Dcotor Bulunamadı.",Toast.LENGTH_SHORT).show();

    }


    public void OnclickGetAvailableAppointments(View view) {
        ArrayList<String> appointmentNames = new ArrayList<>();
        appointmentIds = new ArrayList<>();

        AvailableAppointmentResponse result   = AppointmentManager.GetAvailableAppointments(doctorId,poliklinikId,date);
        if(!result.hasError)
        {
            for (AAResponse res: result.response)
            {
                appointmentIds.add( res.id);
                appointmentNames.add(res.date);
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, appointmentNames);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spAvailableDate.setAdapter(dataAdapter);
        }
        else Toast.makeText(CreateAppointmentActivity.this,"Müsait Reandevu Bulunamadı.",Toast.LENGTH_SHORT).show();
    }


    public void OnclickCreateAppointment(View view) {
        boolean isCreateAppointment   = AppointmentManager.CreateAppointment(appointmentId);
        if(isCreateAppointment)
        {
            Toast.makeText(CreateAppointmentActivity.this,"Randevu Başarılı bir şekilde oluşturuldu.",Toast.LENGTH_SHORT).show();
            Intent ıntent = new Intent(this, HomeActivity.class);
            startActivity(ıntent);

        }
        else Toast.makeText(CreateAppointmentActivity.this,"Randevu Oluşturulamadı",Toast.LENGTH_SHORT).show();
    }


}