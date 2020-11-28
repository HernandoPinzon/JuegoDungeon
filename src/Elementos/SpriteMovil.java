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
    private Ruta ruta;
    public SpriteMovil(int x, int y,Runnable target) {
        super(x, y, target);
    }
    
    public SpriteMovil(int x, int y, Ruta ruta, Runnable target) {
        super(x, y, target);
        this.setRuta(ruta);
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the ruta
     */
    public Ruta getRuta() {
        return ruta;
    }
    
}
