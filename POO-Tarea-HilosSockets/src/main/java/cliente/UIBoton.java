package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @author rodri
 */

public class UIBoton { 
    
    private JPanel panel;
    private JFrame frame;
    private JButton boton;

    public UIBoton() {
        this.frame = new JFrame("Tarea Hilos y Sockets");
        this.panel = new JPanel();
        this.boton = new JButton("Encender");
        
        this.iniciarComponentes();
    }
    
    private void iniciarComponentes () { 
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 140);
        this.frame.setLayout(null);
        
        this.boton.setSize(14,5);
        
        this.panel.setSize(300, 140);
        this.panel.setBackground(Color.LIGHT_GRAY); 
        this.panel.add(this.boton, BorderLayout.CENTER);
        
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }

    public JButton getBoton() {
        return boton;
    }
    
}
