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
        this.setColor(Color.blue);
        this.setAlto(50);
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
    }
    
    public void moverse(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode()== KeyEvent.VK_UP){
            y-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_DOWN){
            y+=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_LEFT){
            x-=velocidad;
            
        } else if (evt.getKeyCode()== KeyEvent.VK_RIGHT){
            x+=velocidad;
            
        }
        
        if(getX()>800) System.exit(0);
        this.contenedor.refrescar();
    }
    
    
    
}
