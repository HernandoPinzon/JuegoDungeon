/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author KAZUTO
 */
public abstract class ObjetoInteractivo extends  Sprite{

    public ObjetoInteractivo(int x, int y, int escala) {
        super(x, y, escala);
    }
    
    abstract public void interactuar();
}
