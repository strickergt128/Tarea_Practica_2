/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otras_Clases;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author dilan
 */
public class Leer_Archivo {
    static public String leerDocumento(String direccion){
        String texto = "";
        
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){   
                temp += bfRead+"\n"; 
            }
            
            texto = temp;
            
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        }
        return texto;
    }
}
