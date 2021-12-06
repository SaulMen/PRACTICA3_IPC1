
package practica3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import static practica3.PPanelJuego.num;
import static practica3.PPanelJuego.numItems;
import static practica3.PPanelJuego.tiempoConge;
import static practica3.PPanelJuego.tiempoVelo;

public class Practica3 {
    
    static Practica3 pe;
    public static EnemigoTipo1 ene1[]= new EnemigoTipo1[16];
    public static EnemigoTipo2 ene2[]= new EnemigoTipo2[16];
    public static EnemigoTipo3 ene3[]= new EnemigoTipo3[16];
    public static AumentoDeTiempo at;
    public static PuntosExtra pe1;
    public static DisminucionDeTiempo dt1;
    public static Penalizacion p1;
    public static AumentoDeVelocidad av1;
    public static Congelacion c1;
    public Disparo bala;
    public static PNuevoJuego pJuego;
    public static PPanelJuego pPanel;
    public static PConfig pItems;
    public static boolean continuar = true;
    public static boolean cambios = false;
    public static boolean estaCongelado = false;
    public static int cantTiempo=0, velocidad1=1, veloNave=6;
    public static String nivelVelo="", nivelFrec="";
    public static String nombre="", puntuacionFinal="0";
    public static String nombresWin[] =  new String[6];
    public static int  ptsWin[] = new int[6];
    int numero = (int)(Math.random()*881);
    public static String campo[] = new String[6];
    
    public static void main(String[] args){
        pe = new Practica3();
        pe.ventanaPrincipal();
    }
    
    static VInicio v1,v2,v3,v4;
    public void ventanaPrincipal(){
        v1 = new VInicio("Inicio");
        v1.setVisible(true);
        //                              Dar SIEMPRE 16px en X | 39px en Y
        v1.setBounds(250,75,716,639);
        
        PInicio p1 = new PInicio();
        p1.setBounds(0,0,700,600);
        v1.add(p1);
        
        //                                  Eventos de botones
        p1.bSalir.addActionListener(new ActionListener() {//  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        p1.bConfi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pe.ventanaConfig();
                v1.setVisible(false);
            }
        });
        
        p1.bNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pe.ventanJuego();
                v1.setVisible(false);
//                pPanel.lVelo.setText("x"+String.valueOf(velocidad1));
                pPanel.lVelo.setText("x1");
            }
        });
        
        p1.bPtsMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v1.setVisible(false);
                ganador();
            }
        });
        
        
        v1.repaint();
    }
