package com.grupo1z10.electropoints.casos_uso;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.grupo1z10.electropoints.datos.RepositorioLugares;
import com.grupo1z10.electropoints.modelo.Lugar;
import com.grupo1z10.electropoints.presentacion.EdicionLugarActivity;
import com.grupo1z10.electropoints.presentacion.VistaLugarActivity;

public class CasosUsoLugar {

    private Activity actividad;
    private RepositorioLugares lugares;
    //constructor de la clase
    public CasosUsoLugar(Activity actividad, RepositorioLugares lugares) {
        this.actividad = actividad;
        this.lugares = lugares;
    }
    // OPERACIONES BÁSICAS
    public void mostrar(int pos) {
        Intent mostrar = new Intent(actividad, VistaLugarActivity.class);
        mostrar.putExtra("pos", pos);
        actividad.startActivity(mostrar);
    }
    public void borrar(final int id) {
        new AlertDialog.Builder(actividad)
                .setTitle("Borrado de lugar")
                .setMessage("¿Seguro de eliminar este lugar?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        lugares.borrar(id);
                        actividad.finish();
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }
    public void editar(int pos, int codigoSolicitud) {
        Intent intent_ed_lugar = new Intent(actividad,
                EdicionLugarActivity.class);
        intent_ed_lugar.putExtra("pos",pos);
        actividad.startActivityForResult(intent_ed_lugar,codigoSolicitud);
    }

    public void guardar(int id, Lugar nuevoLugar){
        lugares.actualiza(id,nuevoLugar);
    }

}
