
package practica3;

import java.awt.Color;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.*;

public class PInicio extends JPanel{
    
    
    public PInicio(){
        setVisible(true);
        setLayout(null);
        setBackground(Color.black);
        componentes();
    }
    
    JButton bConfi;
    JButton bSalir;
    JButton bNuevo;
    JButton bPtsMax;
    public void componentes(){
        bConfi = new JButton("Config");
        bSalir = new JButton("Salir");
        bNuevo = new JButton("Nuevo Juego");
        bPtsMax = new JButton("Puntuación Maxima");
        
        bConfi.setVisible(true);
        bConfi.setBounds(0,0,80,80);
        bConfi.setLayout(null);
        this.add(bConfi);
        
        bSalir.setVisible(true);
        bSalir.setBounds(620,0,80,80);
        bSalir.setLayout(null);
        this.add(bSalir);
        
        bNuevo.setVisible(true);
        bNuevo.setBounds(250,420,200,50);
        bNuevo.setLayout(null);
        this.add(bNuevo);
        
        bPtsMax.setVisible(true);
        bPtsMax.setBounds(250,320,200,50);
        bPtsMax.setLayout(null);
        this.add(bPtsMax);
        
        JLabel lInvasores = new JLabel();
        lInvasores.setVisible(true);
        lInvasores.setLayout(null);
        lInvasores.setBounds(75,50,550,300);
        lInvasores.setOpaque(true);
        ImageIcon imagen = new ImageIcon("elements\\imagen2.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lInvasores.getWidth(),
                                    lInvasores.getHeight(), Image.SCALE_DEFAULT));
        lInvasores.setIcon(icono);
        this.add(lInvasores);
        
        
    }
}
