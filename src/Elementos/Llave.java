/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Graphics;

/**
 *
 * @author KAZUTO
 */
public class Llave extends ObjetoInteractivo{

    public Llave(int x, int y,int ancho, int alto, Contenedor contenedor) {
        super(x, y, 0);
        setAncho(ancho);
        setAlto(alto);
        setContenedor(contenedor);
        setImagePath("images/llave3.png");
        cargarImagen();
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.drawImage(img, x, y,getAncho(),getAlto(), null);
    }

    @Override
    public void interactuar() {
        System.out.println("soy una llaveeeeeeee");
    }
    
}
