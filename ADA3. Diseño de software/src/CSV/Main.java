/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jimmy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        
        try{
            BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\jimmy\\Desktop\\ListaAlumnos.csv"));
            String line = br.readLine();
            while (line != null){
                String[] dataLine = line.split(",");
                ArrayList<String> tempData = new ArrayList<String>();
                for (String dato : dataLine){
                    tempData.add(dato);
                }
                data.add(tempData);
                line = br.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        TablaDeDatos datosAlumnos = new TablaDeDatos(data);
        for (int i=1;i<datosAlumnos.getMatriz().size();i++){
            datosAlumnos.agregarDato(i, "100");
            datosAlumnos.agregarDato(i, "100");
            datosAlumnos.agregarDato(i, "100");
            datosAlumnos.agregarDato(i, "100");
            datosAlumnos.agregarDato(i, "100");
        }
        System.out.println(datosAlumnos.toString());
    }
    
}
