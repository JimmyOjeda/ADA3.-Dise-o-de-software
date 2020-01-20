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
 * @author plupy
 */
public class Login {
    private String user;
    private String password;
    ArrayList<ArrayList<String>> datosUsers;

    public Login(String user, String password, ArrayList<ArrayList<String>> datosUsers) {
        this.user = user;
        this.password = password;
        this.datosUsers = datosUsers;
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
}
