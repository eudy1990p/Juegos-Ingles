/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos.ingles;

import java.io.*;
import javax.sound.sampled.*;

/**
 *
 * @author Owner
 */
public class Sonidos extends Thread{
    
    private String TipoSonido="";
    
    public Sonidos(String Tipo){
        this.TipoSonido = Tipo;
    }
    
    public void run(){
        switch(this.TipoSonido){
            case "FinJuegoAhorcadoPerder":
                this.getReproductor("has_perdido");
            break;
            
            case "FinJuegoAhorcadoGanar":
                this.getReproductor("has_ganado");
            break;
                
            case "PalabraIncorrectaJuegoAhorcado":
                this.getReproductor("incorrecta");
            break;    
                
            case "PalabraCorrectaJuegoAhorcado":
                this.getReproductor("correcto");
            break;     
        }
    }
    
    public void getReproductor1(String s){
        //Clip sonido = AudioSystem.getClip();
            //File f = new File(getClass().getResource(/Sonidos/alarma.wav).toURI());
           // sonido.open(AudioSystem.getAudioInputStream(f));
            //sonido.start();
        
    }
    
    public void getReproductor(String s)
    {
        //InputStream path;
        String ruta="C:/game_for_teacher/sounds"+"/"+s+".wav";
        //path = getClass().getResourceAsStream(ruta+"/"+s+".wav");
        File file = new File(ruta);
        try
        {
           //FileInputStream path = new FileInputStream(ruta);
           //AudioStream audio = new AudioStream(path);
           //AudioPlayer.player.start(audio);
           Clip sonido = AudioSystem.getClip();
           sonido.open(AudioSystem.getAudioInputStream(file));
           //sonido.open(AudioSystem.getAudioInputStream(path));
           sonido.start();
           
        }
        catch(Exception fallo)
        {
            System.out.println(fallo);
        }
    }       
    
}
