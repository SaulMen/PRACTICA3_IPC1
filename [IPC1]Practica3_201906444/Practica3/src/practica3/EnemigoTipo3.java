
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EnemigoTipo3 extends Thread{
    public static JLabel lEnemigoTipo3[] = new JLabel[16];
    public static Rectangle rec3[] = new Rectangle[16];
    public PNuevoJuego panel3 = new PNuevoJuego();
    public int x3,y3;
    public static double velocidad3;
    public int canene3;
    public int aum;
    public EnemigoTipo3(int x3, int y3, PNuevoJuego panel3, int canene3){
        super();
        this.x3 = x3;
        this.y3 = y3;
        this.panel3 = panel3;
        this.velocidad3 = EnemigoTipo1.velocidad;
        this.canene3 = canene3;
        lEnemigoTipo3[canene3] = new JLabel();
        lEnemigoTipo3[canene3].setBounds(x3,y3,35,35);
        ImageIcon imagenEnemigo3 = new ImageIcon("elements\\EnemigoTipo3.png");
        Icon iconoEnemigo3 = new ImageIcon(
                imagenEnemigo3.getImage().getScaledInstance(lEnemigoTipo3[canene3].getWidth(),
                                    lEnemigoTipo3[canene3].getHeight(), Image.SCALE_DEFAULT));
        lEnemigoTipo3[canene3].setIcon(iconoEnemigo3);
        rec3[canene3] = new Rectangle(x3,y3,35,35);
        panel3.add(lEnemigoTipo3[canene3]);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sleep(150);
                if(x3>-35){
                    this.x3 -= this.velocidad3;
                }
                aum ++;
                if(aum == 8 || aum == 10 || aum == 12 || aum == 14 || aum == 16){
                    this.y3 += 5;
                    
                }else if (aum == 2 || aum == 4 || aum == 6 || aum == 18 || aum == 20){
                    this.y3 -= 5;
                    if(aum == 20){
                        aum = 0;
                    }
                }
                
                cambiarpos(x3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void cambiarpos(int xnew3){
        this.lEnemigoTipo3[canene3].setLocation(xnew3, this.y3);
        this.rec3[canene3].setLocation(xnew3,this.y3);
    }
    
}
