/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author gusta
 */
public class AnalizadorProposicional {

    private Nodo nodoArbolS;

    /**
     * Metodo que determina si una expresion es una fbf
     *
     * @param molecula es la expresion a analizar
     * @return true en caso de ser fbf o false en caso contrario
     */
    public boolean isFBF(String molecula) {
        if (!molecula.isEmpty() && molecula != null) {
            for (int i = 0; i < molecula.length(); i++) {
                if (molecula.charAt(i) != '(' && molecula.charAt(i) != ')' && molecula.charAt(i) != 'V' && molecula.charAt(i) != '^'
                        && molecula.charAt(i) != '→' && molecula.charAt(i) != '↔'
                        && molecula.charAt(i) != '¬' && !(Character.isLetter(molecula.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Nodo crearArbolSintactico(String molecula) throws Exception {
        nodoArbolS = new Nodo(molecula);
        return nodoArbolS;
    }
}
