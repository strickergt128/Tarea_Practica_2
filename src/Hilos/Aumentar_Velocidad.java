/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Frames.Frame_Archivos;
import static Frames.Frame_Archivos.users;
import Otras_Clases.ListaCircularDoble;
import Otras_Clases.Usuario;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author dilan
 */
public class Aumentar_Velocidad extends Thread{
    private Usuario users[];
    private int velocidad;
    
    Thread hilo;
    boolean suspender; //Suspende un hilo cuando es true
    boolean pausar;    //Detiene un hilo cuando es true
    
    JProgressBar bar;
    

    public Aumentar_Velocidad(Usuario users[], int velocidad, JProgressBar bar) {
        this.users = users;
        this.velocidad = velocidad;
        this.bar = bar;
    }   

    public Aumentar_Velocidad(Usuario[] users, int velocidad, boolean suspender, boolean pausar, JProgressBar bar) {
        this.users = users;
        this.velocidad = velocidad;
        this.suspender = suspender;
        this.pausar = pausar;
        this.bar = bar;
    }
    
    Aumentar_Velocidad(String nombre){
    hilo=new Thread(this,nombre);
    suspender=false;
    pausar=false;
    }
    
    @Override
    public void run(){
        try {                
            sleep(velocidad);
            for (int i = 0; i < users.length; i++) {
                Frame_Archivos.users.add(users[i]);
                
            //---------------------------------------------    
                synchronized (this){
                while(suspender){
                wait();
                }
                if(pausar) break;
                }
            //---------------------------------------------    
            }
        } catch (InterruptedException ex) {

        }
        bar.setIndeterminate(false);
        Frame_Archivos.users.show();
        
    }  
   
    
    //Pausar el hilo
    public  void pausarhilo(){
        suspender=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        suspender=false;
        notify();
    }
    //Suspender un hilo   synchronized
    public void suspenderhilo(){
        suspender=true;
    }
    //Renaudar un hilo
    public void renaudarhilo(){
        suspender=false;
        notify();
    }
    
    
    
    }


