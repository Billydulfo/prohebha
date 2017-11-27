
package clases;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */
public class Nave {/*La nave se mueve con w,z,a,s recordatorio.*/
    private String nave;
    
    /* desplazamiento*/
    private int dx;
    private int dy;
    
    
    /* posicion de la roca*/
    private int x;
    private int y;
   
     /*Atributo Imagen*/
    private Image imagen;
    
    public Nave(int x, int y){
        this.x =x;
        this.y =y;
        nave= "a573834cf3b21a8ad4ac8bf2399ea41f.gif";
        ImageIcon img = new ImageIcon(this.getClass().getResource(nave)); 
        imagen = img.getImage();
    }
    
    /* Inicio Movimiento de Objeto*/
       public void Keypressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A){
            dx = -1;
        }
        if(key == KeyEvent.VK_S){
            dx = +1;
        }
        if(key == KeyEvent.VK_W){
            dy = -1;
        }
        if(key == KeyEvent.VK_Z){
            dy = +1;
        }
    }
    
    /*Metodo para detectar que se soltaron las telas*/
    public void KeyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_A){
            dx = 0;
        }
        if(key == KeyEvent.VK_S){
            dx = 0;
        }
        if(key == KeyEvent.VK_W){
            dy = 0;
        }
        if(key == KeyEvent.VK_Z){
            dy = 0;
        }
    }
    
    /*Metodo para mover*/
    public void Mover(){
        x+=dx;
        y+=dy;
    }
    
     public int noMover(){ /*Cambio de imagen que genera la explosion animada*/
        this.nave="supercontraexplosiona.gif";
        ImageIcon img = new ImageIcon(this.getClass().getResource(nave)); 
        imagen = img.getImage();
        this.tenerImagen();
        return 1;
    }
    
    
    /* Inicio Movimiento de Objeto*/
    public int tenerX(){
        return x;
    }
    
      public int tenerY(){
        return y;
    }
      
    public Image tenerImagen(){
        return imagen;
    }
    
     public Rectangle getBounds(){      /*encuadra el objeto para coaliciones*/
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }
    
}