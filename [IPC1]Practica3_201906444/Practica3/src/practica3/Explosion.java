
package practica3;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Explosion extends Thread{
    public int xe,ye;
    public JLabel lExplosion = new JLabel();
    public static PNuevoJuego panele = new PNuevoJuego();
    
    public Explosion(int xe, int ye, PNuevoJuego panele){
        super();
        this.xe = xe;
        this.ye = ye;
        this.panele = panele;
        
        lExplosion.setBounds(xe,ye,35,35);
        ImageIcon imagenexplosion = new ImageIcon("elements\\Explosion.png");
        Icon iconoexplosion = new ImageIcon(
                imagenexplosion.getImage().getScaledInstance(lExplosion.getWidth(),
                                    lExplosion.getHeight(), Image.SCALE_DEFAULT));
        lExplosion.setIcon(iconoexplosion);
        panele.add(lExplosion);
    }
    
    @Override
    public void run(){
        try {
            sleep(500);
            lExplosion.setVisible(false);
            panele.remove(lExplosion);
            this.stop();
        } catch (InterruptedException ex) {
        }
    }
}
