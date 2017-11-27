/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */



package clases;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Alien {
    /*Variable para guardar ruta de nuestra imagen */
    private String alien;
    
    /* desplazamiento*/
    private int dx;
    private int dy;
    
    /*Posicion*/
    private int x;
    private int y;
    
    /*Atributo Imagen*/
    private Image imagen;
    
    public Alien(int x, int y){
        this.x =x;
        this.y =y;
        alien= "635357293302513753.gif";
        ImageIcon img = new ImageIcon(this.getClass().getResource(alien)); 
        imagen = img.getImage();
    }
    
    /*Metodo para detectar teclado*/
    public void Keypressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = +1;
        }
        if(key == KeyEvent.VK_UP){
            dy = -1;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = +1;
        }
    }
    
    /*Metodo para detectar que se soltaron las telas*/
    public void KeyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 0;
        }
        if(key == KeyEvent.VK_UP){
            dy = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            dy = 0;
        }
    }
    
    /*Metodo para mover*/
    public void Mover(){
        if(x<0 || 990 <x){
            x=-dx;              /* Metodos para no exceder los limites de la pantalla*/
        }else{
            x+=dx; 
        }
        if(y<0||690 <y){
            y=-dy;
        }else{
            y+=dy; 
 
        }
        
      
    }
    /*Si el objeto intersecta con otro ocurre un rechazo*/
  public void noMover(){ /*Cambio de imagen que genera la explosion animada*/
        this.alien="supercontraexplosiona.gif";
        ImageIcon img = new ImageIcon(this.getClass().getResource(alien)); 
        imagen = img.getImage();
        this.tenerImagen();
    
        
    }
  
    public void obstaculoalMover(){             /*El objeto choca y es devuelto a su origen*/
        x=10;
        y=600;
        
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
    
    public Rectangle getBounds(){               /*Metodo para encapsular en un cuadro se genera tambien en clase Rock y Nave para coaliciones*/
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }
}
