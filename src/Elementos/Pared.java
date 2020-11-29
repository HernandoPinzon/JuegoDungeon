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

    public Pared(int x, int y, int alto, int ancho, Contenedor contenedor) {
        super(x, y, contenedor,5);
        this.setColor(Color.blue);
        this.setAlto(alto);
        this.setAncho(ancho);
        setImagePath("images/paredIMG.jpg");
        cargarImagen();
        crearTextura();
    }
    
    @Override
    public void dibujar(Graphics g) {
        //g.setColor(color);
        //g.fillRect(getX(), getY(), getAncho(), getAlto());
        g.drawImage(image, x, y, null);
        
        
    }
    
}
