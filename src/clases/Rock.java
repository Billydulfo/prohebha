/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */
package clases;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Rock {
    private String rock;
    
    /* posicion de la roca*/
    private int x;
    private int y;
   
     /*Atributo Imagen*/
    private Image imagen;
    
    public Rock(int x, int y){
        this.x =x;
        this.y =y;
        rock= "diamond (1).png";
        ImageIcon img = new ImageIcon(this.getClass().getResource(rock)); 
        imagen = img.getImage();
    }
     
    public int tenerX(){
        return x;
    }
    
      public int tenerY(){
        return y;
    }
      
    public Image tenerImagen(){
        return imagen;
    }
    
    public Rectangle getBounds(){ /* encuadra el objeto para coaliciones*/
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }
    
}
