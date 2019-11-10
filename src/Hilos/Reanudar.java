
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
