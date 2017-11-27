/**
 * Proyecto Laberinto
 * @author Billy Diaz De Luis
 * @author Maribel Montoya Hernandez
 * @author Sergio Narciso Lopez
 */

package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TableroJuego extends JPanel implements ActionListener{
    public int k=0;
    Nave nave = new Nave(690,15);
    Alien alien = new Alien(10,580);
    Timer timer = new Timer(5,this);
    private final int NIVEL1=100;
    private ArrayList<Rock> al = new ArrayList();     /*Contenedor de obstaculos*/
       /*Contenedor de obstaculos*/

//crear mas niveles y variable nivel

     
    public TableroJuego(){
        al =crearNivel(NIVEL1);/*creacion de objetos obstaculo*/
        
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new Teclado());
        timer.start();
        
    }
    /*Algoritmo encargado de crear el laberinto del juego*/
    public ArrayList crearNivel(int numObstaculos ) { 
        Random rnd = new Random();
        int rndX=0;
        int rndY=0;
        al = new ArrayList(); 
           /*creacion de posiciones random*/
        for ( int i=0; i < numObstaculos; i++) { 
            rndX=rnd.nextInt(970);
            rndY=rnd.nextInt(550);
            Rock rock = new Rock(rndX,rndY); 
            al.add( rock ); 
           // Rectangle rectangleRock = rock.getBounds();/* se encierra en un cuadro cada roca*/

            
        } 
        return al; 
    } 
    
    
   
    
    //Dibuja los objetos color blanco sobre el tablero
    //Los objetos Graphics2D tienen mas metodos que los objetos Graphics
    public void paintComponent(Graphics g){
        //ArrayList al = new ArrayList();     /*Contenedor de obstaculos*/
        /*Dibuja al alien*/
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D)g;
        g1.drawImage(alien.tenerImagen(), alien.tenerX(),alien.tenerY(), null);
          

        /*Dibujar Nave*/
        Graphics2D g3 = (Graphics2D)g;
        g3.drawImage(nave.tenerImagen(), nave.tenerX(),nave.tenerY(), null);
        
        /*Dibujan los obstaculos grises*/
        Graphics2D g2= (Graphics2D)g;
        dibujar(g2,al,NIVEL1);
        
    }
    /*Dibujan las rocas*/
    public void dibujar(Graphics2D g, ArrayList<Rock> rocks,int numObstaculos){
        for ( int i=0; i < numObstaculos; i++){ 
            //g.fill(o.get(i).getObstaculo());
              /*Dibujar rocas espaciales*/
            Graphics2D g2 = (Graphics2D)g;
            g.drawImage(rocks.get(i).tenerImagen(),rocks.get(i).tenerX(),rocks.get(i).tenerY(), null);

        }         
    }
    
    public void actionPerformed(ActionEvent e){ 
        Rectangle rectangleAlien = alien.getBounds();
        Rectangle rectangleNave = nave.getBounds();
        ArrayList <Rectangle> alr = new ArrayList();        /*ArrayList de rectangulos*/
        for ( int i=0; i < NIVEL1; i++){ 
              alr.add(al.get(i).getBounds());                            /*Agregar rectangulos al ArrayList*/
        } 
        for ( int i=0; i < NIVEL1; i++){                                   /*Codigo para detectar coaliciones entre rocas y alien*/
            if(rectangleAlien.intersects(alr.get(i))){
                alien.obstaculoalMover();
            }
        }
        
        
        if(rectangleAlien.intersects(rectangleNave)){
            alien.noMover();        /*ocurre cuando intersectan, necesitabamos este codigo  y la funcion*/
            k= nave.noMover();
            repaint();
            
        }else{
            alien.Mover();
            nave.Mover();
            repaint();
        }
    }
    
    private class Teclado extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            alien.Keypressed(e);
            nave.Keypressed(e);
            
        }
        public void keyReleased(KeyEvent e){
            alien.KeyReleased(e);
            nave.KeyReleased(e);
            
        }
       
    }
}
