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
public class Calificacion {
    private ArrayList<ArrayList<String>> matriz;
    
    public void agregarCalificacion(int numeroAlumno, String calificacion){
        this.matriz.get(numeroAlumno).add(calificacion);
    }
}
