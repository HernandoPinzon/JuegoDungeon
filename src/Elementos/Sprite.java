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
    int x;
    int y;
    protected Color color;
    private int alto;
    private int ancho;
    protected Contenedor contenedor;
    public final static short COLLICION_NOT = 0;
    public final static short COLLICION_ARRIBA = 1;
    public final static short COLLICION_ABAJO = 2;
    public final static short COLLICION_IZQUIERDA = 3;
    public final static short COLLICION_DERECHA = 4;
    public final static short COLLICION_DEFAULT = 5;

    
    public Sprite(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    
    public abstract void dibujar(Graphics g);
    
    public short isCollicionWith(Sprite sprite) {
        int x2 = sprite.getX();
        int y2 = sprite.getY();
        int alto2 = sprite.getAlto();
        int ancho2 = sprite.getAncho();
        System.out.println(x2 + " " + y2 + " " + alto2 + " " + ancho2+"\n"+x + " " + y + " " + ancho + " " + alto);
        if ((x + ancho > x2 && (x < x2 + ancho2))&&(y + alto > y2 && (y < y2 + alto2))) {
            return COLLICION_DEFAULT;
        }
        /*else if (x2 == x + ancho) {
            System.out.println("2");
        } else if (y2 == y + alto) {
            System.out.println("2");
        }*/
        return 0;
    }

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

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }
    
    
}
