
package practica3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PConfig extends JPanel implements ChangeListener{
    
    public PConfig(){
        setVisible(true);
        setLayout(null);
        setBackground(Color.black);
    }
    
    public static JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    JComboBox<String> cbFrecuencia;
    public void ComponentesPItems(){
        cb1 = new JCheckBox("Aumento de tiempo");
        cb1.setVisible(true);
        cb1.setBounds(40,70,300,30);
        cb1.setBackground(Color.black);
        cb1.setOpaque(true);
        cb1.addChangeListener(this);
        cb1.setForeground(Color.white);
        cb1.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb1);
        
        cb2 = new JCheckBox("Puntos extra");
        cb2.setVisible(true);
        cb2.setBounds(40,125,300,30);
        cb2.setBackground(Color.black);
        cb2.setOpaque(true);
        cb2.addChangeListener(this);
        cb2.setForeground(Color.white);
        cb2.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb2);
        
        cb3 = new JCheckBox("Aumento de velocidad");
        cb3.setVisible(true);
        cb3.setBounds(40,175,300,30);
        cb3.setBackground(Color.black);
        cb3.setOpaque(true);
        cb3.addChangeListener(this);
        cb3.setForeground(Color.white);
        cb3.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb3);
        
        cb4 = new JCheckBox("Dismicnución de tiempo");
        cb4.setVisible(true);
        cb4.setBounds(40,225,300,30);
        cb4.setBackground(Color.black);
        cb4.setOpaque(true);
        cb4.addChangeListener(this);
        cb4.setForeground(Color.white);
        cb4.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb4);
        
        cb5 = new JCheckBox("Penalización");
        cb5.setVisible(true);
        cb5.setBounds(40,275,300,30);
        cb5.setBackground(Color.black);
        cb5.setOpaque(true);
        cb5.addChangeListener(this);
        cb5.setForeground(Color.white);
        cb5.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb5);
        
        cb6 = new JCheckBox("Congelación");
        cb6.setVisible(true);
        cb6.setBounds(40,325,300,30);
        cb6.setBackground(Color.black);
        cb6.setOpaque(true);
        cb6.addChangeListener(this);
        cb6.setForeground(Color.white);
        cb6.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cb6);
        
        JLabel lFrecuencia = new JLabel("Frecuencia");
        lFrecuencia.setVisible(true);
        lFrecuencia.setLayout(null);
        lFrecuencia.setOpaque(true);
        lFrecuencia.setBackground(Color.black);
        lFrecuencia.setForeground(Color.white);
        lFrecuencia.setBounds(40,375,100,30);
        lFrecuencia.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lFrecuencia);
        
        cbFrecuencia = new JComboBox<String>();
        cbFrecuencia.setBounds(150,375,200,30);
        cbFrecuencia.addItem("Elija la frecuencia");
        cbFrecuencia.addItem("Poco Frecuente");
        cbFrecuencia.addItem("Normal");
        cbFrecuencia.addItem("Muy Frecuente");
        cbFrecuencia.setBackground(Color.black);
        cbFrecuencia.setForeground(Color.white);
        cbFrecuencia.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cbFrecuencia);
        
    }
    
    JComboBox<String> cbVelo;
    public void componentesPVelo(){
        JLabel lNivel = new JLabel("Nivel");
        lNivel.setBounds(65,75,50,30);
        lNivel.setVisible(true);
        lNivel.setLayout(null);
        lNivel.setBackground(Color.black);
        lNivel.setForeground(Color.white);
        lNivel.setOpaque(true);
        lNivel.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lNivel);
        
        cbVelo = new JComboBox<String>();
        cbVelo.setBounds(125,75,100,30);
        cbVelo.addItem("Normal");
        cbVelo.addItem("Rápida");
        cbVelo.setBackground(Color.black);
        cbVelo.setForeground(Color.white);
        cbVelo.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(cbVelo);
    
    }
    
    static JTextField tfTiempo;
    public void componentesPTiempo(){
        JLabel lTiempo = new JLabel("Segundos");
        lTiempo.setBounds(50,75,85,30);
        lTiempo.setVisible(true);
        lTiempo.setLayout(null);
        lTiempo.setBackground(Color.black);
        lTiempo.setForeground(Color.white);
        lTiempo.setOpaque(true);
        lTiempo.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(lTiempo);
        
        tfTiempo = new JTextField();
        tfTiempo.setBounds(145,75,100,30);
        tfTiempo.setVisible(true);
        tfTiempo.setLayout(null);
        tfTiempo.setBackground(Color.black);
        tfTiempo.setForeground(Color.white);
        tfTiempo.setFont(new Font("Calibri",Font.PLAIN,20));
        this.add(tfTiempo);
        
    }
    
    JButton bGuardar, bSalir;
    public void botones(){
        bGuardar = new JButton("GUARDAR");
        bGuardar.setVisible(true);
        bGuardar.setLayout(null);
        bGuardar.setBorder(null);
        bGuardar.setBackground(Color.green);
        bGuardar.setBounds(0, 0, 135, 50);
        this.add(bGuardar);
        
        bSalir = new JButton("SALIR");
        bSalir.setVisible(true);
        bSalir.setLayout(null);
        bSalir.setBorder(null);
        bSalir.setBackground(Color.red);
        bSalir.setBounds(163, 0, 135, 50);
        this.add(bSalir);
        
    
    }    

    @Override
    public void stateChanged(ChangeEvent ce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
