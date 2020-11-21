/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author hernando
 */
public class Player extends Sprite{

    int velocidad=10;
    public Player(int x, int y) {
        super(x, y);
        this.setColor(Color.GRAY);
        this.setAlto(30);
        this.setAncho(30);
        
    }

    /**
     *
     * @param g
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), getY(), getAncho(), getAlto());
        g.setColor(Color.PINK);
        g.fillRect(getX()+10, getY()-10, getAncho()-20, getAlto()-10);
        g.fillRect(getX()-5, getY()-10, 40, 5);
        g.fillRect(getX()+10, getY()-10, 4, 30);
        g.fillRect(getX()+17, getY()-10, 4, 30);
        g.fillRect(getX()+10, getY()-22, 10, 10);
        
    }
    
    public void moverse(java.awt.event.KeyEvent evt,int[] coliccion){
        
        if (evt.getKeyCode()== KeyEvent.VK_UP&&(coliccion[0]!=Sprite.COLLICION_YES)){
            y-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_DOWN&&(coliccion[1]!=Sprite.COLLICION_YES)){
            y+=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_LEFT&&(coliccion[2]!=Sprite.COLLICION_YES)){
            x-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_RIGHT&&(coliccion[3]!=Sprite.COLLICION_YES)){
            x+=velocidad;
        }
        
        
        
        if(getX()>800) System.exit(0);
        this.contenedor.refrescar();
    }
    
    
    
}
