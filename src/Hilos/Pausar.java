/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Otras_Clases.Usuario;
import java.awt.Color;
import static java.lang.Thread.sleep;

/**
 *
 * @author logas
 */
public class Pausar extends Thread{

    
    Thread hilo;
    boolean pausar;
    
    private Usuario users[];
    
    Pausar(String users){
    hilo= new Thread(this,users);
   pausar=false;
    }
    
    public  void pausarhilo(){
        pausar=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        pausar=false;
        notify();
    }

    public Pausar(Thread hilo, boolean pausar, Usuario[] users) {
        this.hilo = hilo;
        this.pausar = pausar;
        this.users = users;
       
    }
    
    public void run(){
    while(pausar){

            try {
                sleep(1000);
            } catch (Exception e) {
            }
            
        }  
    
    }
    
    public void start() {
       pausar = true;
       new Thread(this).start();
    }
}
