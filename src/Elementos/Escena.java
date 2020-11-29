/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hernando
 */
public class Escena
        extends Sprite{

    ArrayList<Pared> paredes;
    ArrayList<Enemy> enemigos;
    Player player;
    boolean isLose;
    Font fontYouLose;
    

    public Escena(int x, int y, int ancho, int alto, int playerX, int playerY) {
        super(x, y,10);
        player = new Player(playerX, playerY, this);
        paredes = new ArrayList();
        enemigos = new ArrayList();
        isLose = false;
        setAlto(alto);
        setAncho(ancho);
        setColor(Color.GRAY);
        player.setContenedor(this);
        setImagePath("images/piedra.jpg");
        cargarImagen();
        crearTextura();
        fontYouLose = new Font("Serif", Font.BOLD, 36);
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.drawImage(image, x, y, null);
        if(isCollicionBool(inCollicionsEnemys(enemigos), true)|| isLose==true){
            g.setFont(fontYouLose);
            g.setColor(Color.RED);
            g.drawString("YOU LOSE", getAncho()/2, getAlto()/2);
            isLose= true;
        }
        
        if(isLose){
            pararHilosEnemys();
        }
        
        for (Enemy e : enemigos) {
            e.dibujar(g);
        }
        player.dibujar(g);
    }
    
    public void dibujarFondo(){
        Graphics2D g2d = image.createGraphics();
        for (Pared p : paredes) {
            g2d.drawImage(p.image, p.x, p.y, null);
        }
        g2d.dispose();
    }
    
    public void iniciarHilosEnemys(){
        for (Enemy e : enemigos) {
            e.start();
            System.out.println(e.getName());
        }
    }
    
    public void pararHilosEnemys(){
        for (Enemy e : enemigos) {
            e.interrupt();
        }
    }

    public void handleKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_LEFT
                || evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(!isLose) player.moverse(evt, inCollicionsPared(paredes));
        }
    }
    public int[] inCollicionsPared(ArrayList<Pared> paredes){
        ArrayList<Sprite> sprites=new ArrayList<Sprite>();
        for (Pared pared : paredes) {
            sprites.add((Sprite)pared);
        }
        return inCollicions(sprites);
    }
    public int[] inCollicionsEnemys(ArrayList<Enemy> enemigos){
        ArrayList<Sprite> sprites=new ArrayList<Sprite>();
        for (Enemy enemy : enemigos) {
            sprites.add((Sprite)enemy);
        }
        return inCollicions(sprites);
    }
    public int[] inCollicions(ArrayList<Sprite> sprites) {
        ArrayList<int[]> collicions = new ArrayList<>();
        int[] resultado = {0, 0, 0, 0};

        //revisamos si coliciona con alguna pared
        for (Sprite p : sprites) {
            collicions.add(player.isCollicionWith(p));
        }

        //hallar el vector de coliciones resultante
        for (int[] collicion : collicions) {
            for (int i = 0; i < 4; i++) {
                resultado[i] += collicion[i];
            }
        }
        return resultado;
    }

    public void agregarPared(int x, int y, int alto, int ancho) {
        Pared paredNueva = new Pared(x, y, alto, ancho, this);
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
        dibujarFondo();
    }

    public void agregarPared(Pared paredNueva) {
        paredNueva.setContenedor(this);
        paredes.add(paredNueva);
    }

    public void agregarEnemy(int x, int y) {
        Enemy newEnemy = new Enemy(x, y, this);
        newEnemy.setContenedor(this);
        enemigos.add(newEnemy);
    }

    public void agregarEnemy(int x, int y, Ruta ruta, String name) {
        Enemy newEnemy = new Enemy(x, y, ruta, name, this);
        newEnemy.setContenedor(this);
        enemigos.add(newEnemy);
    }

    public void agregarEnemy(Enemy newEnemy) {
        newEnemy.setContenedor(this);
        enemigos.add(newEnemy);
    }

}
