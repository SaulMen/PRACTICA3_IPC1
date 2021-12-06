
package practica3;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Disparo extends Thread{
    public JLabel lBala = new JLabel();
    public Rectangle recb = new Rectangle();
    public static PNuevoJuego panelb = new PNuevoJuego();
    public int xb,yb,velocidadb;
    public int cantene1[]=new int[16];
    public Explosion explosion;
    
    public Disparo(int xb, int yb, PNuevoJuego panelb ){
        super();
        this.xb = xb;
        this.yb = yb;
        this.panelb = panelb;
        this.velocidadb = 3;
        
        lBala.setBounds(xb,yb,8,7);
        ImageIcon imagenBala = new ImageIcon("elements\\Disparo2.png");
        Icon iconoBala = new ImageIcon(imagenBala.getImage().getScaledInstance(lBala.getWidth(),
                                    lBala.getHeight(), Image.SCALE_DEFAULT));
        lBala.setIcon(iconoBala);
        recb = new Rectangle(xb,yb,8,7);
        panelb.add(lBala);
    }
    public static int velocidadActualizada=2;
    public int suma=0;
    @Override
    public void run(){
        while(true){
            try {
                sleep(9);
                if(xb<900){
                    this.xb += this.velocidadb;
                }
                cambiarpos(xb);
                //                                              Enemigo 1
                for(int i=0;i<8;i++){
                    if(EnemigoTipo1.lEnemigoTipo1[i].isVisible() && Practica3.continuar==true
                            && Practica3.pPanel.lPuntos1[i].getText()!="1"){
                        if(golpe(EnemigoTipo1.rec[i])){
                               Practica3.pPanel.lPuntos1[i].setText("1");
                               lBala.setVisible(false);
                               this.stop();
                            }
                    }    
                    if(EnemigoTipo1.lEnemigoTipo1[i].isVisible() && Practica3.continuar==true 
                            && Practica3.pPanel.lPuntos1[i].getText()=="1"){    
                        if(golpe(EnemigoTipo1.rec[i])){
                           EnemigoTipo1.lEnemigoTipo1[i].setVisible(false);
                           System.out.println("Eliminado 1");
    //                       panelb.remove(lBala);
                           lBala.setVisible(false);
                           Practica3.pPanel.lPuntos1[i].setText("0");
                           suma = Integer.parseInt(Practica3.pPanel.lPuntos.getText()) + 10;
                           Practica3.pPanel.lPuntos.setText(String.valueOf(suma));
                           Practica3.pPanel.lPuntos.setText(String.valueOf(suma));
//                           System.out.println(suma);
//                           System.out.println(Practica3.pPanel.lPuntos.getText());
                           //   En caso de algún error eliminar estas dos linea de abajo, para no remover
                           panelb.remove(EnemigoTipo1.lEnemigoTipo1[i]);               ////////
                           panelb.remove(EnemigoTipo1.rec[i]);                         ////////
                           explosion = new Explosion(EnemigoTipo1.lEnemigoTipo1[i].getX(),
                                   EnemigoTipo1.lEnemigoTipo1[i].getY(), panelb);
                           explosion .start();
                           this.stop();
                       }
                    }
                }
//                    //                                                Enemigo 2
                    int numEne1=0;
                    for(int i=0;i<8;i++){
                        if(!EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
                            numEne1++;
                        }
                    }
                    if(numEne1==8){
                        //                           AQUI RESETEAR LA VELOCIDAD
                        EnemigoTipo2.velocidad2 = EnemigoTipo1.velocidad*1.5;
                        EnemigoTipo3.velocidad3 = EnemigoTipo1.velocidad*1.5;
//                        Practica3.pPanel.lVelo.setText("x1.5");
                        for(int i=0;i<16;i++){
                            if(EnemigoTipo2.lEnemigoTipo2[i].isVisible() && !EnemigoTipo1.lEnemigoTipo1[i].isVisible()&&
                                    Practica3.pPanel.lPuntos1[i].getText()!="1" && Practica3.pPanel.lPuntos1[i].getText()!="2"){
                                if(golpe(EnemigoTipo2.rec2[i])){
                                   Practica3.pPanel.lPuntos1[i].setText("1");
                                   lBala.setVisible(false);
                                   this.stop();
                                }
                            }
                            if(EnemigoTipo2.lEnemigoTipo2[i].isVisible() && !EnemigoTipo1.lEnemigoTipo1[i].isVisible()&&
                                    Practica3.pPanel.lPuntos1[i].getText()=="1" && Practica3.pPanel.lPuntos1[i].getText()!="2"){
                                if(golpe(EnemigoTipo2.rec2[i])){
                                   Practica3.pPanel.lPuntos1[i].setText("2");
                                   lBala.setVisible(false);
                                   this.stop();
                               }
                            }
                            if(Practica3.pPanel.lPuntos1[i].getText()=="2" && EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
                                if(golpe(EnemigoTipo2.rec2[i])){
                                   EnemigoTipo2.lEnemigoTipo2[i].setVisible(false);
                                   System.out.println("Eliminado 2");
                                   velocidadActualizada = 12;
            //                       panelb.remove(lBala);
                                   lBala.setVisible(false);
                                   Practica3.pPanel.lPuntos1[i].setText("0");
                                   int suma = 0;
                                   suma = Integer.parseInt(Practica3.pPanel.lPuntos.getText()) + 20;
                                   Practica3.pPanel.lPuntos.setText(String.valueOf(suma));
                                   Practica3.pJuego.remove(EnemigoTipo2.lEnemigoTipo2[i]);
                                   Practica3.pJuego.remove(EnemigoTipo2.rec2[i]);
                                   explosion = new Explosion(EnemigoTipo2.lEnemigoTipo2[i].getX(),
                                       EnemigoTipo2.lEnemigoTipo2[i].getY(), panelb);
                                    explosion .start();
                                   this.stop();
            //                       panelb.repaint();
                               }
                            }
                          }
                    }
                    numEne1 = 0;
                    //                                                  Enemigo 3
                    int numEne2 = 0;
                    for(int i=0;i<16;i++){
                        if(!EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
                            numEne2++;
                        }
                    }
                    if(numEne2==16){
                        EnemigoTipo3.velocidad3 = EnemigoTipo1.velocidad*2;
//                        Practica3.pPanel.lVelo.setText("x2");
                        for(int i=0;i<16;i++){
                            if(EnemigoTipo3.lEnemigoTipo3[i].isVisible() && !EnemigoTipo1.lEnemigoTipo1[i].isVisible()&&
                                    !EnemigoTipo2.lEnemigoTipo2[i].isVisible() && Practica3.pPanel.lPuntos1[i].getText()!="1"
                                    && Practica3.pPanel.lPuntos1[i].getText()!="2" && Practica3.pPanel.lPuntos1[i].getText()!="3"){
                                if(golpe(EnemigoTipo3.rec3[i])){
                                   Practica3.pPanel.lPuntos1[i].setText("1");
                                   lBala.setVisible(false);
                                   this.stop();
                               }
                            }
                            if(EnemigoTipo3.lEnemigoTipo3[i].isVisible() && !EnemigoTipo1.lEnemigoTipo1[i].isVisible()&&
                                    !EnemigoTipo2.lEnemigoTipo2[i].isVisible() && Practica3.pPanel.lPuntos1[i].getText()=="1" && 
                                    Practica3.pPanel.lPuntos1[i].getText()!="2" &&Practica3.pPanel.lPuntos1[i].getText()!="3"){
                                if(golpe(EnemigoTipo3.rec3[i])){
                                   Practica3.pPanel.lPuntos1[i].setText("2");
                                   lBala.setVisible(false);
                                   this.stop();
                               }
                            }
                            if(EnemigoTipo3.lEnemigoTipo3[i].isVisible() && !EnemigoTipo1.lEnemigoTipo1[i].isVisible()&&
                                    !EnemigoTipo2.lEnemigoTipo2[i].isVisible() && Practica3.pPanel.lPuntos1[i].getText()!="1" 
                                    && Practica3.pPanel.lPuntos1[i].getText()=="2" &&Practica3.pPanel.lPuntos1[i].getText()!="3"){
                                if(golpe(EnemigoTipo3.rec3[i])){
                                   Practica3.pPanel.lPuntos1[i].setText("3");
                                   lBala.setVisible(false);
                                   this.stop();
                               }
                            }
                            if(Practica3.pPanel.lPuntos1[i].getText()=="3" && EnemigoTipo3.lEnemigoTipo3[i].isVisible()){
                                if(golpe(EnemigoTipo3.rec3[i])){
                                   EnemigoTipo3.lEnemigoTipo3[i].setVisible(false);
                                   System.out.println("Eliminado 3");
            //                       panelb.remove(lBala);
                                   lBala.setVisible(false);
                                   Practica3.pPanel.lPuntos1[i].setText("0");
                                   int suma = 0;
                                   suma = Integer.parseInt(Practica3.pPanel.lPuntos.getText()) + 30;
                                   Practica3.pPanel.lPuntos.setText(String.valueOf(suma));
                                   Practica3.pJuego.remove(EnemigoTipo3.lEnemigoTipo3[i]);
                                   Practica3.pJuego.remove(EnemigoTipo3.rec3[i]);
                                   explosion = new Explosion(EnemigoTipo3.lEnemigoTipo3[i].getX(),
                                       EnemigoTipo3.lEnemigoTipo3[i].getY(), panelb);
                                    explosion .start();
                                   this.stop();
            //                       panelb.repaint();
                               }
                            }
                        }
                    }
                    int velo1 = 0, velo2 = 0, velo3 = 0, velo4=0;
                    for(int i=0;i<16;i++){
                        if(!EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
                            velo1++;
                        }
                        if(EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
                            velo2++;
                        }
                        if(!EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
                            velo4++;
                        }
                        if(EnemigoTipo3.lEnemigoTipo3[i].isVisible()){
                            velo3++;
                        }
                    }
                    if(velo3==16 && velo1==16 && velo4!=16){
                        Practica3.pPanel.lVelo.setText("x1.5");
                    }
                    else if(velo2==16 && velo3==16){
                        Practica3.pPanel.lVelo.setText("x1");
                    }else{
                        Practica3.pPanel.lVelo.setText("x2");
                    }
                    velo1 = 0;
                    velo2 = 0;
                    velo3 = 0;
                    velo4 = 0;
                    
                    numEne2=0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean golpe(Rectangle rec){
        return this.recb.intersects(rec);
    }
    
    
    public void cambiarpos(int xnewb){
        this.lBala.setLocation(xnewb, this.yb);
        this.recb.setLocation(xnewb,this.yb);
    }
    
    
    
}
