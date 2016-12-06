/*
 * Copyright 2016 Eudy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package juegos.ingles;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Eudy
 */
public class ProccerRando {
    
    private ArrayList<String> Lines = new ArrayList<String>();
    private int saltos=0;
    private int total = 0;
    private int index = 0;
    private JTextArea jTextArea1,TextResult;
    private String StringResult="";
    
    public ProccerRando(){ }
    
    public void getNumberRandom(){
        Random r = new Random();
        this.index = r.nextInt(this.total);        
        int delete = JOptionPane.showConfirmDialog(null,"The name is : "+this.Lines.get(this.index),"Would you like to remove that name?",JOptionPane.YES_NO_OPTION);
        
        if(delete == 0){
            this.StringResult = this.StringResult + this.Lines.get(this.index)+"\n";
            this.TextResult.setText(this.StringResult);
            this.deletePosition(index);
            this.jTextArea1.setText(String.join("\n",this.Lines));
             
        }
    }
    public void deletePosition(int index){
        if(this.total > 0){
        this.Lines.remove(index);
        this.total--;
        }else{
            JOptionPane.showMessageDialog(null, "The list finished.");
        }
    }
    
    public void GetListText(JTextArea jTextArea1,JTextArea jTextArea2){
        this.jTextArea1 = jTextArea1;
        this.TextResult = jTextArea2;
        String texto = this.jTextArea1.getText();
        String TextoArrayLineas[] = texto.split("\n");
        saltos = TextoArrayLineas.length;
        for(int i = 0 ; i < saltos ; i++){
            Lines.add(TextoArrayLineas[i]);
        }
        this.total = this.saltos;
        this.getNumberRandom();
        
    }
    public int getTotal(){
        return this.total;
    }
    
   /* public static void main(String[] arg){
        ProccerRando PR = new ProccerRando();
    }*/
}
