package com.example.bhrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhrs.Account.ARequest;
import com.example.bhrs.Account.AccountRequest;
import com.example.bhrs.Account.AccountManager;

public class CreateAccountActivity extends AppCompatActivity {
    EditText txtFirstName;
    EditText txtLastName;
    EditText txtTC;
    EditText txtBirthDate;
    EditText txtPhone;
    EditText txtEMail;
    EditText txtPassword;
    RadioButton chbMale;
    RadioButton chbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        txtFirstName = (EditText)this.findViewById(R.id.txtFirstName);
        txtLastName = (EditText)this.findViewById(R.id.txtLastName);
        txtTC = (EditText)this.findViewById(R.id.txtTC);
        txtBirthDate = (EditText)this.findViewById(R.id.txtBirthDate);
        txtPhone = (EditText)this.findViewById(R.id.txtPhone);
        txtEMail = (EditText)this.findViewById(R.id.txtEMail);
        txtPassword = (EditText)this.findViewById(R.id.txtPassword);
        chbMale = (RadioButton) this.findViewById(R.id.chbMale);
        chbFemale = (RadioButton) this.findViewById(R.id.chbFemale);

    }

    public void OnclickCancel(View view) {
        Intent ıntent = new Intent(this, MainActivity.class);
        startActivity(ıntent);
    }

    public void OnclickSave(View view) {

        AccountRequest req = new AccountRequest();
        req.request = new ARequest();
        req.request.firstName = txtFirstName.getText().toString();
        req.request.lastName =txtLastName.getText().toString();
        req.request.tC =txtTC.getText().toString();
        req.request.birthDate =txtBirthDate.getText().toString();
        req.request.phone = txtPhone.getText().toString();
        req.request.email=txtEMail.getText().toString();
        req.request.password =txtPassword.getText().toString();
        if (chbMale.isChecked())
            req.request.genderType = 0;
        else  req.request.genderType = 1;

        boolean isCreateAccount   = AccountManager.CreateAccount(req);
        if(isCreateAccount)
        {
            Toast.makeText(CreateAccountActivity.this, "Kaydınız Başarılı bir şekilde oluştu",Toast.LENGTH_SHORT).show();
            Intent ıntent = new Intent(this, MainActivity.class);
            startActivity(ıntent);

        }
        else Toast.makeText(CreateAccountActivity.this,"Kullanıcı Bilgileri Geçersiz.",Toast.LENGTH_SHORT).show();

    }

}