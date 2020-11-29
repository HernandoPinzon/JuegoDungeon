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
public class Puerta extends ObjetoInteractivo{

    public Puerta(int x, int y,int ancho, int alto, Contenedor contenedor) {
        super(x, y, 1);
        setAncho(ancho);
        setAlto(alto);
        setContenedor(contenedor);
        setImagePath("images/doors.png");
        cargarImagen();
        crearImagenDesdeTileset(-15, 0, 65,63);
    }

    

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(image, x, y,getAncho(),getAlto(), null);
    }

    @Override
    public void interactuar() {
        System.out.println("soy una puerta");
    }
    
    
}
