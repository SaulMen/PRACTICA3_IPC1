
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;
import static practica3.Practica3.pJuego;

public class AumentoDeTiempo extends Thread{
    public JLabel lAumentoTiempo = new JLabel();
    public Rectangle recAT = new Rectangle();
    public static PNuevoJuego panelAT = new PNuevoJuego();
    public static int xat,yat,velocidadat;
    
    public AumentoDeTiempo(int xat,int yat, PNuevoJuego panelAT){
        super();
        this.xat= xat;
        this.yat = yat;
        this.panelAT = panelAT;
        this.velocidadat=1;
        
        lAumentoTiempo.setBounds(xat,yat,20,20);
        ImageIcon imagenAT = new ImageIcon("elements\\AumentoDeTiempo.png");
        Icon iconoAT = new ImageIcon(
                imagenAT.getImage().getScaledInstance(lAumentoTiempo.getWidth(),
                                    lAumentoTiempo.getHeight(), Image.SCALE_DEFAULT));
        lAumentoTiempo.setIcon(iconoAT);
        recAT = new Rectangle(xat,yat,20,20);
        panelAT.add(lAumentoTiempo);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(5);
                if(xat>-20){
                    this.xat -= this.velocidadat;
                }
                cambiarpos(xat);
                if(Practica3.at.recAT.intersects(pJuego.rNAVE)){
                    lAumentoTiempo.setVisible(false);
                    System.out.println(Practica3.pPanel.lTiempo.getText());
                    Practica3.pPanel.lTiempo.setText(String.valueOf(Integer.parseInt(Practica3.pPanel.lTiempo.getText())+10));
                    this.stop();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnewat){
        this.lAumentoTiempo.setLocation(xnewat, this.yat);
        this.recAT.setLocation(xnewat,this.yat);
    }
    
}
