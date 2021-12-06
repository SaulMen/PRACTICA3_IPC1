
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static practica3.PPanelJuego.tiempoVelo;
import static practica3.Practica3.pJuego;

public class AumentoDeVelocidad extends Thread{
    public JLabel lAumentoDeVelocidad = new JLabel();
    public Rectangle recAV = new Rectangle();
    public static PNuevoJuego panelAV = new PNuevoJuego();
    public static int xav, yav, velocidadav;
    
    public AumentoDeVelocidad(int xav, int yav, PNuevoJuego panelAV){
        super();
        this.xav = xav;
        this.yav = yav;
        this.panelAV = panelAV;
        this.velocidadav = 1;
        
        lAumentoDeVelocidad.setBounds(xav,yav,20,20);
        ImageIcon imagenAV = new ImageIcon("elements\\AumentoDeVelocidad.png");
        Icon iconoAV = new ImageIcon(
                imagenAV.getImage().getScaledInstance(lAumentoDeVelocidad.getWidth(),
                                    lAumentoDeVelocidad.getHeight(), Image.SCALE_DEFAULT));
        lAumentoDeVelocidad.setIcon(iconoAV);
        recAV = new Rectangle(xav,yav,20,20);
        panelAV.add(lAumentoDeVelocidad);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(5);
                if (xav > -20) {
                    this.xav -= this.velocidadav;
                }
                cambiarpos(xav);
                if (Practica3.av1.recAV.intersects(pJuego.rNAVE)) {
                    lAumentoDeVelocidad.setVisible(false);
                    Practica3.veloNave = 12;
                    tiempoVelo=0;
                    this.stop();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cambiarpos(int xnewat){
        this.lAumentoDeVelocidad.setLocation(xnewat, this.yav);
        this.recAV.setLocation(xnewat, this.yav);
    }
    
}
