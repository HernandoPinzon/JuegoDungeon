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
public class GameController implements Contenedor{
    Contenedor contenedor;
    ArrayList<Escena> escenas;
    private int escenaNum=0;
    int tamPantallaX;
    int tamPantallaY;

    public GameController(int tamPX, int tamPY) {
        this.setTamPantallaX(tamPX);
        this.setTamPantallaY(tamPY);
        escenas = new ArrayList<Escena>();
        Escena escena1 = new Escena(0,0,tamPantallaX,tamPantallaY,50,50);
        escena1.setContenedor(this);
        escenas.add(escena1);
    }
    
    public void prueba1Paredes(){
        int paredesAr[][]= new int[3][4];
        paredesAr[0][0]=100;
        paredesAr[0][1]=30;
        paredesAr[0][2]=280;
        paredesAr[0][3]=30;
        
        paredesAr[1][0]=400;
        paredesAr[1][1]=130;
        paredesAr[1][2]=280;
        paredesAr[1][3]=30;
        
        paredesAr[2][0]=700;
        paredesAr[2][1]=30;
        paredesAr[2][2]=280;
        paredesAr[2][3]=30;
        for(int i=0;i<3;i++){
            escenas.get(escenaNum).agregarPared(paredesAr[i][0], paredesAr[i][1], paredesAr[i][2], paredesAr[i][3]);
            
        }
        contenedor.refrescar();
    }
    
    public void prueba1Enemigos(){
        int[][] enemigosAr= new int[3][2];
        enemigosAr[0][0]=200;
        enemigosAr[0][1]=30;
        
        enemigosAr[1][0]=500;
        enemigosAr[1][1]=300;
        
        enemigosAr[2][0]=500;
        enemigosAr[2][1]=30;
        for(int i=0;i<3;i++){
            escenas.get(escenaNum).agregarEnemy(enemigosAr[i][0], enemigosAr[i][1]);
            
            
        }
        contenedor.refrescar();
    }
    
    public void prueba1EnemigoIndividual(){
        Ruta ruta= new Ruta(10);
        ruta.addMovimiento(100, 100);
        ruta.addMovimiento(-100, -100);
        escenas.get(escenaNum).agregarEnemy(300, 100,ruta,"prueba 1");
        Ruta ruta2= new Ruta(20);
        ruta2.addMovimiento(400, 0);
        ruta2.addMovimiento(0, 200);
        ruta2.addMovimiento(0, -200);
        ruta2.addMovimiento(-400, 0);
        escenas.get(escenaNum).agregarEnemy(150, 50,ruta2,"prueba 2");
        contenedor.refrescar();
    }
    
    public void handleKeyPressed(java.awt.event.KeyEvent evt){
        escenas.get(escenaNum).handleKeyPressed(evt);
    }
    

    public void setTamPantallaX(int tamPantallaX) {
        this.tamPantallaX = tamPantallaX;
    }

    public void setTamPantallaY(int tamPantallaY) {
        this.tamPantallaY = tamPantallaY;
    }
    
    public void dibujarEscena(Graphics g){
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
