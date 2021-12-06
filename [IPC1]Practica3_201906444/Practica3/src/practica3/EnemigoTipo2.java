
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoTipo2 extends Thread{
    public static JLabel lEnemigoTipo2[] = new JLabel[16];
    public static Rectangle rec2[] = new Rectangle[16];
    public PNuevoJuego panel2 = new PNuevoJuego();
    public int x2,y2;
    public static double velocidad2;
    public int canene2;
    public int aum;
    public EnemigoTipo2(int x2, int y2, PNuevoJuego panel2, int canene2){
        super();
        this.x2 = x2;
        this.y2 = y2;
        this.panel2 = panel2;
        this.velocidad2 = EnemigoTipo1.velocidad;
        this.canene2 = canene2;
        
        lEnemigoTipo2[canene2] = new JLabel();
        lEnemigoTipo2[canene2].setBounds(x2,y2,35,35);
        ImageIcon imagenEnemigo2 = new ImageIcon("elements\\EnemigoTipo2.png");
        Icon iconoEnemigo2 = new ImageIcon(
                imagenEnemigo2.getImage().getScaledInstance(lEnemigoTipo2[canene2].getWidth(),
                                    lEnemigoTipo2[canene2].getHeight(), Image.SCALE_DEFAULT));
        lEnemigoTipo2[canene2].setIcon(iconoEnemigo2);
        rec2[canene2] = new Rectangle(x2,y2,35,35);
        panel2.add(lEnemigoTipo2[canene2]);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(150);
                if(x2>-35){
                    this.x2 -= this.velocidad2;
                }
                aum ++;
                if(aum == 8 || aum == 10 || aum == 12 || aum == 14 || aum == 16){
                    this.y2 += 5;
                    
                }else if (aum == 2 || aum == 4 || aum == 6 || aum == 18 || aum == 20){
                    this.y2 -= 5;
                    if(aum == 20){
                        aum = 0;
                    }
                }
                
                cambiarpos(x2);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnew2){
        this.lEnemigoTipo2[canene2].setLocation(xnew2, this.y2);
        this.rec2[canene2].setLocation(xnew2,this.y2);
    }
    
    
}
