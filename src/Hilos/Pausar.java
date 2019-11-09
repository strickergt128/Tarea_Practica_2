/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Otras_Clases.Usuario;

/**
 *
 * @author logas
 */
public class Pausar extends Thread{
    Thread hilo;
    boolean pausar;
    private Usuario users[];
    
    Pausar(String nombre){
    hilo= new Thread(this,nombre);
   pausar=false;
    }
    
    synchronized void pausarhilo(){
        pausar=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        pausar=false;
        notify();
    }
    
}
