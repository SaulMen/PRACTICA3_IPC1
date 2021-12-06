
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.*;

public class EnemigoTipo1 extends Thread{
    
    public static JLabel lEnemigoTipo1[]=new JLabel[16];// = new JLabel();
    public static Rectangle rec[] = new Rectangle[16];
    public PNuevoJuego panel = new PNuevoJuego();
    public int x,y;
    public static double velocidad;
    public int canene1;
    public int aum;
    public EnemigoTipo1(int x, int y, PNuevoJuego panel, int canene1){
        super();
        this.x = x;
        this.y = y;
        this.panel = panel;
        this.velocidad = Practica3.velocidad1;
        this.canene1 = canene1;
        
        if(canene1>7){
            lEnemigoTipo1[canene1] = new JLabel();
            lEnemigoTipo1[canene1].setBounds(x,y,35,35);
            ImageIcon imagenEnemigo1 = new ImageIcon("elements\\EnemigoTipo1.png");
            Icon iconoEnemigo1 = new ImageIcon(
                    imagenEnemigo1.getImage().getScaledInstance(lEnemigoTipo1[canene1].getWidth(),
                                        lEnemigoTipo1[canene1].getHeight(), Image.SCALE_DEFAULT));
            lEnemigoTipo1[canene1].setIcon(iconoEnemigo1);
            rec[canene1] = new Rectangle(x,y,35,35);
            lEnemigoTipo1[canene1].setVisible(false);
            panel.add(lEnemigoTipo1[canene1]);
        }else{
            lEnemigoTipo1[canene1] = new JLabel();
            lEnemigoTipo1[canene1].setBounds(x,y,35,35);
            ImageIcon imagenEnemigo1 = new ImageIcon("elements\\EnemigoTipo1.png");
            Icon iconoEnemigo1 = new ImageIcon(
                    imagenEnemigo1.getImage().getScaledInstance(lEnemigoTipo1[canene1].getWidth(),
                                        lEnemigoTipo1[canene1].getHeight(), Image.SCALE_DEFAULT));
            lEnemigoTipo1[canene1].setIcon(iconoEnemigo1);
            rec[canene1] = new Rectangle(x,y,35,35);
            panel.add(lEnemigoTipo1[canene1]);
        }   
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(150);
                if(x>-35){
                    this.x -= this.velocidad;
                }
                aum ++;
                if(aum == 8 || aum == 10 || aum == 12 || aum == 14 || aum == 16){
                    this.y += 5;
                    
                }else if (aum == 2 || aum == 4 || aum == 6 || aum == 18 || aum == 20){
                    this.y -= 5;
                    if(aum == 20){
                        aum = 0;
                    }
                }

                cambiarpos(x);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnew){
        this.lEnemigoTipo1[canene1].setLocation(xnew, this.y);
        this.rec[canene1].setLocation(xnew,this.y);
    }
    
    
}
