/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import Controlador.Controlador;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author plupy
 */
public class TablaCalificaciones {
    private Controlador controlador;
    
    public void comenzarTabla(JTable tablaCalificaciones){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        //Relleno de títulos
        titulos.add("Nombre alumno");                                                   
        titulos.add("Materia");
        titulos.add("Calificación");
        
        //Relleno de datos
        for(int i=0; i < controlador.getDatosOutput().getMatriz().size(); i++){     //recorremos la matriz grande
            Vector<Object> flecha = new Vector<Object>();
            ArrayList arrayDentro = controlador.getDatosOutput().getMatriz().get(i);    
            for(int j=0; j < arrayDentro.size(); j++){                              //recorremos las matrices pequeñas
                flecha.add(arrayDentro.get(j));     //obtiene el nombre completo del alumno, nombre de la materia y claificacion
            }
            datos.add(flecha);
        }
        
        DefaultTableModel tablitaDeCalificaciones = new DefaultTableModel(datos, titulos);
        tablaCalificaciones.setModel(tablitaDeCalificaciones);
        
    }
}