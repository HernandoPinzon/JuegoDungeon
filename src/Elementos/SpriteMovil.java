/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;

/**
 *
 * @author hernando
 */
public abstract class SpriteMovil 
    extends Sprite
    implements Runnable

{
    protected Ruta ruta;
    protected Thread hilo;
    public SpriteMovil(int x, int y) {
        super(x, y);
    }
    
    public SpriteMovil(int x, int y, Ruta ruta) {
        super(x, y);
        this.setRuta(ruta);
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
    
    
}
