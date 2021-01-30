package com.example.bhrs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import  com.example.bhrs.Appointment.ALResponse;

import com.example.bhrs.Account.AccountManager;
import com.example.bhrs.Appointment.AppointmentListResponse;
import com.example.bhrs.Appointment.AppointmentManager;

import java.util.ArrayList;
import java.util.List;

public class ListAppointmentActivity extends AppCompatActivity {
    ListView lstAppointment;
    private ArrayList<String> list ;
    private ArrayList<String> ids ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appointment);
         lstAppointment=(ListView) findViewById(R.id.lstAppointment);
        LoadAppointments();

        lstAppointment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ListAppointmentActivity.this);
                dialog.setTitle("Randevunuz Iptal Edilsin mi ?");
                dialog.setMessage(list.get(position));

                dialog.setNegativeButton("Hayır", null);
                dialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id = ids.get(position);

                        boolean isCancel   = AppointmentManager.CancelAppointment(id);
                        if(isCancel)
                        {
                            Toast.makeText(ListAppointmentActivity.this, "Randevunuz Başarılı bir şekilde iptal edildi.",Toast.LENGTH_SHORT).show();
                            Intent ıntent = new Intent(ListAppointmentActivity.this, HomeActivity.class);
                            startActivity(ıntent);

                        }
                        else Toast.makeText(ListAppointmentActivity.this,"Randevunuz daha önce iptal edilmiş.",Toast.LENGTH_SHORT).show();

                    }
                });




                dialog.create().show();
            }
        });
    }

    public  void LoadAppointments()
    {  list = new ArrayList<>();
       ids = new ArrayList<>();
        AppointmentListResponse result   = AppointmentManager.GetAppointmentList();
        if(!result.hasError)
        {
            for (ALResponse res: result.response)
            {
                ids.add( res.id);
                list.add(res.date + " - " + res.poliklinikName + " - " + res.doctorName + " - " + res.status);
            }
            ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, list);

            lstAppointment.setAdapter(veriAdaptoru);
        }
        else Toast.makeText(ListAppointmentActivity.this,"Randevu Bulunamadı.",Toast.LENGTH_SHORT).show();


    }

}