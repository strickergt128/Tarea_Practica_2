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
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author dilan
 */
public class Aumentar_Velocidad extends Thread{
    JProgressBar bar;
    private Usuario users[];
    Thread hilo;
    boolean suspender; //Suspende un hilo cuando es true
    boolean pausar;    //Detiene un hilo cuando es true
    Aumentar_Velocidad (String nombre){
        hilo=new Thread(this,nombre);
        suspender=false;
        pausar=false;
    }
    public static Aumentar_Velocidad crearEIniciar(String nombre){
        Aumentar_Velocidad miHilo=new Aumentar_Velocidad(nombre);
        miHilo.hilo.start(); //Iniciar el hilo
        return miHilo;
    }
    public void crear(Usuario users[],JProgressBar bar){
        this.users = users;
        this.bar = bar;
    }
    public void run() {
        System.out.println(hilo.getName()+ " iniciando.");
        try {
            sleep(10000);
            for (int i = 0; i < users.length; i++) {                
                Frame_Archivos.users.add(users[i]);
                synchronized (this) {
                    while (suspender) {
                        wait();
                    }
                    if (pausar) break;
                }
            }
        }catch (InterruptedException exc){
            System.out.println(hilo.getName()+ "interrumpido.");
        }
        System.out.println(hilo.getName()+ " finalizado.");
        bar.setIndeterminate(false);
    }
    //Pausar el hilo
    public synchronized void pausarhilo(){
        pausar=true;
        //lo siguiente garantiza que un hilo suspendido puede detenerse.
        suspender=false;
        notify();
    }
    //Suspender un hilo
    public synchronized void suspenderhilo(){
        suspender=true;
    }
    //Renaudar un hilo
    public synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }

    
}
