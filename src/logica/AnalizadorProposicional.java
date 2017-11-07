
package logica;

/**
 * La clase Analizador proposicional que permite crear el arbol
 *
 * @author Carlos Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
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

    /**
     * Metodo que crea el arbol
     * @param molecula de la formula
     * @return el nodo con la molecula
     * @throws Exception 
     */
    public Nodo crearArbolSintactico(String molecula) throws Exception {
        nodoArbolS = new Nodo(molecula);
        return nodoArbolS;
    }
}
