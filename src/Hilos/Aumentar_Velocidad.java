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
    JProgressBar bar;
    

    public Aumentar_Velocidad(Usuario users[], int velocidad, JProgressBar bar) {
        this.users = users;
        this.velocidad = velocidad;
        this.bar = bar;
    }   
    
    @Override
    public void run(){
        try {                
            sleep(velocidad);
            for (int i = 0; i < users.length; i++) {
                Frame_Archivos.users.add(users[i]);
            }
        } catch (InterruptedException ex) {

        }
        bar.setIndeterminate(false);
        Frame_Archivos.users.show();
            
    }
}
