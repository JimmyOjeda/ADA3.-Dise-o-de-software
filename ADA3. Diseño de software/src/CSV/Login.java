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
    
    public boolean comparePass(){
        return true;
    }
    
    
}
