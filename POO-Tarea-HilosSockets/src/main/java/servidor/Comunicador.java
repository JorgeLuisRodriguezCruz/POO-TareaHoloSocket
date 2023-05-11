package servidor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author rodri
 */

public class Comunicador extends Thread {
    
    private Gestor gestor;
    
    private boolean corre;

    public Comunicador(Gestor gestor) {
        this.gestor = gestor;
        
        this.corre = true;
    }
    
    @Override
    public void run () {
        
        while (this.corre) {
            try { 
                System.out.println("Aqui llego");
                int num = (int)this.gestor.getEntrada().readInt();
                System.out.println("Este es el num: " + num);
                
                /*if (num == 1)
                    this.gestor.activar();*/
            }catch (IOException ex) {
            }
            this.corre = false;
            
            //this.corre = false;
        }
    }
    
}
