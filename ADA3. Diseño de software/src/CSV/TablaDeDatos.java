/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import com.qoppa.pdfWriter.PDFGraphics;
import java.util.ArrayList;

/**
 *
 * @author plupy
 */
public class TablaDeDatos {
    private ArrayList<ArrayList<String>> matriz;
    
    public TablaDeDatos(ArrayList<ArrayList<String>> matriz) {
        this.matriz = matriz;
    }

    public ArrayList<ArrayList<String>> getMatriz() {
        return matriz;
    }

    public void setMatriz(ArrayList<ArrayList<String>> matriz) {
        this.matriz = matriz;
    }
    
    public void agregarDato(int numeroAlumno, String dato){
        this.matriz.get(numeroAlumno).add(dato);
    }
    
    public String matrizToCSV(){
        String output = "";
        for(int i=0;i<this.matriz.size();i++){      //recorre matriz grande (matriz de matrices)
            ArrayList iArray = this.matriz.get(i);  
            for (int j=0;j<iArray.size();j++){      //se recorren las matrices de adentro
                output = output+iArray.get(j)+",";  //se separan los elementos por ","
            }
            output = output.substring(0, output.length()-1);    //Quita el ultimo elemento de la string
            output = output + "\n";     
        }
        return output;
    }
    
    public void userToString(PDFGraphics g2d){
        String output="";
        int cont=100;       //espacio donde se acomodará en el pdf
        for(int i=0;i<this.matriz.size();i++){      //se recorre la matriz grande (matriz de matrices)
            output="";
            ArrayList iArray = this.matriz.get(i);
            for (int j=0;j<iArray.size();j++){      //se recorre las matrices de adentro
                output = output+iArray.get(j)+" | ";    //se separan los elementos por "|"
            }
            g2d.drawString(output, 40, cont);       //se escribe en el pdf 
            cont = cont+15;                         //mueve el espacio donde se acomodará el siguiente alumno en el pdf
        }
    }

    @Override
    public String toString() {
        return this.matriz+"";
    }
    
}
