package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
 * @author rodri
 */

public class Gestor implements ActionListener{
    
    private Socket cliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    
    private UIBoton ventana;

    public Gestor() {
        this.ventana = new UIBoton();
        
        this.conectarse();
    }
    
    public void conectarse () {
        this.ventana.getBoton().addActionListener(this);
        try {
            this.cliente = new Socket("127.0.0.1", 5555); 
            this.salida = new ObjectOutputStream(this.cliente.getOutputStream());
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
        }catch (Exception e){}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ventana.getBoton()){
            try {
                //this.salida.writeInt(1);
                this.salida.writeUTF("Capo");
                this.salida.flush();
                this.salida.writeInt(121);
                this.salida.flush();
                
            } catch (IOException ex) { }
        }
    }
    
    
}
