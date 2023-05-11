package servidor;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 
 * @author rodri
 */

public class UIEtiqueta {
    
    private JPanel panel;
    private JFrame frame;
    private JLabel blinker;
    
    private boolean activo;

    public UIEtiqueta() {
        this.frame = new JFrame("Tarea Hilos y Sockets");
        this.panel = new JPanel();
        this.blinker = new JLabel();
        
        this.iniciarComponentes();
    }
    
    private void iniciarComponentes () { 
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 140);
        this.frame.setLayout(null);
        
        this.panel.setSize(300, 140);
        this.panel.setBackground(Color.LIGHT_GRAY);
         
        blinker.setPreferredSize(new Dimension(300, 140));
        
        this.blinker.setOpaque(true);
        this.blinker.setBackground(Color.WHITE);
        
        this.panel.add(this.blinker);
        
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
    
    public void blink(){
        
        while(true){
            System.out.println("Estado activo ---> "+ this.activo);
            if (this.activo){
                try {
                    this.blinker.setBackground(Color.YELLOW);
                    Thread.sleep(500);
                    this.blinker.setBackground(Color.WHITE);
                    Thread.sleep(500);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public boolean getActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

}
