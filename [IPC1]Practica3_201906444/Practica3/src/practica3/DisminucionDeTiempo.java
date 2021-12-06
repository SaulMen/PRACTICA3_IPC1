
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static practica3.Practica3.pJuego;

public class DisminucionDeTiempo extends Thread{
    public JLabel lDisminucionDeTiempo = new JLabel();
    public Rectangle recDT = new Rectangle();
    public static PNuevoJuego panelDT = new PNuevoJuego();
    public static int xdt,ydt,velocidaddt;
    
    public DisminucionDeTiempo(int xdt,int ydt, PNuevoJuego panelDT){
        super();
        this.xdt= xdt;
        this.ydt = ydt;
        this.panelDT = panelDT;
        this.velocidaddt=1;
        
        lDisminucionDeTiempo.setBounds(xdt,ydt,20,20);
        ImageIcon imagenDT = new ImageIcon("elements\\DisminucionDeTiempo.png");
        Icon iconoDT = new ImageIcon(
                imagenDT.getImage().getScaledInstance(lDisminucionDeTiempo.getWidth(),
                                    lDisminucionDeTiempo.getHeight(), Image.SCALE_DEFAULT));
        lDisminucionDeTiempo.setIcon(iconoDT);
        recDT = new Rectangle(xdt,ydt,20,20);
        panelDT.add(lDisminucionDeTiempo);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(5);
                if(xdt>-20){
                    this.xdt -= this.velocidaddt;
                }
                cambiarpos(xdt);
                if(Practica3.dt1.recDT.intersects(pJuego.rNAVE)){
                    lDisminucionDeTiempo.setVisible(false);
                    Practica3.pPanel.lTiempo.setText(String.valueOf(Integer.parseInt(Practica3.pPanel.lTiempo.getText())-10));
                    this.stop();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnewat){
        this.lDisminucionDeTiempo.setLocation(xnewat, this.ydt);
        this.recDT.setLocation(xnewat,this.ydt);
    }
    
}
