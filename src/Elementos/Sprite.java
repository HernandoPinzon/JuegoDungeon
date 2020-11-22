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
        implements Contenedor {

    int x;
    int y;
    protected Color color;
    private int alto;
    private int ancho;
    protected Contenedor contenedor;
    public final static short COLLICION_NOT = 0;
    public final static short COLLICION_YES = 1;

    public Sprite(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public abstract void dibujar(Graphics g);

    public boolean isCollicionBool(int[] collicion, boolean bool) {
        if (bool) {
            if (collicion[0] != 0 || collicion[1] != 0 || collicion[2] != 0 || collicion[3] != 0) {
                return true;
            }
        }
        return false;
    }

    public int[] isCollicionWith(Sprite sprite) {
        int x2 = sprite.getX();
        int y2 = sprite.getY();
        int alto2 = sprite.getAlto();
        int ancho2 = sprite.getAncho();
        int[] collicion = {0, 0, 0, 0};
        if ((x + ancho > x2 && (x < x2 + ancho2)) && (y + alto > y2 && (y < y2 + alto2))) {

            if ((y < y2 + alto2 && (y > y2 + (alto2 - alto / 2))) && !(y + alto > y2 && (y + alto < y2 + ancho / 2))) {
                collicion[0] = 1;
            }
            if ((y + alto > y2 && (y + alto < y2 + ancho / 2)) && !(y < y2 + alto2 && (y > y2 + (alto2 - alto / 2)))) {
                collicion[1] = 1;
            }
            if ((x < x2 + ancho2 && (x > x2 + (ancho2 - ancho / 2))) && !(x + ancho > x2 && (x + ancho < x2 + ancho / 2))) {
                collicion[2] = 1;
            }
            if ((x + ancho > x2 && (x + ancho < x2 + ancho / 2)) && !(x < x2 + ancho2 && (x > x2 + (ancho2 - ancho / 2)))) {
                collicion[3] = 1;
            }
            System.out.println("");
            for (int i = 0; i < 2; i++) {
                if ((collicion[i] == COLLICION_YES) && collicion[2] == COLLICION_YES && collicion[3] == COLLICION_NOT) {
                    collicion[i] = COLLICION_NOT;
                    collicion[2] = COLLICION_NOT;
                }
                if ((collicion[i] == COLLICION_YES) && collicion[3] == COLLICION_YES && collicion[2] == COLLICION_NOT) {
                    collicion[i] = COLLICION_NOT;
                    collicion[3] = COLLICION_NOT;
                }
            }
        }
        return collicion;
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
