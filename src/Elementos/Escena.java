/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author hernando
 */
public class Escena
        extends Sprite implements Runnable {

    ArrayList<Pared> paredes;
    ArrayList<Enemy> enemigos;
    Player player;
    Thread hiloEnemys;

    public Escena(int x, int y, int ancho, int alto, int playerX, int playerY) {
        super(x, y);
        player = new Player(playerX, playerY);
        paredes = new ArrayList();
        enemigos = new ArrayList();
        setAlto(alto);
        setAncho(ancho);
        setColor(Color.GREEN);
        player.setContenedor(this);

    }

    public void handleKeyPressed(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_LEFT
                || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moverse(evt, inCollicions());
        }
    }

    public int[] inCollicions() {
        ArrayList<int[]> collicions = new ArrayList<>();
        int[] resultado = {0, 0, 0, 0};

        //revisamos si coliciona con alguna pared
        for (Pared p : paredes) {
            collicions.add(player.isCollicionWith(p));
        }

        //hallar el vector de coliciones resultante
        for (int[] collicion : collicions) {
            for (int i = 0; i < 4; i++) {
                resultado[i] += collicion[i];
            }
        }

        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
        }
        System.out.println("");
        return resultado;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), getY(), getAncho(), getAlto());

        for (Pared p : paredes) {
            p.dibujar(g);
        }
        for (Enemy e : enemigos) {
            e.dibujar(g);
        }
        player.dibujar(g);
    }

    public void agregarPared(int x, int y, int alto, int ancho) {
        Pared paredNueva = new Pared(x, y, alto, ancho);
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
    }

    public void agregarPared(Pared paredNueva) {
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
    }

    public void agregarEnemy(int x, int y) {
        Enemy newEnemy = new Enemy(x, y);
        newEnemy.setContenedor(this);
        System.out.println("se agrego enemigo");
        enemigos.add(newEnemy);
    }

    public void agregarEnemy(int x, int y, Ruta ruta, String name) {
        Enemy newEnemy = new Enemy(x, y, ruta, name);
        newEnemy.setContenedor(this);
        System.out.println("se agrego enemigo");
        enemigos.add(newEnemy);
    }

    public void agregarEnemy(Enemy newEnemy) {
        newEnemy.setContenedor(this);
        enemigos.add(newEnemy);
    }

    @Override
    public void run() {

    }

}
