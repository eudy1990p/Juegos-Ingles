/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos.ingles;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Eudy
 */
public class CaptureString extends javax.swing.JFrame {

    /**
     * Creates new form CaptureString
     */
    private int height;
    private PreparadorJLabels VC; 
    JPanel contenedor;
    public CaptureString() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hiding Words Teacher");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 11)); // NOI18N
        jButton1.setText("Show Conversation");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 3, 17)); // NOI18N
        jLabel1.setText("Put into the box your Conversation");

        jButton2.setFont(new java.awt.Font("Lucida Calligraphy", 1, 11)); // NOI18N
        jButton2.setText("Clear Box");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(!this.jTextArea1.getText().isEmpty()){
            VC = new PreparadorJLabels();
            VC.setText(this.jTextArea1);
            VC.showWindow();
        }else{
            JOptionPane.showMessageDialog(null, "You need to add text into the box before click on the button Show Conversation.");
        }
        // Only for this class
        //Container contenedor = VC.getContenedor();
        //contenedor = VC.getJPanel();
        //this.GetText(contenedor);
       // VC.showWindow(height);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        if(!this.jTextArea1.getText().isEmpty()){
            this.jTextArea1.setText("");
            this.VC.dispose();
            this.VC = null;
            this.contenedor = null;
        }
    }//GEN-LAST:event_jButton2MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
    private void GetText(JPanel contenedor){
         String texto = this.jTextArea1.getText();
         String TodoTextoArray[] = texto.split(" ");
         total = TodoTextoArray.length+1;
                 
         String TextoArrayLineas[] = texto.split("\n");
         saltos = TextoArrayLineas.length;
         this.height = saltos;
         total += saltos;
         total *= 2;
         //System.out.println("Total "+total+" saltos "+saltos);
         
         
         this.ListaPalabras = new JLabel[total];
         
         for(int i = 0 ; i < saltos ; i++){
             String palabras[] = TextoArrayLineas[i].split(" ");
             //System.out.println("Separado por lineas "+palabras.length);
             for(int p = 0 ; p < palabras.length ; p++){
                //System.out.println("Linea "+i+" Total palabras por lineas "+palabras.length);
                 
                this.ListaPalabras[contador] = new JLabel(" ");
                this.ListaPalabras[contador].setText(palabras[p]);
                this.ListaPalabras[contador].setForeground(Color.black);
                //Font auxFont = this.ListaPalabras[contador].getFont();
                Font fuente=new Font("Dialog", Font.BOLD, 20);
                this.ListaPalabras[contador].setFont(fuente);
                
                //System.out.println(this.ListaPalabras[contador].getText()+" - "+ p);
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
                //contenedor.setViewportView(this.ListaPalabras[contador]);
                //System.out.println("Preparar "+p+" total de palabras "+palabras.length);
                if(p == (palabras.length - 1)){
                   contador++;
                   this.ListaPalabras[contador] = new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");     
                   //System.out.println("Salto de linea "+contador);
                   contenedor.add(this.ListaPalabras[contador]);
                }
                
                
                contador++;
             }
         }
         
         
    }
      
    private int saltos,total,contador=0;
    private JLabel[] ListaPalabras;
}
