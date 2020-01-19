/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner entradaStr = new Scanner(System.in);
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
        datosAlumnos.agregarDato(0, "CALIFICACION");
        for (int i=1;i<datosAlumnos.getMatriz().size();i++){
            System.out.println("Ingresa la calificacion para " + datosAlumnos.getMatriz().get(i).get(3));
            datosAlumnos.agregarDato(i, entradaStr.nextLine());
        }
        
        ArrayList<ArrayList<String>> dataOutput = new ArrayList<ArrayList<String>>();
        
    }
    
}
