
package practica3;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JPanel;

public class PNuevoJuego extends JPanel{
    
    
    public PNuevoJuego(){
        setVisible(true);
        setLayout(null);
        setBackground(Color.black);
    }
    
    JLabel lNAVE;
    Rectangle rNAVE = new Rectangle();
    public void nave(){
        lNAVE = new JLabel();
        lNAVE.setVisible(true);
        lNAVE.setLayout(null);
        lNAVE.setBounds(60,250,35,35);
        lNAVE.setOpaque(true);
        ImageIcon imagenNAVE = new ImageIcon("elements\\nave2.png");
        Icon iconoNAVE = new ImageIcon(imagenNAVE.getImage().getScaledInstance(lNAVE.getWidth(),
                                    lNAVE.getHeight(), Image.SCALE_DEFAULT));
        lNAVE.setIcon(iconoNAVE);
        rNAVE.setBounds(60, 250, 35, 35);
        this.add(lNAVE);
    }
    
    JLabel lEnemigo1, lEnemigo2, lEnemigo3;
    public void enemigos(){
        
        lEnemigo1 = new JLabel();
        lEnemigo1.setVisible(true);
        lEnemigo1.setLayout(null);
        lEnemigo1.setBounds(600,4,35,35);
        lEnemigo1.setOpaque(true);
        ImageIcon imagenEnemigo1 = new ImageIcon("elements\\EnemigoTipo1.png");
        Icon iconoEnemigo1 = new ImageIcon(imagenEnemigo1.getImage().getScaledInstance(lEnemigo1.getWidth(),
                                    lEnemigo1.getHeight(), Image.SCALE_DEFAULT));
        lEnemigo1.setIcon(iconoEnemigo1);
        this.add(lEnemigo1);
        
        
        lEnemigo2 = new JLabel();
        lEnemigo2.setVisible(true);
        lEnemigo2.setLayout(null);
        lEnemigo2.setBounds(655,4,35,35);
        lEnemigo2.setOpaque(true);
        ImageIcon imagenEnemigo2 = new ImageIcon("elements\\EnemigoTipo2.png");
        Icon iconoEnemigo2 = new ImageIcon(imagenEnemigo2.getImage().getScaledInstance(lEnemigo2.getWidth(),
                                    lEnemigo2.getHeight(), Image.SCALE_DEFAULT));
        lEnemigo2.setIcon(iconoEnemigo2);
        this.add(lEnemigo2);
        
        
        lEnemigo3 = new JLabel();
        lEnemigo3.setVisible(true);
        lEnemigo3.setLayout(null);
        lEnemigo3.setBounds(710,4,35,35);
        lEnemigo3.setOpaque(true);
        ImageIcon imagenEnemigo3 = new ImageIcon("elements\\EnemigoTipo3.png");
        Icon iconoEnemigo3 = new ImageIcon(imagenEnemigo3.getImage().getScaledInstance(lEnemigo3.getWidth(),
                                    lEnemigo3.getHeight(), Image.SCALE_DEFAULT));
        lEnemigo3.setIcon(iconoEnemigo3);
        this.add(lEnemigo3);
    }

    void remove(Rectangle rectangle) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
