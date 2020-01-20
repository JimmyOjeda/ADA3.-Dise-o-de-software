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
import java.io.PrintWriter;
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
        TablaDeDatos datosAlumnos = new TablaDeDatos(data);
        ArrayList<ArrayList<String>> dataOutput = new ArrayList<ArrayList<String>>();
        TablaDeDatos tableOutput = new TablaDeDatos(dataOutput);
        
        readCSV(data);
        
        writeGrade(datosAlumnos);
        
        setTable(datosAlumnos,tableOutput);
        
        writeCSV(tableOutput);
        
    }
    
    private static void readCSV(ArrayList<ArrayList<String>> data){
        try{
            BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\jimmy\\Documents\\NetBeansProjects\\ADA3.-Dise-o-de-software\\ListaAlumnos.csv"));
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
    }
    
    private static void writeGrade(TablaDeDatos datosAlumnos){
        datosAlumnos.agregarDato(0, "CALIFICACION");
        for (int i=1;i<datosAlumnos.getMatriz().size();i++){
            System.out.println("Ingresa la calificacion para " + datosAlumnos.getMatriz().get(i).get(3));
            datosAlumnos.agregarDato(i,"50"/*entradaStr.nextLine()*/);
        }
    }
    
    private static void setTable(TablaDeDatos datosAlumnos,TablaDeDatos tableOutput){
        for(int i = 1; i< datosAlumnos.getMatriz().size(); i++){
            ArrayList alumno = new ArrayList();
            alumno.add(datosAlumnos.getMatriz().get(i).get(0)+"");
            alumno.add("Diseño de software");
            alumno.add(datosAlumnos.getMatriz().get(i).get(5)+"");
            tableOutput.getMatriz().add(alumno);
        }
    }
    
    private static void writeCSV(TablaDeDatos tableOutput){
        String output = tableOutput.matrizToCSV();
        FileWriter file = null;
        PrintWriter pw = null;
        try
        {
            file = new FileWriter("C:\\Users\\jimmy\\Desktop\\FileOutput.csv");
            pw = new PrintWriter(file);
            pw.write(output);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != file)
              file.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
}