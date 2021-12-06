
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static practica3.Practica3.pJuego;

public class Penalizacion extends Thread{
    public JLabel lPenalizacion = new JLabel();
    public Rectangle recP = new Rectangle();
    public static PNuevoJuego panelP = new PNuevoJuego();
    public static int xp, yp, velocidadp;
    
     public Penalizacion(int xp, int yp, PNuevoJuego panelP){
        super();
        this.xp = xp;
        this.yp = yp;
        this.panelP = panelP;
        this.velocidadp = 1;
        
        lPenalizacion.setBounds(xp,yp,20,20);
        ImageIcon imagenP = new ImageIcon("elements\\Penalizacion.png");
        Icon iconoP = new ImageIcon(
                imagenP.getImage().getScaledInstance(lPenalizacion.getWidth(),
                                    lPenalizacion.getHeight(), Image.SCALE_DEFAULT));
        lPenalizacion.setIcon(iconoP);
        recP = new Rectangle(xp,yp,20,20);
        panelP.add(lPenalizacion);
    }
     
    @Override
    public void run(){
        while(true){
            try {
                sleep(5);
                if(xp>-20){
                    this.xp -= this.velocidadp;
                }
                cambiarpos(xp);
                if(Practica3.p1.recP.intersects(pJuego.rNAVE)){
                    lPenalizacion.setVisible(false);
                    Practica3.pPanel.lPuntos.setText(String.valueOf((Integer.parseInt(Practica3.pPanel.lPuntos.getText())-10)));
                    
                    this.stop();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnewat){
        this.lPenalizacion.setLocation(xnewat, this.yp);
        this.recP.setLocation(xnewat,this.yp);
    }
    
}
