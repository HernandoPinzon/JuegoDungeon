/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Elementos.Contenedor;
import Elementos.GameController;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hernando
 */
public class VistaPrincipal extends javax.swing.JFrame 
    implements Contenedor
{

    GameController gameController;
    public VistaPrincipal() {
        initComponents();
    }

    
    @Override
    public void paint(Graphics g) {
        /*g.setColor(Color.green);
        g.fillRect(0, 0, this.getWidth(),this.getHeight());
        g.setColor(Color.blue);
        g.fillRect(40, 60, 60, 60);*/
        gameController.dibujarEscena(g);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        gameController.handleKeyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int tamPantallaX= 800;
        int tamPantallaY= 400;
        VistaPrincipal vista = new VistaPrincipal();
        vista.setSize(tamPantallaX,tamPantallaY);
        GameController gameController = new GameController(tamPantallaX,tamPantallaY);
        gameController.setContenedor(vista);
        gameController.prueba1Paredes();
        //gameController.prueba1EnemigoIndividual();
        vista.setGameController(gameController);
        vista.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void refrescar() {
        repaint();
    }
}
