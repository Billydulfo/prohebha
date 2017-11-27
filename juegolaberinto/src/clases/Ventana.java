/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */
package clases;

import javax.swing.JFrame;

public class Ventana extends JFrame{
    private final int ANCHO=1000, ALTO=700;
    private TableroJuego lamina;
    public Ventana(){
        setTitle("Laberinto");
        setSize(ANCHO,ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        
    }
    
}
