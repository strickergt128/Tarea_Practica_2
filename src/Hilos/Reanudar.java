/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author logas
 */
public class Reanudar  extends  Thread {
    
    Thread hilo;
    boolean suspender;
    
    Reanudar(String users){
    hilo= new Thread(this,users);
    
    
    }
    @Override
    public void run() {
    
    
    }
    //Renaudar un hilo
    synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }
    
}
