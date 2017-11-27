/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */
package principal;

import clases.Menu;
import clases.Ventana;
import javax.swing.JFrame;


public class Principal {
    public static void main(String[] args){
        Ventana ventana = new Ventana();
        Menu menu=new Menu();
        menu.setVisible(true);
       /* ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
*/
    }
}
