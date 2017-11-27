/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jhon Nash
 */
public class GameOver extends JPanel{
    private JLabel jLabel,jLabel1;
    
    public GameOver(int k){
        setBackground(Color.BLACK);
        if(k==0){
                    jLabel = new JLabel("Perdiste tu vuelo"); 
                    this.add(jLabel);
        }else{
           jLabel1 = new JLabel("Gano la humanidad, el arma contenia una bomba de autodestruccion"); 
        }
        
        
        
    }
    
}
