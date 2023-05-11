package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @author rodri
 */

public class Gestor {
    
    private Socket cliente;
    private ServerSocket server;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    
    private UIEtiqueta ventana;
    
    private Comunicador comunicador;
    
    public Gestor() {
        this.ventana = new UIEtiqueta();
        this.comunicador = new Comunicador(this);
        
        this.conectarse();
    }
    
    public void activar () {
        this.ventana.setActivo( !this.ventana.getActivo());
    }
    
    public void conectarse () {
        try {
            this.server = new ServerSocket(5555);
            this.cliente = server.accept(); 
            this.salida = new ObjectOutputStream(this.cliente.getOutputStream());
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
            System.out.println("UUUH");
            this.comunicador.start();
            //this.ventana.blink();
        }catch (Exception e){}
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }
    
    
}
