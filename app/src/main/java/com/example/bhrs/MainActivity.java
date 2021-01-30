package com.example.bhrs;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhrs.General.AccountManager;
import  com.example.bhrs.Login.LoginManager;
import  com.example.bhrs.Login.LoginRequest;
import com.example.bhrs.Login.LoginResponse;
import com.example.bhrs.Login.Request;
import android.os.StrictMode;

public class MainActivity extends AppCompatActivity {
    LoginManager   loginManager = new LoginManager();
    EditText txtUserName ;
    EditText txtPassword ;
    CheckBox chbIsDoctor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);//response alınması için zorunludur.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtUserName = (EditText)this.findViewById(R.id.txtKullaniciAdi);
         txtPassword = (EditText)this.findViewById(R.id.txtPassword);
        chbIsDoctor = (CheckBox)this.findViewById(R.id.chbIsDoctor);

    }
    public void OnclickLogin(View view) {

            boolean isLogin   = loginManager.Login(txtUserName.getText().toString(),txtPassword.getText().toString(),chbIsDoctor.isChecked());
            if(isLogin)
            {
                Toast.makeText(MainActivity.this, AccountManager.User.firstName,Toast.LENGTH_SHORT).show();
                Intent ıntent = new Intent(this, HomeActivity.class);
                startActivity(ıntent);

            }
            else Toast.makeText(MainActivity.this,"Kullanıcı Bilgileri Geçersiz.",Toast.LENGTH_SHORT).show();
    }

    public void OnclickCreateAccount(View view) {
        Intent ıntent = new Intent(this, CreateAccountActivity.class);
        startActivity(ıntent);
    }


}