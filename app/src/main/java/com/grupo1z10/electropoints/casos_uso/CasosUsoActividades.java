package com.grupo1z10.electropoints.casos_uso;

import android.app.Activity;
import android.content.Intent;

import com.grupo1z10.electropoints.presentacion.AcercaDeActivity;

public class CasosUsoActividades {

    protected Activity actividad;
    //constructor de la clase
    public CasosUsoActividades(Activity actividad) {
        this.actividad = actividad;
    }
    public void lanzarAcercaDe() {
        actividad.startActivity(new Intent(actividad,
                AcercaDeActivity.class));
    }
}
