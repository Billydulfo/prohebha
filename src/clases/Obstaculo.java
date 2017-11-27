/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */
package clases;

import java.awt.geom.Rectangle2D;

public class Obstaculo {
    private int x;
    private int y;
    private final int ANCHO=5, ALTO=5;
    
    public Obstaculo(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Rectangle2D getObstaculo(){
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);    
    }
}
