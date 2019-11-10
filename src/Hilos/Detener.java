/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Frames.Frame_Archivos;
import Otras_Clases.Usuario;
import java.awt.TextArea;


public class Detener implements Runnable {
    
    Thread hilo;
    boolean suspender;
    boolean pausar;
    
 Detener(String usuario){
     hilo = new Thread(this, usuario);
     suspender= false;
     pausar= false;
 }
 public void run(){
 System.out.println(Frame_Archivos.users);
 
 }
}
