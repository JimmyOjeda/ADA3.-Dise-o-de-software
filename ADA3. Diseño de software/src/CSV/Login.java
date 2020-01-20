/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSV;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


/**
 *
 * @author plupy
 */
public class Login {
    private String user;
    private String password;
    ArrayList<ArrayList<String>> datosUsers;

    
    //Constructor
    public Login(String user, String password, ArrayList<ArrayList<String>> datosUsers) {
        this.user = user;
        this.password = password;
        this.datosUsers = datosUsers;
    }

    //funciones get
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<ArrayList<String>> getDatosUsers() {
        return datosUsers;
    }

    //funciones set
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatosUsers(ArrayList<ArrayList<String>> datosUsers) {
        this.datosUsers = datosUsers;
    }
    
    //demas funciones
    public String encriptarPass(String password){   //función para encriptar en MD5 la contraseña
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return generatedPassword;   //Aquí regresa la contraseña encriptada
    }
    
    public boolean comparePass(){
        return true;
    }
    
}
