/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hernando
 */
public class Enemy extends SpriteMovil {
    public Enemy(int x, int y, Runnable target) {
        super(x, y, target);
        setAncho(50);
        setAlto(50);
        setColor(Color.red);
    }

    public Enemy(int x, int y, Ruta ruta, String name, Runnable target) {
        super(x, y, ruta, target);
        setAncho(40);
        setAlto(40);
        setColor(Color.red);
        this.setName(name);
        setImagePath("images/enemy3.png");
        cargarImagen();
    }

    @Override
    public void dibujar(Graphics g) {
        //g.setColor(color);
        //g.fillRect(getX(), getY(), getAncho(), getAlto());
        g.drawImage(img, x-10, y-13, getAlto()+20, getAncho()+20, null);
    }

    @Override
    public void run() {
        ArrayList<int[]> arRuta = getRuta().getMovimientos();
        int speed = getRuta().speed;
        boolean canMove= true;
        while (canMove) {
            int a = 0;
            for (int[] r : arRuta) {
                int dx = getX();
                int dy = getY();

                double[] velocidades = getRuta().hallarVelocidadesRelativas(r[0], r[1], speed);
                a++;
                while (velocidades[2] > 1) {
                    x += Math.round(velocidades[0]);
                    y += Math.round(velocidades[1]);

                    velocidades[2] -= 1;

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        canMove = false;
                    }
                    this.contenedor.refrescar();
                }
                x = dx + r[0];
                y = dy + r[1];

            }

        }
    }
    
    public boolean isCollicionWithPlayer(){
        
        
        return false;
    }

}
