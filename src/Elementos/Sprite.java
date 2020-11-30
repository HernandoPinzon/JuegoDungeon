/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hernando
 */
public abstract class Sprite
        extends Thread
        implements Contenedor {

    int x;
    int y;
    protected Color color;
    private int alto;
    private int ancho;
    protected Contenedor contenedor;
    public final static short COLLICION_NOT = 0;
    public final static short COLLICION_YES = 1;
    Image img;
    private String imagePath;
    BufferedImage image;
    int escalaTextura;

    public Sprite(int x, int y, int escalaTextura) {
        this.setX(x);
        this.setY(y);
        this.escalaTextura = escalaTextura;
    }

    public Sprite(int x, int y, Contenedor contenedor, Runnable target) {
        super(target);
        this.x = x;
        this.y = y;
        this.contenedor = contenedor;
    }

    public Sprite(int x, int y, Runnable target) {
        super(target);
        this.x = x;
        this.y = y;
    }

    public Sprite(int x, int y, Contenedor contenedor) {
        this.x = x;
        this.y = y;
        this.contenedor = contenedor;
    }

    public Sprite(int x, int y, Contenedor contenedor, int escalaTextura) {
        this.x = x;
        this.y = y;
        this.contenedor = contenedor;
        this.escalaTextura = escalaTextura;
    }

    public void crearTextura() {
        image = new BufferedImage(getAncho(), getAlto(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        int widthIMG = img.getWidth(null);
        int heightIMG = img.getHeight(null);
        for (int i = 0; i < getAncho(); i += widthIMG / escalaTextura) {
            for (int j = 0; j < getAlto(); j += heightIMG / escalaTextura) {
                g2d.drawImage(img, i, j, widthIMG / escalaTextura, heightIMG / escalaTextura, null);
            }
        }
        g2d.dispose();
    }

    public void cargarImagen() {
        File file = new File(getImagePath());
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearImagenDesdeTileset(int posX, int posY, int posAncho, int posAlto) {
        image = new BufferedImage(posAncho, posAlto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(img, posX, posY, null);
        g2d.dispose();
    }

    public abstract void dibujar(Graphics g);

    public boolean isCollicionBool(int[] collicion, boolean bool) {
        if (bool) {
            if (collicion[0] != 0 || collicion[1] != 0 || collicion[2] != 0 || collicion[3] != 0) {
                System.out.println("in coliccion");
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

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

}
