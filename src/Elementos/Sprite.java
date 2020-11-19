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
public abstract class Sprite 
    implements Contenedor
{
    protected int x;
    protected int y;
    protected Color color;
    protected int alto;
    protected int ancho;
    protected Contenedor contenedor;

    
    public Sprite(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    public abstract void dibujar(Graphics g);

    @Override
    public void refrescar() {
        contenedor.refrescar();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }
    
    
}
