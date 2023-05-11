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
                int num = this.gestor.getEntrada().readInt();
                
                if (num == 11){
                    this.gestor.activar();
                    this.gestor.getSalida().writeUTF("La etiqueta a cambiado de estado");
                    this.gestor.getSalida().flush();
                }
            }catch (IOException ex) {
            }
            
        }
    }
    
}
