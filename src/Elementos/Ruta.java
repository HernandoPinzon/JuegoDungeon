/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.ArrayList;

/**
 *
 * @author hernando
 */
public class Ruta {
    ArrayList<int[]> movimientos;
    int speed;

    public Ruta(int speed) {
        movimientos = new ArrayList<int[]>();
        this.speed = speed;
    }

    public Ruta(ArrayList<int[]> movimientos, int speed) {
        this.movimientos = movimientos;
        this.speed = speed;
    }
    
    
    
    public void addMovimiento(int x,int y){
        int nuevoMovimiento[] = {x,y};
        movimientos.add(nuevoMovimiento);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    

    public ArrayList<int[]> getMovimientos() {
        return movimientos;
    }
    
    public double[] hallarVelocidadesRelativas(int dx,int dy,int speed){
        
        int distanciaX=dx;
        int distanciaY=dy;
        
        double hipotenusa=Math.sqrt((distanciaX*distanciaX)+(distanciaY*distanciaY));
        
        double pasosTotales= hipotenusa/speed;
        if (pasosTotales==hipotenusa){
            double[] array = {0,0,pasosTotales};
            
            return array;
        } else {
            double velPasosX= distanciaX/pasosTotales;
            double velPasosY= distanciaY/pasosTotales;
            
            double[] array = {velPasosX,velPasosY,pasosTotales};
            return array;
        }
    }
    
}
