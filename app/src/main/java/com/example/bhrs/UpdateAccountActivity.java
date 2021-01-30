package com.example.bhrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.bhrs.Account.ARequest;
import com.example.bhrs.Account.AccountRequest;
import com.example.bhrs.General.AccountManager;
import com.example.bhrs.Login.UserInfo;

public class UpdateAccountActivity extends AppCompatActivity {
    EditText txtFirstName;
    EditText txtLastName;
    EditText txtTC;
    EditText txtBirthDate;
    EditText txtPhone;
    EditText txtEMail;
    EditText txtPassword;
    RadioButton chbMale;
    RadioButton chbFemale;
    UserInfo user = AccountManager.User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);

        txtFirstName = (EditText)this.findViewById(R.id.txtFirstName);
        txtLastName = (EditText)this.findViewById(R.id.txtLastName);
        txtTC = (EditText)this.findViewById(R.id.txtTC);
        txtBirthDate = (EditText)this.findViewById(R.id.txtBirthDate);
        txtPhone = (EditText)this.findViewById(R.id.txtPhone);
        txtEMail = (EditText)this.findViewById(R.id.txtEMail);
        txtPassword = (EditText)this.findViewById(R.id.txtPassword);
        chbMale = (RadioButton) this.findViewById(R.id.chbMale);
        chbFemale = (RadioButton) this.findViewById(R.id.chbFemale);

        txtFirstName.setText(user.firstName);
        txtLastName.setText(user.lastName);
        txtTC.setText(user.tC);
        txtBirthDate.setText(user.birthDate);
        txtPhone.setText(user.phone);
        txtEMail.setText(user.email);
        txtPassword.setText(user.password);
        if (user.genderType == 0)
            chbMale.setChecked(true);
        else chbFemale.setChecked(true);

    }


    public void OnclickCancel(View view) {
        Intent ıntent = new Intent(this, HomeActivity.class);
        startActivity(ıntent);
    }

    public void OnclickUpdate(View view) {
        AccountRequest req = new AccountRequest();
        req.request = new ARequest();
        req.request.userId =Integer.parseInt(user.userId);
        req.request.phone = txtPhone.getText().toString();
        req.request.email=txtEMail.getText().toString();
        req.request.password =txtPassword.getText().toString();

        boolean isCreateAccount   = com.example.bhrs.Account.AccountManager.UpdateAccount(req);
        if(isCreateAccount)
        {
            Toast.makeText(UpdateAccountActivity.this, "Bilgileriniz Başarılı bir şekilde güncellendi",Toast.LENGTH_SHORT).show();
            Intent ıntent = new Intent(this, HomeActivity.class);
            startActivity(ıntent);

        }
        else Toast.makeText(UpdateAccountActivity.this,"Hatalı işlem",Toast.LENGTH_SHORT).show();


    }

}