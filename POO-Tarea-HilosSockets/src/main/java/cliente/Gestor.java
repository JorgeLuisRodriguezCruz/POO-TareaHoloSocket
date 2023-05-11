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
import javax.swing.JOptionPane;

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
                this.salida.writeInt(11);
                this.salida.flush();
                String msj = this.entrada.readUTF();
                JOptionPane.showMessageDialog(null, ""+msj, "Notificacion", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (IOException ex) { }
        }
    }
    
    
}
