
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static practica3.Practica3.pJuego;

public class Congelacion extends Thread{
    public JLabel lCongelacion = new JLabel();
    public Rectangle recC = new Rectangle();
    public static PNuevoJuego panelC = new PNuevoJuego();
    public static int xc, yc, velocidadc;
    
    public Congelacion(int xc, int yc, PNuevoJuego panelC){
        super();
        this.xc = xc;
        this.yc = yc;
        this.panelC = panelC;
        this.velocidadc = 1;
        
        lCongelacion.setBounds(xc,yc,20,20);
        ImageIcon imagenC = new ImageIcon("elements\\Congelacion.png");
        Icon iconoC = new ImageIcon(imagenC.getImage().getScaledInstance(lCongelacion.getWidth(),
                                    lCongelacion.getHeight(), Image.SCALE_DEFAULT));
        lCongelacion.setIcon(iconoC);
        recC = new Rectangle(xc,yc,20,20);
        panelC.add(lCongelacion);
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(5);
                if (xc > -20) {
                    this.xc -= this.velocidadc;
                }
                cambiarpos(xc);
                if (Practica3.c1.recC.intersects(pJuego.rNAVE)) {
                    lCongelacion.setVisible(false);
                    Practica3.estaCongelado = true;
                    Practica3.veloNave = 0;
                    PPanelJuego.tiempoConge=0;
                    this.stop();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cambiarpos(int xnewat){
        this.lCongelacion.setLocation(xnewat, this.yc);// 
        this.recC.setLocation(xnewat, this.yc);
    }
    
}
