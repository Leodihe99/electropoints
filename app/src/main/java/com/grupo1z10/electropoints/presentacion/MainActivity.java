package com.grupo1z10.electropoints.presentacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.grupo1z10.electropoints.Aplicacion;
import com.grupo1z10.electropoints.R;
import com.grupo1z10.electropoints.casos_uso.CasosUsoActividades;
import com.grupo1z10.electropoints.casos_uso.CasosUsoLugar;
import com.grupo1z10.electropoints.datos.RepositorioLugares;

public class MainActivity extends AppCompatActivity {

    private Button btnSalir;
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private CasosUsoActividades usoActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalir = findViewById(R.id.button04);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this,lugares);
        usoActividades = new CasosUsoActividades(this);

        //barra de acciones
        Toolbar toolbar = findViewById(R.id.toolbar_Main);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbar_layout_Main);
        toolbar.setTitle(getTitle());
        //Boton flotante FAB circular
        /**/
        FloatingActionButton fab =
                findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.mensaje_fab,
                        Snackbar.LENGTH_LONG).setAction("Accion",null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ajustes){
            Log.d("Tag en Main","Clic en la opcion ajustes");
            return true;
        }
        if (id == R.id.acercaDe){
            usoActividades.lanzarAcercaDe();
            return true;
        }
        if (id == R.id.menu_buscar){
            lanzarVistaLugar(null);
            Log.d("Tag main","clic a la opcion buscar");
            return true;
        }
        if (id == R.id.menu_usuario){
            return true;
        }
        if (id == R.id.menu_mapa){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //abrir acerca de
    public void lanzarAcercade(View view){
        Intent abrir = new Intent(this, AcercaDeActivity.class);
        startActivity(abrir);
    }

    public void lanzarVistaLugar(View view){
        final EditText entrada = new EditText(this);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de lugar")
                .setMessage("indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                int id = Integer.parseInt(entrada.getText().toString());
                                usoLugar.mostrar(id);
                            }})
                .setNegativeButton("Cancelar", null)
                .show();
    }
}