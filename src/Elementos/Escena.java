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
public class Escena extends Sprite{
    ArrayList<Pared> paredes;
    ArrayList<Enemy> enemigos;
    Player player;
    short inCollicion= 0;

    public Escena(int x, int y,int ancho, int alto,int playerX, int playerY) {
        super(x, y);
        player =new Player(playerX,playerY);
        paredes = new ArrayList();
        enemigos = new ArrayList();
        setAlto(alto);
        setAncho(ancho);
        setColor(Color.GREEN);
        player.setContenedor(this);
    }

    public void handleKeyPressed(java.awt.event.KeyEvent evt) {
        short collicionType = 0;
        
        if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_LEFT
                || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moverse(evt);
        }
        collicionType=player.isCollicionWith(paredes.get(0));
        if (collicionType != 0) {
            System.out.println("aaaa");
        }
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillRect(getX(), getY(), getAncho(), getAlto());
        player.dibujar(g);
        for (Pared p : paredes) {
            p.dibujar(g);
        }
        for (Enemy e : enemigos) {
            e.dibujar(g);
        }
    }
    
    public void agregarPared(int x, int y, int alto, int ancho){
        Pared paredNueva = new Pared(x,y,alto,ancho);
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
    }
    
    public void agregarPared(Pared paredNueva){
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
    }

    public void agregarEnemy(int x, int y){
        Enemy newEnemy = new Enemy(x,y);
        newEnemy.setContenedor(this);
        System.out.println("se agrego enemigo");
        enemigos.add(newEnemy);
    }
    
    public void agregarEnemy(int x, int y,Ruta ruta, String name){
        Enemy newEnemy = new Enemy(x,y,ruta,name);
        newEnemy.setContenedor(this);
        System.out.println("se agrego enemigo");
        enemigos.add(newEnemy);
    }
    
    public void agregarEnemy(Enemy newEnemy){
        newEnemy.setContenedor(this);
        enemigos.add(newEnemy);
    }
    
    
}
