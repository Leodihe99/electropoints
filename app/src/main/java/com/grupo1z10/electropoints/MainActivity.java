package com.grupo1z10.electropoints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lugar lugarNuevo= new Lugar("Casa", "Carrera 68g 9c-51",
                -73.121, 7.1377, TipoLugar.GASOLINERA, 30577,
                "http","", 5.0F);
        mensaje = findViewById(R.id.mensaje);
        mensaje.setText(lugarNuevo.toString());
        Log.d("TAG", "Objeto lugar encontrado"+ lugarNuevo.toString());
    }
}