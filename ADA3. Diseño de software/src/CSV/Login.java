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
    public boolean comparePass(){
        return true;
    }
    
}
