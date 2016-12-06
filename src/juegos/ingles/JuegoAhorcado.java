/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos.ingles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class JuegoAhorcado extends javax.swing.JFrame {
    
    private String palabraOculta;
    private String Letra,Respuestas="",LetrasMensionadas="";
    private int LongitudPalabraOculta,vidas = 6,TotalLetras;
    private String[] ArregloRespuesta,ArregloPalabra;
    private Boolean Respondio=false;
    private Imagenes iconAhorcado;
  
    /**
     * Creates new form JuegoAhorcado
     */
    public JuegoAhorcado(String p) {
        try{
        initComponents();
        this.setTitle("Hang Man");
        this.palabraOculta = p;
        this.ContarLetrasPalabraOculta(p);
        this.iconAhorcado = new Imagenes(this.jLabel2);
        this.iconAhorcado.setImage(""+vidas);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(((screenSize.width) - this.getWidth()),0);
        }catch(Exception e){
         //JOptionPane.showMessageDialog(null, "Error "+e);
        }
        //this.jLabel2.setText(""+vidas);
    }
    public void setLetra(String l){
        //comparar la letra enviada para ver si coinside y si es asi poner el fondo verde de lo contrario rojo
        this.Respuestas = "";
        for(int i = 0 ; i < this.LongitudPalabraOculta ; i++){
            if(this.ArregloPalabra[i].equals(l)){
                this.llenarTodo(i, " "+l);
                this.Respondio = true;
               if(this.LetrasMensionadas.indexOf(l) == -1){
                    this.TotalLetras--;
                    this.LetrasMensionadas+=l;
                }
                
            }else{
                this.llenarTodo(i);
            }
        }
        if(!this.Respondio){
            this.vidas--;
            this.iconAhorcado.setImage(""+vidas);
            //this.jLabel2.setText(""+vidas);
            this.jPanel2.setBackground(Color.red);
            this.jLabel4.setText(l);
            Sonidos s = new Sonidos("PalabraIncorrectaJuegoAhorcado");
            s.start();
        }else{
            this.jPanel2.setBackground(Color.GREEN);
            this.jLabel4.setText(l);
            Sonidos s = new Sonidos("PalabraCorrectaJuegoAhorcado");
            s.start();
        }
        this.jLabel3.setText(this.Respuestas);
        if(this.vidas == 0){
            Sonidos s = new Sonidos("FinJuegoAhorcadoPerder");
            s.start();
            JOptionPane.showMessageDialog(null, "You have lost\nThe word is: \n"+this.palabraOculta);
        }else if(this.TotalLetras == 0){
            Sonidos s = new Sonidos("FinJuegoAhorcadoGanar");
            s.start();
            JOptionPane.showMessageDialog(null, "Congratulation, You have won.");
            
        }
        this.Respondio = false;
    }
    public int getTotalLetras(){
        return this.TotalLetras;
    }
    public int getVidas(){
        return this.vidas;
    }
    public void ContarLetrasPalabraOculta(String p){
        this.LongitudPalabraOculta = p.length();
        this.ArregloRespuesta = new String[this.LongitudPalabraOculta];
        this.ArregloPalabra = new String[this.LongitudPalabraOculta];
        this.validarPalabra();
    }
    public void validarPalabra(){
            String aux = "";
            for(int i = 0 ; i < this.LongitudPalabraOculta ; i++){
                aux = this.palabraOculta.substring(i, i+1);
                if(aux.equals(" ")){
                    this.llenarTodo(i, aux, "  ");
                }else{
                    this.llenarTodo(i, aux, " _");
                    JOptionPane.showMessageDialog(null, "index of "+ this.LetrasMensionadas.indexOf(aux)
                    +" letra "+aux+" Letra mensionada "+ LetrasMensionadas);
                    if(this.LetrasMensionadas.indexOf(aux) == -1){
                        this.TotalLetras++;
                        this.LetrasMensionadas+=aux;
                    }
                }
            }
            this.LetrasMensionadas = "";
            this.jLabel3.setText(this.Respuestas.toString());
       
    }
    public void llenarTodo(int i,String Respuesta){
        this.ArregloRespuesta[i] = Respuesta;
        this.Respuestas+= Respuesta;
    }
    public void llenarTodo(int i){
        this.Respuestas+= " "+this.ArregloRespuesta[i];
    }
    public void llenarTodo(int i,String letra,String NoRepuesta){
        this.ArregloPalabra[i] = letra;
        this.ArregloRespuesta[i] = NoRepuesta;
        this.Respuestas+=NoRepuesta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hangman");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Hangman");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel4.setFont(new java.awt.Font("Lucida Calligraphy", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
