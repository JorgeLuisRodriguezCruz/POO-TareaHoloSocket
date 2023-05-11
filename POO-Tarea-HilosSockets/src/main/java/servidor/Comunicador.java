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
                String msj = this.gestor.getEntrada().readUTF();
                System.out.println("Usa el boton "+ msj);
                
                System.out.println("\nSecunda lectura");
                int num = this.gestor.getEntrada().readInt();
                System.out.println("Numerico: " + num);
                num = num +5;
                System.out.println("Numerico mas 5: " + num);
                /*if (num == 1)
                    this.gestor.activar();*/
            }catch (IOException ex) {
            }
            this.corre = false;
            
            //this.corre = false;
        }
    }
    
}
