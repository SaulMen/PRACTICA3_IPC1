
package practica3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.JPanel;

public class PTop5 extends JPanel{
    
    public PTop5(){
        setVisible(true);
        setLayout(null);
        setBounds(0,0,500,525);
        setBackground(Color.black);
        componenetes();
    }
    
    JButton bRegresar;
    JLabel lNombreNum1, lNombreNum2, lNombreNum3, lNombreNum4, lNombreNum5;
    JLabel lPtsNum1, lPtsNum2, lPtsNum3, lPtsNum4, lPtsNum5;
    public void componenetes(){
        bRegresar = new JButton("Regresar");
        bRegresar.setVisible(true);
        bRegresar.setLayout(null);
        bRegresar.setBounds(190,430,120,30);
        bRegresar.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(bRegresar);
        
        JLabel lpuntuaciones = new JLabel("Mejores puntuaciones");
        lpuntuaciones.setVisible(true);
        lpuntuaciones.setLayout(null);
        lpuntuaciones.setOpaque(true);
        lpuntuaciones.setBounds(110,20,280,30);
        lpuntuaciones.setBackground(Color.black);
        lpuntuaciones.setForeground(Color.white);
        lpuntuaciones.setFont(new Font("Calibri",Font.BOLD,30));
        this.add(lpuntuaciones);
        
        JLabel lnombres = new JLabel("Nombre");
        lnombres.setVisible(true);
        lnombres.setLayout(null);
        lnombres.setOpaque(true);
        lnombres.setBounds(150,80,100,20);
        lnombres.setBackground(Color.black);
        lnombres.setForeground(Color.white);
        lnombres.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnombres);
        
        JLabel lpuntos = new JLabel("Puntos");
        lpuntos.setVisible(true);
        lpuntos.setLayout(null);
        lpuntos.setOpaque(true);
        lpuntos.setBounds(330,80,100,20);
        lpuntos.setBackground(Color.black);
        lpuntos.setForeground(Color.white);
        lpuntos.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lpuntos);
        
        
        JLabel lnum1 = new JLabel("1.");
        lnum1.setVisible(true);
        lnum1.setLayout(null);
        lnum1.setOpaque(true);
        lnum1.setBounds(70,130,20,20);
        lnum1.setBackground(Color.black);
        lnum1.setForeground(Color.white);
        lnum1.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnum1);
        
        JLabel lnum2 = new JLabel("2.");
        lnum2.setVisible(true);
        lnum2.setLayout(null);
        lnum2.setOpaque(true);
        lnum2.setBounds(70,190,20,20);
        lnum2.setBackground(Color.black);
        lnum2.setForeground(Color.white);
        lnum2.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnum2);
        
        
        JLabel lnum3 = new JLabel("3.");
        lnum3.setVisible(true);
        lnum3.setLayout(null);
        lnum3.setOpaque(true);
        lnum3.setBounds(70,250,20,20);
        lnum3.setBackground(Color.black);
        lnum3.setForeground(Color.white);
        lnum3.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnum3);
        
        JLabel lnum4 = new JLabel("4.");
        lnum4.setVisible(true);
        lnum4.setLayout(null);
        lnum4.setOpaque(true);
        lnum4.setBounds(70,310,20,20);
        lnum4.setBackground(Color.black);
        lnum4.setForeground(Color.white);
        lnum4.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnum4);
        
        JLabel lnum5 = new JLabel("5.");
        lnum5.setVisible(true);
        lnum5.setLayout(null);
        lnum5.setOpaque(true);
        lnum5.setBounds(70,370,20,20);
        lnum5.setBackground(Color.black);
        lnum5.setForeground(Color.white);
        lnum5.setFont(new Font("Calibri",Font.BOLD,20));
        this.add(lnum5);
        
        lNombreNum1 = new JLabel("nombre 1");
        lNombreNum1.setVisible(true);
        lNombreNum1.setLayout(null);
        lNombreNum1.setOpaque(true);
        lNombreNum1.setBounds(120,130,100,20);
        lNombreNum1.setBackground(Color.blue);
        lNombreNum1.setForeground(Color.white);
        lNombreNum1.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNombreNum1);
        
        lNombreNum2 = new JLabel("nombre 2");
        lNombreNum2.setVisible(true);
        lNombreNum2.setLayout(null);
        lNombreNum2.setOpaque(true);
        lNombreNum2.setBounds(120,190,100,20);
        lNombreNum2.setBackground(Color.blue);
        lNombreNum2.setForeground(Color.white);
        lNombreNum2.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNombreNum2);
        
        lNombreNum3 = new JLabel("nombre 3");
        lNombreNum3.setVisible(true);
        lNombreNum3.setLayout(null);
        lNombreNum3.setOpaque(true);
        lNombreNum3.setBounds(120,250,100,20);
        lNombreNum3.setBackground(Color.blue);
        lNombreNum3.setForeground(Color.white);
        lNombreNum3.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNombreNum3);
        
        lNombreNum4 = new JLabel("nombre 4");
        lNombreNum4.setVisible(true);
        lNombreNum4.setLayout(null);
        lNombreNum4.setOpaque(true);
        lNombreNum4.setBounds(120,310,100,20);
        lNombreNum4.setBackground(Color.blue);
        lNombreNum4.setForeground(Color.white);
        lNombreNum4.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNombreNum4);
        
        lNombreNum5 = new JLabel("nombre 5");
        lNombreNum5.setVisible(true);
        lNombreNum5.setLayout(null);
        lNombreNum5.setOpaque(true);
        lNombreNum5.setBounds(120,370,100,20);
        lNombreNum5.setBackground(Color.blue);
        lNombreNum5.setForeground(Color.white);
        lNombreNum5.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNombreNum5);
        
        lPtsNum1 = new JLabel();
        lPtsNum1.setVisible(true);
        lPtsNum1.setLayout(null);
        lPtsNum1.setOpaque(true);
        lPtsNum1.setBounds(320,130,100,20);
        lPtsNum1.setBackground(Color.blue);
        lPtsNum1.setForeground(Color.white);
        lPtsNum1.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lPtsNum1);
        
        lPtsNum2 = new JLabel();
        lPtsNum2.setVisible(true);
        lPtsNum2.setLayout(null);
        lPtsNum2.setOpaque(true);
        lPtsNum2.setBounds(320,190,100,20);
        lPtsNum2.setBackground(Color.blue);
        lPtsNum2.setForeground(Color.white);
        lPtsNum2.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lPtsNum2);
        
        lPtsNum3 = new JLabel();
        lPtsNum3.setVisible(true);
        lPtsNum3.setLayout(null);
        lPtsNum3.setOpaque(true);
        lPtsNum3.setBounds(320,250,100,20);
        lPtsNum3.setBackground(Color.blue);
        lPtsNum3.setForeground(Color.white);
        lPtsNum3.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lPtsNum3);
        
        lPtsNum4 = new JLabel();
        lPtsNum4.setVisible(true);
        lPtsNum4.setLayout(null);
        lPtsNum4.setOpaque(true);
        lPtsNum4.setBounds(320,310,100,20);
        lPtsNum4.setBackground(Color.blue);
        lPtsNum4.setForeground(Color.white);
        lPtsNum4.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lPtsNum4);
        
        lPtsNum5 = new JLabel();
        lPtsNum5.setVisible(true);
        lPtsNum5.setLayout(null);
        lPtsNum5.setOpaque(true);
        lPtsNum5.setBounds(320,370,100,20);
        lPtsNum5.setBackground(Color.blue);
        lPtsNum5.setForeground(Color.white);
        lPtsNum5.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lPtsNum5);
        
        
    }
    
}
