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
        for(int i=0;i<this.matriz.size();i++){
            ArrayList iArray = this.matriz.get(i);
            for (int j=0;j<iArray.size();j++){
                output = output+iArray.get(j)+",";
            }
            output = output.substring(0, output.length()-1);
            output = output + "\n";
        }
        return output;
    }
    
    public void userToString(PDFGraphics g2d){
        String output="";
        int cont=100;
        for(int i=0;i<this.matriz.size();i++){
            output="";
            ArrayList iArray = this.matriz.get(i);
            for (int j=0;j<iArray.size();j++){
                output = output+iArray.get(j)+" | ";
            }
            g2d.drawString(output, 40, cont);
            cont = cont+15;
        }
    }

    @Override
    public String toString() {
        return this.matriz+"";
    }
    
}