//    PConfig pItems;
    public void ventanaConfig(){
        v2 = new VInicio("Configuración");
        v2.setVisible(true);
        //                              Dar SIEMPRE 16px en X | 39px en Y
        v2.setBounds(200,75,816,639);
        v2.getContentPane().setBackground(Color.black);
        
        pItems = new PConfig();
        Border bItemsColor = BorderFactory.createLineBorder(Color.white);
        Border bItems = BorderFactory.createTitledBorder(bItemsColor, "ITEMS", 0, 0, new Font("Calibri",Font.BOLD,25), Color.white);
        pItems.setBorder(bItems);
        pItems.setBounds(30,50,400,500);//30----430----40---470+300=770-----30
        pItems.ComponentesPItems();
        v2.add(pItems);
        
        PConfig pVelo = new PConfig();
        Border bVeloColor = BorderFactory.createLineBorder(Color.white);
        Border bVelo = BorderFactory.createTitledBorder(bVeloColor, "VELOCIDAD", 0, 0, new Font("Calibri",Font.BOLD,25), Color.white);
        pVelo.setBorder(bVelo);
        pVelo.setBounds(470,50,300,200);
        pVelo.componentesPVelo();
        v2.add(pVelo);
        
        PConfig pTiempo = new PConfig();
        Border bTiempoColor = BorderFactory.createLineBorder(Color.white);
        Border bTiempo = BorderFactory.createTitledBorder(bTiempoColor, "TIEMPO", 0, 0, new Font("Calibri",Font.BOLD,25), Color.white);
        pTiempo.setBorder(bTiempo);
        pTiempo.setBounds(470,275,300,200);
        pTiempo.componentesPTiempo();
        v2.add(pTiempo);
        
        //                  Agregando los botones al panel 
        PConfig pBotones = new PConfig();
        pBotones.setVisible(true);
        pBotones.setLayout(null);
        pBotones.setBounds(470,498,300,200);
        pBotones.botones();
        v2.add(pBotones);
        
        //                          Eventos con los botones
        pBotones.bGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(pItems.cbFrecuencia.getSelectedItem().toString()=="Elija la frecuencia"
                        || pItems.tfTiempo.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "No seleccionó frecuencia o tiempo");
                }else{
                    cantTiempo = Integer.parseInt(pTiempo.tfTiempo.getText());
                    cambios = true;
                    nivelVelo = pVelo.cbVelo.getSelectedItem().toString();
                    nivelFrec = pItems.cbFrecuencia.getSelectedItem().toString();
                    System.out.println(nivelFrec);
                    if(nivelFrec.equals("Poco Frecuente")){
                        nivelFrec = "11";
                    }else if(nivelFrec.equals("Normal")){
                        nivelFrec = "8";
                    }else if(nivelFrec.equals("Muy Frecuente")){
                        nivelFrec = "5";
                    }
                    if(nivelVelo.equals("Normal")){
                        velocidad1=1;
                    }else{
                        velocidad1=2;
                    }
                    v2.dispose();
                    v1.setVisible(true);
                    if(PConfig.cb1.isSelected()&&PConfig.cb2.isSelected()&&PConfig.cb3.isSelected()
                            &&PConfig.cb4.isSelected()&&PConfig.cb5.isSelected()&&PConfig.cb6.isSelected()){
                        System.out.println("es");
                    }else{
                        System.out.println("nel");
                    }
                    JOptionPane.showMessageDialog(null, "Cambios Guardados");
                }
            }
        });
        
        
        
        
        pBotones.bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v2.dispose();
                v1.setVisible(true);
            }
        });
    }
    
    int x,y;
    public void ventanJuego(){
        v3 = new VInicio("Invasores Espaciales");
        v3.setVisible(true);
        //                              Dar SIEMPRE 16px en X | 39px en Y
        v3.setBounds(150,50,916,689);
        
        pPanel = new PPanelJuego();
        pPanel.setBounds(0,0,900,100);
        v3.add(pPanel);
        
        
        
        pJuego = new PNuevoJuego();
        pJuego.setBounds(0,100,900,550);
        pJuego.nave();
//        pJuego.enemigos();
        v3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
                x = pJuego.lNAVE.getX();
                y = pJuego.lNAVE.getY();//Limite en y=4 y Y=498
//                switch(ke.getExtendedKeyCode()){
//                    case KeyEvent.VK_UP:
//                        if(pJuego.lNAVE.getY()>=4){
//                            pJuego.lNAVE.setLocation(x,y-6);
//                        }
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        if(pJuego.lNAVE.getY()<=498){
//                            pJuego.lNAVE.setLocation(x,y+6);
//                        }
//                        break;
//                }

                //                                   Funciona de la misma forma que arriba
                if(KeyEvent.VK_UP == ke.getExtendedKeyCode()|| KeyEvent.VK_W == ke.getExtendedKeyCode()){
                    
                    if(pJuego.lNAVE.getY()>=4){
                        pJuego.lNAVE.setLocation(x,y-veloNave);
                    }
                    if(pJuego.lNAVE.getY()>=4){
                        pJuego.rNAVE.setLocation(x,y-veloNave);
                    }
//                    System.out.println(pJuego.rNAVE.getY());
                    for(int i=0;i<8;i++){
                        if(pJuego.rNAVE.intersects(EnemigoTipo1.rec[i])&&EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
                            System.out.println("si");
                        }
                    }
                }
                if(KeyEvent.VK_DOWN == ke.getExtendedKeyCode()|| KeyEvent.VK_S == ke.getExtendedKeyCode()){
                    if(pJuego.lNAVE.getY()<=498){
                        pJuego.lNAVE.setLocation(x,y+veloNave);
                    }
                    if(pJuego.lNAVE.getY()>=4){
                        pJuego.rNAVE.setLocation(x,y-veloNave);
                    }
                }
                if(estaCongelado == false){
                
                    if(KeyEvent.VK_SPACE == ke.getExtendedKeyCode()){
                        bala = new Disparo(95,pJuego.lNAVE.getY()+14, pJuego);
                        bala.start();
                    
//                    int gana=0;
//                    if(gana<8){
//                        for(int i=0; i<16;i++){
//                            if(!EnemigoTipo3.lEnemigoTipo3[i].isVisible()){
//                                gana++;
//                            }
//                        }
//                    }
//                    if(gana<24){
//                        for(int i=0; i<16;i++){
//                            if(!EnemigoTipo2.lEnemigoTipo2[i].isVisible()){
//                                gana++;
//                            }
//                        }
//                    }
//                    if(gana<40){
//                        for(int i=0; i<8;i++){
//                            if(!EnemigoTipo1.lEnemigoTipo1[i].isVisible()){
//                                gana++;
//                            }
//                        }
//                    }
//                    if(gana==40){
//                        Practica3.pPanel.tarea.cancel();
//                        JOptionPane.showMessageDialog(null, "ganaste");
//                    }
                    
                    }
                }
                int numlabel;
                if(KeyEvent.VK_ESCAPE == ke.getExtendedKeyCode()){
                    cambios = false;
                    nivelFrec = "";
                    numlabel = Integer.parseInt(pPanel.lTiempo.getText());
                    if(continuar == true && bala==null){
                        for(int i=0;i<16;i++){
                            ene1[i].suspend();
                            ene2[i].suspend();
                            ene3[i].suspend();
                            continuar = false;
                        }
                    }
                    else if(continuar == true && bala!=null){
                        bala.suspend();
                        for(int i=0;i<16;i++){
                            ene1[i].suspend();
                            ene2[i].suspend();
                            ene3[i].suspend();
                            continuar = false;
                        }
                    }
                    
                    int des = JOptionPane.showConfirmDialog(null, "¿Desea continuar el juego?");
                    System.out.println(des);
                    if(des==0){
                        pPanel.lTiempo.setText(String.valueOf(numlabel));
                        if(continuar == false && bala==null){
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                            }
                        }

                        else if(continuar == false && bala!=null){
                            pPanel.lTiempo.setText(String.valueOf(numlabel));
                            bala.resume();
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                            }
                        }
                    }else if(des==2){
                        pPanel.lTiempo.setText(String.valueOf(numlabel));
                        if(continuar == false && bala==null){
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                            }
                        }

                        else if(continuar == false && bala!=null){
                            pPanel.lTiempo.setText(String.valueOf(numlabel));
                            bala.resume();
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                            }
                        }
                    }else if(des==-1){
                        pPanel.lTiempo.setText(String.valueOf(numlabel));
                        if(continuar == false && bala==null){
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                                
                            }
                        }
                        else if(continuar == false && bala!=null){
                            pPanel.lTiempo.setText(String.valueOf(numlabel));
                            bala.resume();
                            for(int i=0;i<16;i++){
                                ene1[i].resume();
                                ene2[i].resume();
                                ene3[i].resume();
                                continuar = true;
                            }
                        }
                    }else{
                        cambios = false;
                        pPanel.tarea.cancel();
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
                        v1.setVisible(true);
                    }
                    
                    
                    
                }
            }
            
            @Override
            public void keyReleased(KeyEvent ke){
            }
        });
        
        int posy = 40;
        int posx = 725;//785
        for(int i=0;i<16;i++){
            ene1[i] = new EnemigoTipo1(posx, posy, pJuego, i);
            ene1[i].start();
            posy +=60;
        }
        //
        posy=40;
        posx=775;
        for(int i=0;i<16;i++){
            ene2[i] = new EnemigoTipo2(posx, posy, pJuego, i);
            ene2[i].start();
            posy +=60;
            if(i==7){
                posx+=40;
                posy=40;
            }
        }
        posy=40;
        posx=865;
        for(int i=0;i<16;i++){
            ene3[i] = new EnemigoTipo3(posx, posy, pJuego, i);
            ene3[i].start();
            posy +=60;
            if(i==7){
                posx+=40;
                posy=40;
            }
        }
        
        //                      AGREGAR AQUI LOS ITEMS Y VALIDAR LA CANTIDAD O SI SE JUEGA CON LOS
        //                                              AJUSTES PRDETERMINADOS
        //                                                          O
        //                                              EN EL PANEL DE PPANELJUEGO
        
        
