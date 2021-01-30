package com.example.bhrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhrs.General.AccountManager;
import com.example.bhrs.Login.UserInfo;

public class HomeActivity extends AppCompatActivity {
    TextView txtKullaniciBilgi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtKullaniciBilgi = (TextView)this.findViewById(R.id.txtKullaniciBilgi);
        UserInfo user = AccountManager.User;
        txtKullaniciBilgi.setText("Sayın " + user.firstName + " " + user.lastName);
    }

    public void OnclickLogout(View view) {
        AccountManager.User = null;
        Intent ıntent = new Intent(this, MainActivity.class);
        startActivity(ıntent);
    }

    public void OnclickUserInfo(View view) {
        Intent ıntent = new Intent(this, UpdateAccountActivity.class);
        startActivity(ıntent);
    }

    public void OnclickListAppointment(View view) {
        Intent ıntent = new Intent(this, ListAppointmentActivity.class);
        startActivity(ıntent);
    }

    public void OnclickCreateAppointment(View view) {
        Intent ıntent = new Intent(this, CreateAppointmentActivity.class);
        startActivity(ıntent);
    }
}