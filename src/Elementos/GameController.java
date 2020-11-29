/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author hernando
 */
public class GameController implements Contenedor {

    Contenedor contenedor;
    ArrayList<Escena> escenas;
    private int escenaNum = 0;
    int tamPantallaX;
    int tamPantallaY;

    public GameController(int tamPX, int tamPY) {
        this.setTamPantallaX(tamPX);
        this.setTamPantallaY(tamPY);
        escenas = new ArrayList<Escena>();
    }
    
    public void cargarEscenaPrueba(){
        Escena escena1 = new Escena(0, 0, tamPantallaX, tamPantallaY, 30, 50);
        escena1.setContenedor(this);
        escenas.add(escena1);
        crearParedes1(escena1);
        generarEnemigosPrueba(escena1);
        escena1.iniciarHilosEnemys();
    }
    
    public void crearParedes1(Escena escena) {
        escena.agregarPared(0, 0, 400, 20);
        escena.agregarPared(20, 0, 40, 800);
        escena.agregarPared(780, 30, 320, 20);
        escena.agregarPared(20, 380, 20, 780);
        escena.agregarPared(70, 30, 300, 20);
        escena.agregarPared(90, 310, 20, 500);
        //escena.agregarPared(650, 70, 310, 20);
        escena.agregarPared(590, 120, 210, 20);
        escena.agregarPared(130, 70, 20, 520);
        contenedor.refrescar();
    }

    public void generarEnemigosPrueba(Escena escena) {
        Ruta ruta = new Ruta(10);
        ruta.addMovimiento(100, 100);
        ruta.addMovimiento(-100, -100);
        escena.agregarEnemy(300, 100, ruta, "prueba 1");
        Ruta ruta2 = new Ruta(20);
        ruta2.addMovimiento(400, 0);
        ruta2.addMovimiento(0, 200);
        ruta2.addMovimiento(0, -200);
        ruta2.addMovimiento(-400, 0);
        escena.agregarEnemy(150, 50, ruta2, "prueba 2");
        contenedor.refrescar();
    }

    public void handleKeyPressed(java.awt.event.KeyEvent evt) {
        escenas.get(escenaNum).handleKeyPressed(evt);
    }

    public void setTamPantallaX(int tamPantallaX) {
        this.tamPantallaX = tamPantallaX;
    }

    public void setTamPantallaY(int tamPantallaY) {
        this.tamPantallaY = tamPantallaY;
    }

    public void dibujarEscena(Graphics g) {
        escenas.get(escenaNum).dibujar(g);
    }

    @Override
    public void refrescar() {
        contenedor.refrescar();
    }

    public void setContenedor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

}
