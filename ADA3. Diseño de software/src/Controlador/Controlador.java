/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import CSV.TablaDeDatos;
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
 * @author jimmy
 */
public class Controlador {
    VentanaCapturaCalificaciones capturaCalificaciones;
    VentanaLogin login;
    VentanaPrincipal principal;
    TablaDeDatos datos;
    TablaDeDatos datosOutput;

    public Controlador(VentanaCapturaCalificaciones capturaCalificaciones, VentanaLogin login, VentanaPrincipal principal) {
        this.capturaCalificaciones = capturaCalificaciones;
        this.login = login;
        this.principal = principal;
        
        this.capturaCalificaciones.setControlador(this);
        this.login.setControlador(this);
        this.principal.setControlador(this);
    }

    public void setCapturaCalificaciones(VentanaCapturaCalificaciones capturaCalificaciones) {
        this.capturaCalificaciones = capturaCalificaciones;
    }

    public void setLogin(VentanaLogin login) {
        this.login = login;
    }

    public void setPrincipal(VentanaPrincipal principal) {
        this.principal = principal;
    }

    public void setDatos(TablaDeDatos datos) {
        this.datos = datos;
    }

    public void setDatosOutput(TablaDeDatos datosOutput) {
        this.datosOutput = datosOutput;
    }
    

    public VentanaCapturaCalificaciones getCapturaCalificaciones() {
        return capturaCalificaciones;
    }

    public VentanaLogin getLogin() {
        return login;
    }

    public VentanaPrincipal getPrincipal() {
        return principal;
    }

    public TablaDeDatos getDatos() {
        return datos;
    }

    public TablaDeDatos getDatosOutput() {
        return datosOutput;
    }
    
    public void readCSV(ArrayList<ArrayList<String>> data, String route){
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
    
    public void writeGrade(TablaDeDatos datosAlumnos){
        Scanner entradaStr = new Scanner(System.in);
        String grade="";
        datosAlumnos.agregarDato(0, "Calificación");
        for (int i=1;i<datosAlumnos.getMatriz().size();i++){
            grade = "S/C";
            /*grade = entradaStr.nextLine();
            if (grade.isEmpty() || grade == " "){
                grade = "S/C";
            }*/
            datosAlumnos.agregarDato(i,/*"50"*/grade);
        }
    }
    
    public void setTableOutput(TablaDeDatos datosAlumnos, TablaDeDatos tableOutput){
        
        for(int i = 0; i < datosAlumnos.getMatriz().size(); i++){
            ArrayList alumno = new ArrayList();
            alumno.add(datosAlumnos.getMatriz().get(i).get(0)+"");
            alumno.add("Diseño de software");
            alumno.add(datosAlumnos.getMatriz().get(i).get(5)+"");
            tableOutput.getMatriz().add(alumno);
        }
        
    }
    
    public void writeCSV(TablaDeDatos tableOutput){
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
    
    public void writePDF(TablaDeDatos tableOutput){
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
    }
    
}
