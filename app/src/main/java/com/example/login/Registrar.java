package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText us,pas,nom,ap;
Button reg,can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us=(EditText)findViewById(R.id.regUser);
        pas=(EditText)findViewById(R.id.regPassword);
        nom=(EditText)findViewById(R.id.regNombre);
        ap=(EditText)findViewById(R.id.regApellido);
        reg=(Button)findViewById(R.id.btnRegUser);
        can=(Button)findViewById(R.id.btnRegCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegUser:
                break;
            case R.id.btnRegCancelar:
                Intent ii=new Intent(Registrar.this,Login.class);
                startActivity(ii);
                break;
        }
    }
}