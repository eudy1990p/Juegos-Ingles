/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos.ingles;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Owner
 */
public class Imagenes {
    
    private JLabel j;
    
    public Imagenes(JLabel j){
        this.j = j;
    }
    
    public void setImage(String r){
        String ruta="C:/game_for_teacher/images/img"+r+".png";
        ImageIcon ImI = new ImageIcon(ruta/*getClass().getResource("../../imagenes/img"+r+".png")*/);
        ImageIcon icono = new ImageIcon(ImI.getImage().getScaledInstance(this.j.getWidth(), this.j.getHeight(), Image.SCALE_DEFAULT));
        this.j.setIcon(icono);
    }
    
    
}
