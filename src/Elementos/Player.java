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
        //colorear la sombra
        //g.setColor(color);
        //g.fillRect(getX(), getY(), getAncho(), getAlto());
        
        //colorear el player de prueba
        g.setColor(Color.PINK);
        g.fillRect(getX()-5, getY()-10, 40, 5);
        g.fillRect(getX()+10, getY()-10, 4, 30);
        g.fillRect(getX()+17, getY()-10, 4, 30);
        g.fillRect(getX()+10, getY()-22, 10, 10);
        g.setColor(Color.GRAY);
        g.fillRect(getX()+10, getY()-10, getAncho()-20, getAlto()-10);
        
    }
    
    public void moverse(java.awt.event.KeyEvent evt,int[] collicion){
        
        if (evt.getKeyCode()== KeyEvent.VK_UP&&(collicion[0]==Sprite.COLLICION_NOT)){
            y-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_DOWN&&(collicion[1]==Sprite.COLLICION_NOT)){
            y+=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_LEFT&&(collicion[2]==Sprite.COLLICION_NOT)){
            x-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_RIGHT&&(collicion[3]==Sprite.COLLICION_NOT)){
            x+=velocidad;
        }
        
        
        
        if(getX()>800) System.exit(0);
        this.contenedor.refrescar();
    }
    
    
    
}
