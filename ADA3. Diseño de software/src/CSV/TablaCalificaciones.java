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
    
    public void comenzarTabla(JTable tablaCalificaciones,Controlador controlador){
        //Inicializo tabla
        DefaultTableModel tablitaDeCalificaciones= new DefaultTableModel();
        ArrayList<ArrayList<String>> datosInput = controlador.getDatosOutput().getMatriz();
        
        
        tablitaDeCalificaciones.addColumn("Nombre");
        tablitaDeCalificaciones.addColumn("Materia");
        tablitaDeCalificaciones.addColumn("Calificación");
        
        Object[] fila= new Object[datosInput.get(0).size()];
        
        //Relleno de datos
        for(int i=0; i < datosInput.size(); i++){     //recorremos la matriz grande
            for (int j=0;j<datosInput.get(0).size();j++){
                fila[j] = datosInput.get(i).get(j);
            }
            tablitaDeCalificaciones.addRow(fila);
        }
        
        //Setea el modelo de tabla
        tablaCalificaciones.setModel(tablitaDeCalificaciones);
    }
}