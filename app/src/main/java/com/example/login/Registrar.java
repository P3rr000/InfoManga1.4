package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText us,pas,nom,ap;
Button reg,can;
daoUsuario dao;

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
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegUser:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setContraseña(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellido(ap.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this,"No hay datos ingresados",Toast.LENGTH_LONG).show();
                }
                else if (dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Registrar.this,Login.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(this,"Usuario Existente",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegCancelar:
                Intent ii=new Intent(Registrar.this,Login.class);
                startActivity(ii);
                finish();
                break;
        }
    }
}