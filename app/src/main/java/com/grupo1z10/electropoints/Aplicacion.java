package com.grupo1z10.electropoints;

import android.app.Application;

import com.grupo1z10.electropoints.datos.LugaresLista;
import com.grupo1z10.electropoints.datos.RepositorioLugares;

public class Aplicacion extends Application {
    public RepositorioLugares lugares = new LugaresLista();
    @Override public void onCreate() {
        super.onCreate();
    }
    //get de repositoriolugares
    public RepositorioLugares getLugares() {
        return lugares;
    }
}
