
package practica3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;
import javax.swing.JPanel;
import static practica3.Practica3.cambios;
import static practica3.Practica3.continuar;
import static practica3.Practica3.ene1;
import static practica3.Practica3.ene2;
import static practica3.Practica3.ene3;
import static practica3.Practica3.pJuego;
import static practica3.Practica3.pPanel;
import static practica3.Practica3.v3;

public class PPanelJuego extends JPanel{
    
    public PPanelJuego(){
        setVisible(true);
        setLayout(null);
        setBackground(Color.blue);
        estadisticas();
    }
    
    public static Timer tem;
    TimerTask tarea;
    JLabel lPuntos, lVelo, lTiempo, lTiempo2; 
    public static PNuevoJuego panelb1 = new PNuevoJuego();
    public JLabel lPuntos1[] = new JLabel[16];
    public static int num=0, numItems, hayUno, hayUnoPE, hayUnoDT, hayUnoP, hayUnoAV, hayUnoC;
    public static int tiempoVelo, tiempoConge;
    int conteo=0;
    public static boolean seguir =true;
    public void estadisticas(){
        //                                          Labels de información
        JLabel lTPuntos = new JLabel("PUNTOS");
        lTPuntos.setBounds(240,10,60,17);
        lTPuntos.setVisible(true);
        lTPuntos.setLayout(null);
        lTPuntos.setOpaque(true);
        lTPuntos.setBackground(Color.blue);
        lTPuntos.setForeground(Color.white);
        lTPuntos.setFont(new Font("Calibri",Font.BOLD,16));
        this.add(lTPuntos);
        
        JLabel lTVelo = new JLabel("VELOCIDAD");
        lTVelo.setBounds(420,10,80,17);
        lTVelo.setVisible(true);
        lTVelo.setLayout(null);
        lTVelo.setOpaque(true);
        lTVelo.setBackground(Color.blue);
        lTVelo.setForeground(Color.white);
        lTVelo.setFont(new Font("Calibri",Font.BOLD,16));
        this.add(lTVelo);
        
        
        JLabel lTTiempo = new JLabel("TIEMPO");
        lTTiempo.setBounds(620,10,60,17);
        lTTiempo.setVisible(true);
        lTTiempo.setLayout(null);
        lTTiempo.setOpaque(true);
        lTTiempo.setBackground(Color.blue);
        lTTiempo.setForeground(Color.white);
        lTTiempo.setFont(new Font("Calibri",Font.BOLD,16));
        this.add(lTTiempo);
        
        //                                          Labels Imagenes
        JLabel lITiempo = new JLabel();
        lITiempo.setVisible(true);
        lITiempo.setLayout(null);
        lITiempo.setBounds(700,40,35,35);
        lITiempo.setOpaque(true);
        ImageIcon imagenTiempo = new ImageIcon("elements\\reloj.png");
        Icon iconoTiempo = new ImageIcon(imagenTiempo.getImage().getScaledInstance(lITiempo.getWidth(),
                                    lITiempo.getHeight(), Image.SCALE_DEFAULT));
        lITiempo.setIcon(iconoTiempo);
        this.add(lITiempo);
        
        JLabel lIMoneda = new JLabel();
        lIMoneda.setVisible(true);
        lIMoneda.setLayout(null);
        lIMoneda.setBounds(180,40,35,35);
        lIMoneda.setOpaque(true);
        ImageIcon imagenModena = new ImageIcon("elements\\moneda.png");
        Icon iconoMoneda = new ImageIcon(imagenModena.getImage().getScaledInstance(lIMoneda.getWidth(),
                                    lIMoneda.getHeight(), Image.SCALE_DEFAULT));
        lIMoneda.setIcon(iconoMoneda);
        this.add(lIMoneda);
        
        //                                          Labels "Dinámicos"
        lPuntos = new JLabel("0");
        lPuntos.setVisible(true);
        lPuntos.setLayout(null);
        lPuntos.setBackground(Color.blue);
        lPuntos.setForeground(Color.white);
        lPuntos.setOpaque(true);
        lPuntos.setBounds(250,37,30,20);
        lPuntos.setFont(new Font("Calibri",Font.BOLD,18));
        this.add(lPuntos);
        
        
        for(int i=0; i<16;i++){
            lPuntos1[i] = new JLabel("0");
            lPuntos1[i].setVisible(false);
            lPuntos1[i].setLayout(null);
            lPuntos1[i].setBackground(Color.blue);
            lPuntos1[i].setForeground(Color.white);
            lPuntos1[i].setOpaque(true);
            lPuntos1[i].setBounds(150,37,20,20);
            lPuntos1[i].setFont(new Font("Calibri",Font.BOLD,18));
            this.add(lPuntos1[i]);
        }
        
        lVelo = new JLabel();
        lVelo.setVisible(true);
        lVelo.setLayout(null);
        lVelo.setBackground(Color.blue);
        lVelo.setForeground(Color.white);
        lVelo.setOpaque(true);
        lVelo.setBounds(430,37,35,20);
        lVelo.setFont(new Font("Calibri",Font.BOLD,18));
        this.add(lVelo);
        
        lTiempo2 = new JLabel("900");
        lTiempo2.setVisible(true);
        lTiempo2.setLayout(null);
        
        lTiempo = new JLabel();
        lTiempo.setVisible(true);
        lTiempo.setLayout(null);
        lTiempo.setBackground(Color.blue);
        lTiempo.setForeground(Color.white);
        lTiempo.setOpaque(true);
        lTiempo.setBounds(630,37,30,20);
        lTiempo.setFont(new Font("Calibri",Font.BOLD,18));
        this.add(lTiempo);
        if(Practica3.cambios==false){
            lTiempo.setText("91");
        }else{
            lTiempo.setText(String.valueOf(Practica3.cantTiempo));
        }
        
        tem = new Timer();
        tarea = new TimerTask(){
            @Override
            public void run(){
                tiempoConge++;
                tiempoVelo++;
                numItems++;
                num++;
                conteo++;
//                System.out.println(num); //Si da error en algún momento, restablecer tiempo para 1000 milisegundos... 
                if(num==2){                 // Y eliminar este if y la variable "num"...
                    int tiempo = Integer.parseInt(lTiempo.getText()); //Pero no habria caso de colsion nave-enemigo.
                    tiempo -= 1; 
                    lTiempo.setText(String.valueOf(tiempo));
                    num=0;
                }
                
                if(Integer.parseInt(lTiempo.getText())==0){
                    for(int j=0;j<16;j++){
                        Practica3.ene1[j].stop();
                        Practica3.ene2[j].stop();
                        Practica3.ene3[j].stop();
                    }
                    tiempoConge=0;
                    tiempoVelo=0;
                    numItems=0;
                    num=0;
                    conteo=0;
                    cancel();
                    JOptionPane.showMessageDialog(null, "stop");
                    Practica3.v3.remove(pPanel);
                    Practica3.v3.remove(pJuego);
                    continuar = true;
                    Practica3.v3.setVisible(false);
                    Practica3.v3.repaint();
                    Practica3.v1.setVisible(true);
                }
                if(Integer.parseInt(lTiempo.getText())<89){
                    int gana=0;
                    if(gana<8){
                        for(int i=0; i<16;i++){
                            if(!EnemigoTipo3.lEnemigoTipo3[i].isVisible()){
                                gana++;
                            }
                        }
                    }
                    if(gana<24){
                        for(int i=0; i<16;i++){
                            if(!EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
                                gana++;
                            }
                        }
                    }
                    if(gana<40){
                        for(int i=0; i<8;i++){
                            if(!EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
                                gana++;
                            }
                        }
                    }
                    if(gana==40){
                        cancel();
                        Practica3.puntuacionFinal = pPanel.lPuntos.getText();
                        Practica3.nombre = JOptionPane.showInputDialog(null, "Ganaste\n Ingresa tu nombre: ");
                        Practica3.nombresWin[5] = Practica3.nombre;
                        Practica3.ptsWin[5] = Integer.parseInt(Practica3.puntuacionFinal);
                        Practica3.nivelFrec = "";
                        cambios = false;
                        tiempoConge=0;
                        tiempoVelo=0;
                        numItems=0;
                        num=0;
                        pPanel.conteo=0;
                        v3.remove(pPanel);
                        v3.remove(pJuego);
                        for(int i=0;i<16;i++){
                            ene1[i].stop();
                            ene2[i].stop();
                            ene3[i].stop();
                            ene1[i] = null;
                            ene2[i] = null;
                            ene3[i] = null;
                            continuar = true;
                        }
                        v3.setVisible(false);
                        v3.repaint();
                        Practica3.v1.setVisible(true);
                    }
                    
                    for(int i=0;i<8;i++){
                        if(pJuego.rNAVE.intersects(EnemigoTipo1.rec[i])&&EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
                            System.out.println("si");
                            for(int j=0;j<16;j++){
                                Practica3.ene1[j].stop();
                                Practica3.ene2[j].stop();
                                Practica3.ene3[j].stop();
                            }
                            Practica3.nivelFrec = "";
                            tiempoConge=0;
                            tiempoVelo=0;
                            numItems=0;
                            num=0;
                            conteo=0;
                            Practica3.pPanel.tarea.cancel();
//                            cancel();
                            JOptionPane.showMessageDialog(null, "Perdiste");
                            Practica3.v3.remove(pPanel);
                            Practica3.v3.remove(pJuego);
                            continuar = true;
                            Practica3.v3.setVisible(false);
                            Practica3.v3.repaint();
                            Practica3.v1.setVisible(true);
                        }
                    }
                    for(int i=0;i<16;i++){
                        if(pJuego.rNAVE.intersects(EnemigoTipo2.rec2[i])&&EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
//                            System.out.println("si");
                            for(int j=0;j<16;j++){
                                Practica3.ene1[j].stop();
                                Practica3.ene2[j].stop();
                                Practica3.ene3[j].stop();
                            }
                            Practica3.nivelFrec = "";
                            tiempoConge=0;
                            tiempoVelo=0;
                            numItems=0;
                            num=0;
                            conteo=0;
                            cancel();
                            JOptionPane.showMessageDialog(null, "Perdiste");
                            Practica3.v3.remove(pPanel);
                            Practica3.v3.remove(pJuego);
                            continuar = true;
                            Practica3.v3.setVisible(false);
                            Practica3.v3.repaint();
                            Practica3.v1.setVisible(true);
                        }
                    }
                    for(int i=0;i<16;i++){
                        if(pJuego.rNAVE.intersects(EnemigoTipo3.rec3[i])&&EnemigoTipo3.lEnemigoTipo3[i].isVisible()){
                            System.out.println("si");
                            for(int j=0;j<16;j++){
                                Practica3.ene1[j].stop();
                                Practica3.ene2[j].stop();
                                Practica3.ene3[j].stop();
                            }
                            Practica3.nivelFrec = "";
                            tiempoConge=0;
                            tiempoVelo=0;
                            numItems=0;
                            num=0;
                            conteo=0;
//                            pPanel.tarea.cancel();
                            cancel();
                            JOptionPane.showMessageDialog(null, "Perdiste");
                            Practica3.v3.remove(pPanel);
                            Practica3.v3.remove(pJuego);
                            continuar = true;
                            Practica3.v3.setVisible(false);
                            Practica3.v3.repaint();
                            Practica3.v1.setVisible(true);
                        }
                    }
                    
                }
                
                int posYItem = (int)(Math.random()*530);
                if(Practica3.nivelFrec=="11"){
                    ArrayList<Integer> cantItemsSelect = new ArrayList();
//                    System.out.println("Poco frecuente");
                    if(PConfig.cb1.isSelected()){
                        cantItemsSelect.add(1); 
                    }
                    if(PConfig.cb2.isSelected()){
                        cantItemsSelect.add(2); 
                    }
                    if(PConfig.cb3.isSelected()){
                        cantItemsSelect.add(3); 
                    }
                    if(PConfig.cb4.isSelected()){
                        cantItemsSelect.add(4); 
                    }
                    if(PConfig.cb5.isSelected()){
                        cantItemsSelect.add(5); 
                    }
                    if(PConfig.cb6.isSelected()){
                        cantItemsSelect.add(6); 
                    }
                    
//                    System.out.println(cantItemsSelect.size() + "Esta cantidad");
                    int numeroPosDeItem = (int)(Math.random()*cantItemsSelect.size());
//                    System.out.println(numeroPosDeItem);
                    int numeroConvePosDeItem;
                    if(numeroPosDeItem==0 && (PConfig.cb1.isSelected() || PConfig.cb2.isSelected()
                            || PConfig.cb3.isSelected() || PConfig.cb4.isSelected() || PConfig.cb5.isSelected()
                            || PConfig.cb6.isSelected())){
                        numeroConvePosDeItem = cantItemsSelect.get(numeroPosDeItem);
                    }else if(numeroPosDeItem == 0 && !PConfig.cb1.isSelected() && !PConfig.cb2.isSelected()
                            && !PConfig.cb3.isSelected() && !PConfig.cb4.isSelected() && !PConfig.cb5.isSelected()
                            && !PConfig.cb6.isSelected()){
                        numeroConvePosDeItem = 7;
                    }else{
                        numeroConvePosDeItem = 7;
                    }
//                    System.out.println(numeroConvePosDeItem+ " este");
                    
                    if(tiempoVelo==20){
                        Practica3.veloNave = 6;
                    }
                    if(tiempoConge==10){
                        Practica3.estaCongelado = false;
                        Practica3.veloNave = 6;
                    }
                    
                    if(numItems==22){
                        if(numeroConvePosDeItem==1){
                            if(hayUno==1){
                                hayUno=0;
                                Practica3.at.lAumentoTiempo.setVisible(false);
                                pJuego.remove(Practica3.at.lAumentoTiempo);
                                Practica3.at.stop();
                            }
                            Practica3.at = new AumentoDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.at.start();
                            hayUno++;    
                        }
                        if(numeroConvePosDeItem==2){
                            if(hayUnoPE==1){
                                hayUnoPE=0;
                                Practica3.pe1.lPuntosExtra.setVisible(false);
                                pJuego.remove(Practica3.pe1.lPuntosExtra);
                                Practica3.pe1.stop();
                            }
                            Practica3.pe1 = new PuntosExtra(900, posYItem, Practica3.pJuego);
                            Practica3.pe1.start();
                            hayUnoPE++; 
                        }
                        if(numeroConvePosDeItem==3){
                            if(hayUnoAV==1){
                                hayUnoAV=0;
                                Practica3.av1.lAumentoDeVelocidad.setVisible(false);
                                pJuego.remove(Practica3.av1.lAumentoDeVelocidad);
                                Practica3.av1.stop();
                            }
                            Practica3.av1 = new AumentoDeVelocidad(900, posYItem, Practica3.pJuego);
                            Practica3.av1.start();
                            hayUnoAV++;
                        }
                        if(numeroConvePosDeItem==4){
                            if(hayUnoDT==1){
                                hayUnoDT=0;
                                Practica3.dt1.lDisminucionDeTiempo.setVisible(false);
                                pJuego.remove(Practica3.dt1.lDisminucionDeTiempo);
                                Practica3.dt1.stop();
                            }
                            Practica3.dt1 = new DisminucionDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.dt1.start();
                            hayUnoDT++;
                        }
                        if(numeroConvePosDeItem==5){
                            if(hayUnoP==1){
                                hayUnoP=0;
                                Practica3.p1.lPenalizacion.setVisible(false);
                                pJuego.remove(Practica3.p1.lPenalizacion);
                                Practica3.p1.stop();
                            }
                            Practica3.p1 = new Penalizacion(900, posYItem, Practica3.pJuego);
                            Practica3.p1.start();
                            hayUnoP++;
                        }
                        if(numeroConvePosDeItem==6){ 
                            if(hayUnoC==1){
                                hayUnoC=0;
                                Practica3.c1.lCongelacion.setVisible(false);
                                pJuego.remove(Practica3.c1.lCongelacion);
                                Practica3.c1.stop();
                            }
                            Practica3.c1 = new Congelacion(900, posYItem, Practica3.pJuego);
                            Practica3.c1.start();
                            hayUnoC++;
                        }if(numeroConvePosDeItem==7){
                            System.out.println("");
                        }
                        numItems=0;
                    }
                    
                    
                }else if(Practica3.nivelFrec=="5"){
                    
                    ArrayList<Integer> cantItemsSelect = new ArrayList();
                    System.out.println("Muy frecuente");
                    if(PConfig.cb1.isSelected()){
                        cantItemsSelect.add(1); 
                    }
                    if(PConfig.cb2.isSelected()){
                        cantItemsSelect.add(2); 
                    }
                    if(PConfig.cb3.isSelected()){
                        cantItemsSelect.add(3); 
                    }
                    if(PConfig.cb4.isSelected()){
                        cantItemsSelect.add(4); 
                    }
                    if(PConfig.cb5.isSelected()){
                        cantItemsSelect.add(5); 
                    }
                    if(PConfig.cb6.isSelected()){
                        cantItemsSelect.add(6); 
                    }// 
                    
                    System.out.println(cantItemsSelect.size() + "Esta cantidad");
                    int numeroPosDeItem = (int)(Math.random()*cantItemsSelect.size());
                    System.out.println(numeroPosDeItem);
                    int numeroConvePosDeItem;
                    if(numeroPosDeItem==0 && (PConfig.cb1.isSelected() || PConfig.cb2.isSelected()
                            || PConfig.cb3.isSelected() || PConfig.cb4.isSelected() || PConfig.cb5.isSelected()
                            || PConfig.cb6.isSelected())){
                        numeroConvePosDeItem = cantItemsSelect.get(numeroPosDeItem);
                    }else if(numeroPosDeItem == 0 && !PConfig.cb1.isSelected() && !PConfig.cb2.isSelected()
                            && !PConfig.cb3.isSelected() && !PConfig.cb4.isSelected() && !PConfig.cb5.isSelected()
                            && !PConfig.cb6.isSelected()){
                        numeroConvePosDeItem = 7;
                    }else{
                        numeroConvePosDeItem = 7;
                    }
                    
//                    System.out.println(numeroConvePosDeItem+ " este");
                    
                    if(tiempoVelo==20){
                        Practica3.veloNave = 6;
                    }
                    if(tiempoConge==10){
                        Practica3.estaCongelado = false;
                        Practica3.veloNave = 6;
                    }
                    
                    if(numItems==10){
                        if(numeroConvePosDeItem==1){
                            if(hayUno==1){
                                hayUno=0;
                                Practica3.at.lAumentoTiempo.setVisible(false);
                                pJuego.remove(Practica3.at.lAumentoTiempo);
                                Practica3.at.stop();
                            }
                            Practica3.at = new AumentoDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.at.start();
                            hayUno++;    
                        }
                        if(numeroConvePosDeItem==2){
                            if(hayUnoPE==1){
                                hayUnoPE=0;
                                Practica3.pe1.lPuntosExtra.setVisible(false);
                                pJuego.remove(Practica3.pe1.lPuntosExtra);
                                Practica3.pe1.stop();
                            }
                            Practica3.pe1 = new PuntosExtra(900, posYItem, Practica3.pJuego);
                            Practica3.pe1.start();
                            hayUnoPE++; 
                        }
                        if(numeroConvePosDeItem==3){
                            if(hayUnoAV==1){
                                hayUnoAV=0;
                                Practica3.av1.lAumentoDeVelocidad.setVisible(false);
                                pJuego.remove(Practica3.av1.lAumentoDeVelocidad);
                                Practica3.av1.stop();
                            }
                            Practica3.av1 = new AumentoDeVelocidad(900, posYItem, Practica3.pJuego);
                            Practica3.av1.start();
                            hayUnoAV++;
                        }
                        if(numeroConvePosDeItem==4){
                            if(hayUnoDT==1){
                                hayUnoDT=0;
                                Practica3.dt1.lDisminucionDeTiempo.setVisible(false);
                                pJuego.remove(Practica3.dt1.lDisminucionDeTiempo);
                                Practica3.dt1.stop();
                            }
                            Practica3.dt1 = new DisminucionDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.dt1.start();
                            hayUnoDT++;
                        }
                        if(numeroConvePosDeItem==5){
                            if(hayUnoP==1){
                                hayUnoP=0;
                                Practica3.p1.lPenalizacion.setVisible(false);
                                pJuego.remove(Practica3.p1.lPenalizacion);
                                Practica3.p1.stop();
                            }
                            Practica3.p1 = new Penalizacion(900, posYItem, Practica3.pJuego);
                            Practica3.p1.start();
                            hayUnoP++;
                        }
                        if(numeroConvePosDeItem==6){ 
                            if(hayUnoC==1){
                                hayUnoC=0;
                                Practica3.c1.lCongelacion.setVisible(false);
                                pJuego.remove(Practica3.c1.lCongelacion);
                                Practica3.c1.stop();
                            }
                            Practica3.c1 = new Congelacion(900, posYItem, Practica3.pJuego);
                            Practica3.c1.start();
                            hayUnoC++;
                        }
                        if(numeroConvePosDeItem==7){
                            System.out.println("");
                        }
                        numItems=0;
                    }
                    
                    
                }else if(Practica3.nivelFrec=="8"){
                    
                    ArrayList<Integer> cantItemsSelect = new ArrayList();
                    System.out.println("Normal");
                    if(PConfig.cb1.isSelected()){
                        cantItemsSelect.add(1); 
                    }
                    if(PConfig.cb2.isSelected()){
                        cantItemsSelect.add(2); 
                    }
                    if(PConfig.cb3.isSelected()){
                        cantItemsSelect.add(3); 
                    }
                    if(PConfig.cb4.isSelected()){
                        cantItemsSelect.add(4); 
                    }
                    if(PConfig.cb5.isSelected()){
                        cantItemsSelect.add(5); 
                    }
                    if(PConfig.cb6.isSelected()){
                        cantItemsSelect.add(6); 
                    }
                    
                    System.out.println(cantItemsSelect.size() + "Esta cantidad");
                    int numeroPosDeItem = (int)(Math.random()*cantItemsSelect.size());
                    System.out.println(numeroPosDeItem);
                    int numeroConvePosDeItem;
                    if(numeroPosDeItem==0 && (PConfig.cb1.isSelected() || PConfig.cb2.isSelected()
                            || PConfig.cb3.isSelected() || PConfig.cb4.isSelected() || PConfig.cb5.isSelected()
                            || PConfig.cb6.isSelected())){
                        numeroConvePosDeItem = cantItemsSelect.get(numeroPosDeItem);
                    }else if(numeroPosDeItem == 0 && !PConfig.cb1.isSelected() && !PConfig.cb2.isSelected()
                            && !PConfig.cb3.isSelected() && !PConfig.cb4.isSelected() && !PConfig.cb5.isSelected()
                            && !PConfig.cb6.isSelected()){
                        numeroConvePosDeItem = 7;
                    }else{
                        numeroConvePosDeItem = 7;
                    }
                    System.out.println(numeroConvePosDeItem+ " este");
                    
                    if(tiempoVelo==20){
                        Practica3.veloNave = 6;
                    }
                    if(tiempoConge==10){
                        Practica3.estaCongelado = false;
                        Practica3.veloNave = 6;
                    }
                    
                    if(numItems==16){
                        if(numeroConvePosDeItem==1){
                            if(hayUno==1){
                                hayUno=0;
                                Practica3.at.lAumentoTiempo.setVisible(false);
                                pJuego.remove(Practica3.at.lAumentoTiempo);
                                Practica3.at.stop();
                            }
                            Practica3.at = new AumentoDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.at.start();
//                            System.out.println(posYItem);
//                            System.out.println(numItems);
                            hayUno++;    
                        }
                        if(numeroConvePosDeItem==2){
                            if(hayUnoPE==1){
                                hayUnoPE=0;
                                Practica3.pe1.lPuntosExtra.setVisible(false);
                                pJuego.remove(Practica3.pe1.lPuntosExtra);
                                Practica3.pe1.stop();
                            }
                            Practica3.pe1 = new PuntosExtra(900, posYItem, Practica3.pJuego);
                            Practica3.pe1.start();
                            hayUnoPE++; 
                        }
                        if(numeroConvePosDeItem==3){
                            if(hayUnoAV==1){
                                hayUnoAV=0;
                                Practica3.av1.lAumentoDeVelocidad.setVisible(false);
                                pJuego.remove(Practica3.av1.lAumentoDeVelocidad);
                                Practica3.av1.stop();
                            }
                            Practica3.av1 = new AumentoDeVelocidad(900, posYItem, Practica3.pJuego);
                            Practica3.av1.start();
                            hayUnoAV++;
                        }
                        if(numeroConvePosDeItem==4){
                            if(hayUnoDT==1){
                                hayUnoDT=0;
                                Practica3.dt1.lDisminucionDeTiempo.setVisible(false);
                                pJuego.remove(Practica3.dt1.lDisminucionDeTiempo);
                                Practica3.dt1.stop();
                            }
                            Practica3.dt1 = new DisminucionDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.dt1.start();
                            hayUnoDT++;
                        }
                        if(numeroConvePosDeItem==5){
                            if(hayUnoP==1){
                                hayUnoP=0;
                                Practica3.p1.lPenalizacion.setVisible(false);
                                pJuego.remove(Practica3.p1.lPenalizacion);
                                Practica3.p1.stop();
                            }
                            Practica3.p1 = new Penalizacion(900, posYItem, Practica3.pJuego);
                            Practica3.p1.start();
                            hayUnoP++;
                        }
                        if(numeroConvePosDeItem==6){ 
                            if(hayUnoC==1){
                                hayUnoC=0;
                                Practica3.c1.lCongelacion.setVisible(false);
                                pJuego.remove(Practica3.c1.lCongelacion);
                                Practica3.c1.stop();
                            }
                            Practica3.c1 = new Congelacion(900, posYItem, Practica3.pJuego);
                            Practica3.c1.start();
                            hayUnoC++;
                        }
                        numItems=0;
                    }
                    
                    
                }else if(Practica3.cambios==false){
                    if(tiempoVelo==20){
                        Practica3.veloNave = 6;
                    }
                    if(tiempoConge==10){
                        Practica3.estaCongelado = false;
                        Practica3.veloNave = 6;
                    }
                    if(numItems==16){
                        
                        int numeroDeItem = (int)(Math.random()*6+1);
                        if(numeroDeItem==1){
                            if(hayUno==1){
                                hayUno=0;
                                Practica3.at.lAumentoTiempo.setVisible(false);
                                pJuego.remove(Practica3.at.lAumentoTiempo);
                                Practica3.at.stop();
                            }
                            Practica3.at = new AumentoDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.at.start();
                            hayUno++;    
                        }
                        if(numeroDeItem==2){
                            if(hayUnoPE==1){
                                hayUnoPE=0;
                                Practica3.pe1.lPuntosExtra.setVisible(false);
                                pJuego.remove(Practica3.pe1.lPuntosExtra);
                                Practica3.pe1.stop();
                            }
                            Practica3.pe1 = new PuntosExtra(900, posYItem, Practica3.pJuego);
                            Practica3.pe1.start();
                            hayUnoPE++; 
                        }
                        if(numeroDeItem==3){
                            if(hayUnoAV==1){
                                hayUnoAV=0;
                                Practica3.av1.lAumentoDeVelocidad.setVisible(false);
                                pJuego.remove(Practica3.av1.lAumentoDeVelocidad);
                                Practica3.av1.stop();
                            }
                            Practica3.av1 = new AumentoDeVelocidad(900, posYItem, Practica3.pJuego);
                            Practica3.av1.start();
                            hayUnoAV++;
                        }
                        if(numeroDeItem==4){
                            if(hayUnoDT==1){
                                hayUnoDT=0;
                                Practica3.dt1.lDisminucionDeTiempo.setVisible(false);
                                pJuego.remove(Practica3.dt1.lDisminucionDeTiempo);
                                Practica3.dt1.stop();
                            }
                            Practica3.dt1 = new DisminucionDeTiempo(900, posYItem, Practica3.pJuego);
                            Practica3.dt1.start();
                            hayUnoDT++;
                        }
                        if(numeroDeItem==5){
                            if(hayUnoP==1){
                                hayUnoP=0;
                                Practica3.p1.lPenalizacion.setVisible(false);
                                pJuego.remove(Practica3.p1.lPenalizacion);
                                Practica3.p1.stop();
                            }
                            Practica3.p1 = new Penalizacion(900, posYItem, Practica3.pJuego);
                            Practica3.p1.start();
                            hayUnoP++;
                        }
                        if(numeroDeItem==6){ 
                            if(hayUnoC==1){
                                hayUnoC=0;
                                Practica3.c1.lCongelacion.setVisible(false);
                                pJuego.remove(Practica3.c1.lCongelacion);
                                Practica3.c1.stop();
                            }
                            Practica3.c1 = new Congelacion(900, posYItem, Practica3.pJuego);
                            Practica3.c1.start();
                            hayUnoC++;
                        }
                        numItems=0;
                    }
                    
                }
                
            }
        };
        tem.schedule(tarea, 0, 500);
        
    }
}
