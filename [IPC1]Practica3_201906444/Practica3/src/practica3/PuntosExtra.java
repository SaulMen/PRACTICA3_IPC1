
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static practica3.Practica3.pJuego;

public class PuntosExtra extends Thread{
    public JLabel lPuntosExtra = new JLabel();
    public Rectangle recPE = new Rectangle();
    public static PNuevoJuego panelPE = new PNuevoJuego();
    public static int xpe,ype,velocidadpe;
    
    public PuntosExtra(int xpe,int ype, PNuevoJuego panelPE){
        super();
        this.xpe= xpe;
        this.ype = ype;
        this.panelPE = panelPE;
        this.velocidadpe=1;
        
        lPuntosExtra.setBounds(xpe,ype,20,20);
        ImageIcon imagenPE = new ImageIcon("elements\\PuntosExtra.png");
        Icon iconoPE = new ImageIcon(
                imagenPE.getImage().getScaledInstance(lPuntosExtra.getWidth(),
                                    lPuntosExtra.getHeight(), Image.SCALE_DEFAULT));
        lPuntosExtra.setIcon(iconoPE);
        recPE = new Rectangle(xpe,ype,20,20);
        panelPE.add(lPuntosExtra);
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(5);
                if(xpe>-20){
                    this.xpe -= this.velocidadpe;
                }
                cambiarpos(xpe);
                if(Practica3.pe1.recPE.intersects(pJuego.rNAVE)){
                    lPuntosExtra.setVisible(false);
                    Practica3.pPanel.lPuntos.setText(String.valueOf((Integer.parseInt(Practica3.pPanel.lPuntos.getText())+10)));
                    this.stop();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnewat){
        this.lPuntosExtra.setLocation(xnewat, this.ype);
        this.recPE.setLocation(xnewat,this.ype);
    }
    
}
