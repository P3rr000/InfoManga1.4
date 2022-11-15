package com.example.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Login extends Activity implements View.OnClickListener {

    EditText user, pass;
    Button btnLogin, btnRegistrar;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        user=(EditText)findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.password);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

        btnLogin.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        if (sensor==null)
            finish();

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                else{
                    getWindow().getDecorView().setBackgroundColor(Color.DKGRAY);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);

        if (firstStart){
            primerAlerta();
        }

    }
    private void primerAlerta(){
        new AlertDialog.Builder(this)
                .setTitle("Hola bienvenido a InfoManga")
                .setMessage("Para poder pasar a la siguiente activity debes completar el login")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create().show();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Quieres salir de la apliacación?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                Intent i=new Intent(Login.this,InfoMangas.class);
                startActivity(i);
                break;
            case R.id.btnRegistrar:
                Intent ii=new Intent(Login.this,Registrar.class);
                startActivity(ii);
                break;
        }
    }
    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor, 2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}