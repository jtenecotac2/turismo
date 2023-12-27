package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import webservices.Asynchtask;
import webservices.WebService;

public class MainActivity extends AppCompatActivity  implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btEnviar(View view){
//Creamos el Intent
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//Creamos la información a pasar entre actividades - Pares Key-Value
        Bundle b = new Bundle();
//Añadimos la información al intent
        intent.putExtras(b);
// Iniciamos la nueva actividad
        startActivity(intent);
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
    }
    @Override
    public void processFinish(String result) throws JSONException {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        TextView txtrespuesta = findViewById(R.id.txtresultado);
        //validacion
        if (result.equals("login correcto!")){
            startActivity(intent);
        }
        else {
            txtrespuesta.setText(result);
        }
        txtrespuesta.setText(result);

    }
}