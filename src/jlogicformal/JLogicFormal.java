/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlogicformal;

import interfaz.Ventana;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
* Clase principal que inicia la aplicacion
 *
 * @author Carlos Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 */
public class JLogicFormal {

    /**
     * Metodo main que inicia la aplicacion
     */
    public static void main(String[] args) {
           SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Ventana().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(JLogicFormal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
}