//        if(ene1.rec.intersects(bala.recb)){
//            System.out.println("a ver");
//        }
        

        v3.add(pJuego);
        
    }
    
    public static void ganador(){
        PTop5 pTop = new PTop5();
        v4 = new VInicio("Top 5 mejores puntuaciones");
        v4.setVisible(true);
        v4.setBounds(375,100,500,525);
        v4.add(pTop);
//        nombresWin[0] = "----";
//        nombresWin[1] = "----";
//        nombresWin[2] = "----";
//        nombresWin[3] = "----";
//        nombresWin[4] = "----";
//        nombresWin[5] = "----";
        
//        ptsWin[0] = 12;
//        ptsWin[1] = 45;
//        ptsWin[2] = 23;
//        ptsWin[3] = 3;
//        ptsWin[4] = 26;
//        ptsWin[5] = 24;
        
        try{
            File Arch = new File("C:\\reportes\\nombres1.txt");
            if(!Arch.exists()){
                System.out.println("");
            }else{
                try{
                    BufferedReader br = new BufferedReader(new FileReader("C:\\reportes\\nombres1.txt"));
                    String leer1 = br.readLine();
                    while(leer1 != null){
                        String comas[] = leer1.split(",");
                            for(int i=0; i<comas.length;i++){
                                campo[i] = (comas[i]);       
                            }
                        System.out.println("");
                        nombresWin[0]=campo[0];
                        nombresWin[1]=campo[1];
                        nombresWin[2]=campo[2];
                        nombresWin[3]=campo[3];
                        nombresWin[4]=campo[4];
                        leer1 = br.readLine();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
        }
        
        try{
            File Arch = new File("C:\\reportes\\pts1.txt");
            if(!Arch.exists()){
                System.out.println("");
            }else{
                try{
                    BufferedReader br = new BufferedReader(new FileReader("C:\\reportes\\pts1.txt"));
                    String leer1 = br.readLine();
                    while(leer1 != null){
                        String comas[] = leer1.split(",");
                            for(int i=0; i<comas.length;i++){
                                campo[i] = (comas[i]);       
                            }
                        System.out.println("");
                        ptsWin[0]=Integer.parseInt(campo[0]);
                        ptsWin[1]=Integer.parseInt(campo[1]);
                        ptsWin[2]=Integer.parseInt(campo[2]);
                        ptsWin[3]=Integer.parseInt(campo[3]);
                        ptsWin[4]=Integer.parseInt(campo[4]);
                        leer1 = br.readLine();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
        }
        
        
        nombre = "";
        puntuacionFinal = "";
        for (int x = 0; x < ptsWin.length; x++){
            for (int i = 0; i < ptsWin.length-x-1; i++){
                if(ptsWin[i] < ptsWin[i+1]){
                    int tmp = ptsWin[i+1];
                    String tmps = nombresWin[i+1];
                    ptsWin[i+1] = ptsWin[i];
                    ptsWin[i] = tmp;
                    nombresWin[i+1] = nombresWin[i];
                    nombresWin[i] = tmps;
                }
            }
        }
        
        try{
            FileWriter fw = new FileWriter("C:\\reportes\\nombres1.txt");
            BufferedWriter br = new BufferedWriter(fw);
            for(int i=0;i<5;i++){
                if(String.valueOf(nombresWin[i]).equals("null")){
                    br.write(String.valueOf("No name"));
                    br.write(",");
                }else{
                    br.write(String.valueOf(nombresWin[i]));
                    br.write(",");
                }
            }
            br.write(System.getProperty("line.separator"));
            br.close();
        }catch(Exception e){
        }
        
        try{
            FileWriter fw = new FileWriter("C:\\reportes\\pts1.txt");
            BufferedWriter br = new BufferedWriter(fw);
            for(int i=0;i<5;i++){
                if(String.valueOf(ptsWin[i]).equals("0")){
                    br.write(String.valueOf("0"));
                    br.write(",");
                }else{
                    br.write(String.valueOf(ptsWin[i]));
                    br.write(",");
                }
            }
            br.write(System.getProperty("line.separator"));
            br.close();
        }catch(Exception e){
        }
        
        pTop.lNombreNum1.setText(nombresWin[0]);
        pTop.lNombreNum2.setText(nombresWin[1]);
        pTop.lNombreNum3.setText(nombresWin[2]);
        pTop.lNombreNum4.setText(nombresWin[3]);
        pTop.lNombreNum5.setText(nombresWin[4]);
        
        pTop.lPtsNum1.setText(String.valueOf(ptsWin[0]));
        pTop.lPtsNum2.setText(String.valueOf(ptsWin[1]));
        pTop.lPtsNum3.setText(String.valueOf(ptsWin[2]));
        pTop.lPtsNum4.setText(String.valueOf(ptsWin[3]));
        pTop.lPtsNum5.setText(String.valueOf(ptsWin[4]));
        
        pTop.bRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v4.dispose();
                v1.setVisible(true);
            }
        });
        
        
    }
    
    
}
