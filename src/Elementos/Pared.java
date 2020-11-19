/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hernando
 */
public class Pared extends Sprite{

    public Pared(int x, int y, int alto, int ancho) {
        super(x, y);
        this.setColor(Color.black);
        this.setAlto(alto);
        this.setAncho(ancho);
        
    }

    

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,ancho,alto);
        
    }
    
}
