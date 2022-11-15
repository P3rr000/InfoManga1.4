package com.example.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class InfoMangas extends Activity implements View.OnClickListener {
Button btnEditar, btnMostrar, btnSalir;
TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomangas);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
    }
    public void MostrarLista(View view) {
        Intent mostrarLista = new Intent(this, CardViewUno.class);
        startActivity(mostrarLista);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnEditar:
                Intent e=new Intent(InfoMangas.this,Editar.class);
                startActivity(e);
                break;
            case R.id.btnMostrar:
                Intent m=new Intent(InfoMangas.this,Mostrar.class);
                startActivity(m);
                break;
            case R.id.btnSalir:
                Intent s=new Intent(InfoMangas.this,Login.class);
                startActivity(s);
                finish();
                break;
        }
    }
}