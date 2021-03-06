/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import Controlador.Controlador;
import Vista.VentanaCapturaCalificaciones;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFGraphics;
import com.qoppa.pdfWriter.PDFPage;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Jimmy y Daniel
 * 
    //Crear el algoritmo de encritamiento 30min
    //Crear algoritmo para comparar contraseña encriptada y adaptar al main 40min
    //Modularizar el main 20min
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TablaDeDatos datosAlumnos = new TablaDeDatos(new ArrayList<ArrayList<String>>());
        TablaDeDatos tableOutput = new TablaDeDatos(new ArrayList<ArrayList<String>>());
        
        //Inicializo las ventanas
        VentanaCapturaCalificaciones capturaCalificaciones = new VentanaCapturaCalificaciones();
        VentanaLogin login = new VentanaLogin();
        VentanaPrincipal principal = new VentanaPrincipal();
        
        //Inicializo el controlador
        Controlador controlador = new Controlador(capturaCalificaciones,login,principal);
        controlador.setDatos(datosAlumnos);
        controlador.setDatosOutput(tableOutput);
        
        //Se muestra el login
        controlador.getLogin().setVisible(true);
        
        //Se lee el CSV con los datos y se les escribe "S/C" como calificación
        controlador.readCSV(controlador.getDatos().getMatriz(),"ListaAlumnos.csv");
        controlador.writeGrade(controlador.getDatos());
        
        
        //VIEJO CODIGO
        /*
        login();
        
        readCSV(data,"ListaAlumnos.csv");
        
        writeGrade(datosAlumnos);
        
        setTable(datosAlumnos,tableOutput);
        
        writeCSV(tableOutput);
        
        writePDF(tableOutput);
        */
       
    }
    
    /*private static void login(){
        Scanner entradaStr = new Scanner(System.in);
        ArrayList<ArrayList<String>> datosUsers = new ArrayList<ArrayList<String>>();
        readCSV(datosUsers,"usuarios.csv");
        
        System.out.println("Ingresa tu usuario");
        String firstUser="";
        firstUser=entradaStr.nextLine();
        System.out.println("Ingresa la contraseña");
        String firstPassword="";
        firstPassword=entradaStr.nextLine();
        Login login = new Login(firstUser,firstPassword,datosUsers);
        
        while (login.comparePass()==false){
            System.out.println("\n\nUsuario o contraseña incorrecta, intenta de nuevo:");
            System.out.println("Usuario:");
            login.setUser(entradaStr.nextLine());
            System.out.println("Contraseña:");
            login.setPassword(entradaStr.nextLine());
        }
        System.out.println("\n\nBienvenido "+login.getUser());
    }
    
    private static void readCSV(ArrayList<ArrayList<String>> data, String route){
        try{
            BufferedReader br =new BufferedReader(new FileReader(route));
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
        Scanner entradaStr = new Scanner(System.in);
        String grade="";
        datosAlumnos.agregarDato(0, "CALIFICACION");
        for (int i=1;i<datosAlumnos.getMatriz().size();i++){
            System.out.println("Ingresa la calificacion para " + datosAlumnos.getMatriz().get(i).get(2) +" "+ datosAlumnos.getMatriz().get(i).get(4));
            grade = entradaStr.nextLine();
            if (grade.isEmpty() || grade == " "){
                grade = "S/C";
            }
            datosAlumnos.agregarDato(i,grade);
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
            file = new FileWriter("FileOutput.csv");
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
    
    private static void writePDF(TablaDeDatos tableOutput){
        try{
            PDFDocument doc = new PDFDocument();
            // create a PageFormat of standard letter size 
            // with no margins
            Paper p = new Paper ();
            p.setSize(8.5 * 72, 11 * 72);
            p.setImageableArea(0, 0, 8.5 * 72, 11 * 72);
            PageFormat pf = new PageFormat ();
            pf.setPaper(p);

            // create a new page and add it to the PDF (important!)
            PDFPage page = doc.createPage(pf);
            doc.addPage(page);
            
            // get graphics from the page
            // this object is a Graphics2D Object and you can draw anything 
            // you would draw on a Graphics2D
            PDFGraphics g2d = (PDFGraphics) page.createGraphics();
            
            //Setea el color y tamaño
            g2d.setFont(PDFGraphics.HELVETICA.deriveFont(11));
            g2d.setColor(Color.BLACK);
            
            
            //Escribe los textos en el pdf
            tableOutput.userToString(g2d);
            g2d.setColor(Color.BLUE);
            g2d.drawString("Calificaciones", 250, 50);
            
            
            //Lee la imagen
            BufferedImage image = ImageIO.read(new File("logoUady.png"));

            //Imprime la imagen en el pdf
            g2d.drawImage(image, 450, 10, null);
            //Guarda el archivo
            doc.saveDocument ("doc.pdf");
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
    
}