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
        ArrayList<String> titulos = controlador.getDatosOutput().getMatriz().get(0);
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
        
        //Relleno de datos
        for(int i=1; i < controlador.getDatosOutput().getMatriz().size(); i++){     //recorremos la matriz grande
            datos.add(controlador.getDatosOutput().getMatriz().get(i));
        }
        
        DefaultTableModel tablitaDeCalificaciones = new DefaultTableModel(datos, titulos);
        tablaCalificaciones.setModel(tablitaDeCalificaciones);
        
    }
}