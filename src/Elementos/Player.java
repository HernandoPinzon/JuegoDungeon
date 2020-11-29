/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hernando
 */
public class Player extends Sprite{
    
    int velocidad=10;
    public Player(int x, int y,Contenedor contenedor) {
        super(x, y, contenedor);
        this.setColor(Color.GRAY);
        this.setAlto(30);
        this.setAncho(30);
        setImagePath("images/deku.png");
        cargarImagen();
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
        g.drawImage(img, x+5, y-20,17,40, null);
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
        
        this.contenedor.refrescar();
    }
    
    
    
}
