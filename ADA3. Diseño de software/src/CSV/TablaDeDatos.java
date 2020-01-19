/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import java.util.ArrayList;

/**
 *
 * @author plupy
 */
public class TablaDeDatos {
    private ArrayList<ArrayList<String>> matriz;

    public ArrayList<ArrayList<String>> getMatriz() {
        return matriz;
    }

    public void setMatriz(ArrayList<ArrayList<String>> matriz) {
        this.matriz = matriz;
    }

    public TablaDeDatos(ArrayList<ArrayList<String>> matriz) {
        this.matriz = matriz;
    }
    
    public void agregarDato(int numeroAlumno, String dato){
        this.matriz.get(numeroAlumno).add(dato);
    }

    @Override
    public String toString() {
        return this.matriz+"";
    }
    
}
