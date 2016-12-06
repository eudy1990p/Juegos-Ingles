/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos.ingles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;



/**
 *
 * @author Owner
 */
public class PreparadorJLabels extends javax.swing.JFrame {

    /**
     * Creates new form PreparadorJLabels
     */
    private JLabel[] j;
    private JLabel jlabel = new JLabel();
    private int clic,i;
    private Container contenedor = null;
    private Scroller VPS = null;
    private int saltos,total,contador=0;
    private JLabel[] ListaPalabras;
    private int height;
    //private JScrollPane jsp;

    
    public PreparadorJLabels(/*JLabel[] JLabelString*/) {
        /*initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        contenedor = this.getContentPane();
        this.contenedor.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.contenedor.setBackground(Color.white);
        */
        this.VPS = null;
        this.contenedor = null;
        VPS = new Scroller();
        
        //Toolkit t = Toolkit.getDefaultToolkit();
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize(screenSize.width, screenSize.height);
        
       //JScrollPane jsp = new JScrollPane(this.contenedor,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       //jsp = new JScrollPane();
       //jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       //jsp.setLayout(new ScrollPaneLayout());
       
       //jsp.setLayout(new ScrollPaneLayout());
       //jsp.setMinimumSize(new Dimension(1000, 500));
       //jsp.setBorder(BorderFactory.createTitledBorder("Visualizer Information"));
       //jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
        
       //this.setMaximumSize(new Dimension(contenedor.getPreferredSize()));
       //this.setMaximumSize(new Dimension(1000,500));
       //this.setContentPane(jsp);
       //this.getContentPane().add(jsp);
       //this.add(jsp, BorderLayout.CENTER);
       //this.add(jsp);
       //this.setNewJLabel();
    }
    
    public void setText(JTextArea jTextArea1){
         JPanel contenedor = this.getJPanel();
         String texto = jTextArea1.getText();
         String TodoTextoArray[] = texto.split(" ");
         total = TodoTextoArray.length+1;
         String TextoArrayLineas[] = texto.split("\n");
         saltos = TextoArrayLineas.length;
         this.height = saltos;
         total += saltos;
         total *= 2;
         this.ListaPalabras = new JLabel[total];
         for(int i = 0 ; i < saltos ; i++){
             String palabras[] = TextoArrayLineas[i].split(" ");
             for(int p = 0 ; p < palabras.length ; p++){
                this.ListaPalabras[contador] = new JLabel(" ");
                this.ListaPalabras[contador].setText(palabras[p]);
                this.ListaPalabras[contador].setForeground(Color.black);
                Font fuente=new Font("Dialog", Font.BOLD, 20);
                this.ListaPalabras[contador].setFont(fuente);
                this.ListaPalabras[contador].addMouseListener(new MouseListener() {
                            public void mouseClicked(MouseEvent arg0) {
                                    if(arg0.getComponent().getForeground() == Color.white){
                                        arg0.getComponent().setForeground(Color.black);
                                    }else{
                                        arg0.getComponent().setBackground(Color.white);
                                        arg0.getComponent().setForeground(Color.white);
                                    }
                            }
                            public void mouseEntered(MouseEvent arg0) {}
                            public void mouseExited(MouseEvent arg0) {}
                            public void mousePressed(MouseEvent arg0) {}
                            public void mouseReleased(MouseEvent arg0) {}
                    });
                
                contenedor.add(this.ListaPalabras[contador]);
                if(p == (palabras.length - 1)){
                   contador++;
                   this.ListaPalabras[contador] = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
                   contenedor.add(this.ListaPalabras[contador]);
                }                
                contador++;
             }
         }
         
         
    }
    
    public JPanel getJPanel(){
        return this.VPS.getJPanel();
    }
    public Container getContenedor(){
        return this.contenedor;
    }
    public void showWindow(){
         /*this.pack();
         this.setVisible(true);*/
         VPS.showWindowWithScroll(this.height);
    }
    public void showWindow(int height){
         /*this.pack();
         this.setVisible(true);*/
         VPS.showWindowWithScroll(height);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hiding Word Students");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    public class Scroller extends JFrame {
        private JScrollPane scroll= null;
        private JPanel panel = null;
       
        
    public Scroller() throws HeadlessException {
        panel = new JPanel();
        
        panel.setBorder(BorderFactory.createLineBorder(Color.white));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.white);
        
        /*
        for(int i = 0 ; i < 50 ; i++){
          panel.add(new JLabel("prueba"));
          
          panel.add(new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "));
        }*/
        
        

        
        
    }
    
    public JPanel getJPanel(){
        return this.panel;
    }
    
    public void showWindowWithScroll(int height){
        height = height * 50;
        panel.setPreferredSize(new Dimension(800, height));
        scroll = new JScrollPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Hiding Word Students");
        add(scroll, BorderLayout.CENTER);
        //setSize(300, 300);
        this.setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

    
    
}
    
}
