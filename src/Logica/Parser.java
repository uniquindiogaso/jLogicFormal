/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Parser {

    /**
     * Variable que contiene el numero de atomos a ser considerados para la
     * construccion de la tabla
     */
    static int numeroAtomicas;

    /**
     * Variable auxiliar que sera usada para guardar la expresion a medida que
     * la recursividad avanza, analizando la expresion ingresada
     */
    static String aux;

    /**
     * Arraylist de tipo String que contendra todas las subexpresiones que se
     * puedan formar a partir de la expresion original
     */
    private static ArrayList<String> subFormulas = new ArrayList<String>();

    /**
     * Arreglo que contiene las letras propociocionales de las formulas
     */
    static ArrayList<Character> atomos = new ArrayList<>();

    /**
     * Matriz de tipo Object que ayuda en la construccion de la tabla de la
     * verdad de la expresion ingresada
     */
    private static Object[][] tabla;

    /**
     * Arraylist de tipo String que contendra todas las formulas que se puedan
     * formar a partir de la expresion original
     */
    private static ArrayList<String> formulas = new ArrayList<String>();

    public static void hallarFormulas(String cadena) {
        formulas.clear();
        atomos.clear();
        subFormulas.clear();
        String aux = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ',') {
                formulas.add(aux);
                aux = "";

            } else if (i == cadena.length() - 1) {
                aux += cadena.charAt(i);
                formulas.add(aux);
            } else {
                aux += cadena.charAt(i);
            }
        }
    }

    /**
     * Metodo recursivo que, de entrada determina si la expreion ingresada por
     * el usuario es correcta para ser analizada, es decir, este metodo
     * identifica si la expresio½n es una formula bien formada
     *
     * @param formula , es la expresion que se recibe por medio de la interfaz
     * grafica
     * @return true , en caso de ser una formula bien formada y false en caso
     * contrario
     */
    public static boolean esCorrectaLaFormula(String formula) {
        aux = formula;

        /**
         * Variable que contiene el tamaÃ±o total de la expresiÃ³n ingresada
         */
        int tamanoFormula = formula.length();
        subFormulas.add(aux);

        if (aux.length() == 2 || aux.length() == 0) {
            return false;
        }

        if (aux.length() == 1 && (aux.charAt(0) == 'p' || aux.charAt(0) == 'r' || aux.charAt(0) == 'q'
                || aux.charAt(0) == 's' || aux.charAt(0) == 't' || aux.charAt(0) == 'u' || aux.charAt(0) == 'w'
                || aux.charAt(0) == 'v' || aux.charAt(0) == 'x' || aux.charAt(0) == 'y' || aux.charAt(0) == 'z')) {

            return true;

        } else if ((aux.charAt(0) != '¬') && (aux.charAt(0) != '(')) {

            return false;

        }
        if (aux.charAt(0) == '¬') { // Cuando comienza por negado ¬
            aux = aux.substring(2, tamanoFormula - 1);
            return esCorrectaLaFormula(aux);

        } else if (aux.charAt(0) == '(') {// Cuando comienza por (

            /**
             * Variable que me guarda la posiciOn del operador principal de la
             * expresi0n, que es determinado por el MEtodo buscarPosicionOpePPal
             */
            int posicion = buscarPosicionOpePpal(aux);

            if (posicion + 3 > aux.length()) {
                return false;
            }
            if ((aux.charAt(posicion) != '\u2192') && (aux.charAt(posicion) != '^') && (aux.charAt(posicion) != 'V')
                    && (aux.charAt(posicion) != '\u2194')) {
                System.out.println(
                        "El operador ''" + aux.charAt(posicion) + "'' es invalido (Debe ser un operador binario)");
                return false;
            }

            /**
             * Variable auxiliar que guarda la expresion que se encuentra en la
             * variable aux
             */
            String aux3 = aux;
            aux = aux.substring(1, posicion - 1);
            aux3 = aux3.substring(posicion + 2, tamanoFormula - 1);
            return esCorrectaLaFormula(aux) & esCorrectaLaFormula(aux3);
        }

        return true;

    }

    /**
     * Metodo que permite encontrar el operador principal
     *
     * @param aux
     * @return
     */
    public static char buscarOpPrincipal(String aux) {
        int pos = buscarPosicionOpePpal(aux);
        if (pos == 0) {
            return aux.charAt(0);
        }
        if (aux.charAt(pos) == '(') {
            return aux.charAt(pos - 1);
        } else {
            return aux.charAt(pos);
        }
    }

    /**
     * Metodo que se basa en el algoritmo de descomposicion y que se encarga de
     * buscar la posicion del operador principal de la expresion que le llega
     * por parametro
     *
     * @param aux, contiene la expresion
     * @return posicion donde se encuentra el operador principal.
     */
    public static int buscarPosicionOpePpal(String aux) {

        /**
         * Cuenta , sumando o restando dependiendo si se encuentra con un
         * parentesis izquierdo o derecho
         */
        int con = 0;

        /**
         * Guarda la posicion en la que se encuentra el operador principal
         */
        int posicion = 0;

        if (aux.charAt(0) == '¬') {
            return 0;
        }
        for (int i = 0; i < aux.length(); i++) {

            if (aux.charAt(i) == '(') {
                con = con + 1;
            }
            if (aux.charAt(i) == ')') {
                con = con - 1;
            }
            posicion = i + 1;
            if (con == 0) {
                break;
            }
        }

        return posicion;
    }

    /**
     *
     * @param cadena
     * @param nuevo
     * @return
     */
    public static String ingresar(String cadena, String nuevo) {
        String actual = "";
        if (cadena.length() == 0) {
            cadena = nuevo;
        } else {
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == '(' && cadena.charAt(i + 1) == ')') {
                    String aux = cadena.substring(0, i + 1);
                    String aux1 = cadena.substring(i + 1, cadena.length());
                    actual = aux + nuevo + aux1;
                    return actual;
                }
            }
            if (nuevo.charAt(0) == ',') {
                if (cadena.charAt(cadena.length() - 1) == ',') {
                    return cadena;
                } else {
                    actual = cadena + nuevo;
                }
            } else if (cadena.charAt(cadena.length() - 1) == ',') {
                actual = cadena + nuevo;
            }

        }
        if (actual == "") {
            return cadena;
        }

        return actual;
    }

    /**
     *
     * @param aux
     * @return
     */
    public static boolean bienFormada(ArrayList<String> aux) {
        boolean v = false;
        for (int i = 0; i < aux.size(); i++) {
            v = esCorrectaLaFormula(aux.get(i));
        }
        return v;
    }

    public static void literales(ArrayList<String> formulas) {
        for (int i = 0; i < formulas.size(); i++) {
            String cadena = formulas.get(i);
            for (int l = 0; l < cadena.length(); l++) {
                if (cadena.charAt(l) == 'V') {
                    continue;
                }
                if (Character.isLetter(cadena.charAt(l))) {
                    boolean exsite = false;
                    for (int j = 0; j < atomos.size(); j++) {
                        if (cadena.charAt(l) == atomos.get(j)) {
                            exsite = true;
                        }
                    }
                    if (!exsite) {
                        atomos.add(cadena.charAt(l));
                    }
                }
            }
        }
        numeroAtomicas = atomos.size();

    }

    /**
     * Metodo que se encarga de permitir ver la satisfacibilidad de una formula
     *
     * @param ingresa como parametro la tabla de verdad
     * @return
     */
    public static boolean verSatisfacibilidad(Object[][] tabla) {

        Object aux = 1;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][tabla[0].length - 1] == aux) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que elimina las proposiciones compuestas y atomos que pueden estar
     * repetidos en una expresion, con la finalidad de no repetirlas en la tabla
     * que se mostrara al usuario
     *
     * @param j,variable de tipo int que va desde 0 hasta el tamano de la
     * subexpresionn
     */
    public static void eliminarFormulasRepetidas(int j) {

        for (int i = 0; i < subFormulas.size(); i++) {

            if (j != i && subFormulas.get(j).equalsIgnoreCase(subFormulas.get(i))) {

                subFormulas.remove(i);
                encontrarFormulasRepetidas();
                break;

            }
        }
    }

    /**
     * Metodo que encuentra el numero de atomos que contiene la expresion
     * ingresada por el usuario
     */
    public static void encontrarFormulasRepetidas() {

        numeroAtomicas = 0;

        for (int j = 0; j < subFormulas.size(); j++) { // Para eliminar los
            // atomos repetidos

            eliminarFormulasRepetidas(j);

        }

    }

    /**
     * Metodo que se encarga de construir la tabla de acuerdo con los atomos,
     * subexpresiones y a la expresion inicial
     */
    public static void construirTabla() {
        encontrarFormulasRepetidas();
        literales(formulas);

        subFormulas = OrdenarArray(subFormulas);

        /**
         * Variable que contiene el numero de campos para las filas de acuerdo
         * con la tabla generada a partir de la expresion ingresada por el
         * usuario
         */
        int numeroFilas = (int) Math.pow(2, numeroAtomicas);

        tabla = new Object[numeroFilas + 1][subFormulas.size()];
        /**
         * Variable que contiene el numero a ser considerado para construir las
         * valuaciones de los atomos y de las expresiones derivadas de la
         * expresion inicial
         */
        int con = 0;

        for (int i = 0; i < tabla[0].length; i++) {
            con = numeroFilas / 2;
            for (int j = 0; j < tabla.length; j++) {
                if (j == 0) {
                    tabla[j][i] = subFormulas.get(i);
                } else {
                    if (numeroAtomicas % 2 == 0) {
                        if ((con + numeroFilas) <= 2) {
                            con = numeroFilas / 2;
                        }
                        if (con > 0) {
                            tabla[j][i] = 0;
                        } else {
                            tabla[j][i] = 1;
                        }

                        con = con - 1;

                    } else {
                        if ((con + numeroFilas) < numeroFilas / 2 + 1) {
                            con = numeroFilas / 2;
                        }
                        if (con > 0) {
                            tabla[j][i] = 0;
                        } else {
                            tabla[j][i] = 1;
                        }

                        con = con - 1;
                    }
                }

            }
            numeroFilas = numeroFilas / 2;
            numeroAtomicas = numeroAtomicas - 1;
        }

        operaciones(tabla);
    }

    /**
     * Metodo que ayuda en la construccion de la tabla, al analizar todas las
     * posibilidades de las proposiciones en forma de 1 y 0
     *
     * @param tabla , tabla de tipo object
     */
    private static void operaciones(Object[][] tabla) {

        for (int i = 1; i < tabla.length; i++) { // columna

            for (int j = 0; j < subFormulas.size(); j++) {
                if (subFormulas.get(j).length() == 1) {

                } else {

                    if (subFormulas.get(j).charAt(0) == '¬') {
                        String auxiliar = subFormulas.get(j).substring(2, subFormulas.get(j).length() - 1);
                        for (int k = 0; k < tabla[0].length; k++) {
                            if (tabla[0][k].toString().equals(auxiliar)) {

                                if (tabla[i][k].equals(0)) {
                                    tabla[i][j] = 1;
                                } else {
                                    tabla[i][j] = 0;

                                }
                            }
                        }

                    } else {
                        int posicion = buscarPosicionOpePpal(subFormulas.get(j));

                        String aux4 = subFormulas.get(j);

                        aux4 = aux4.substring(1, posicion - 1);

                        String aux3 = subFormulas.get(j);
                        aux3 = aux3.substring(posicion + 2, subFormulas.get(j).length() - 1);
                        char auxiliarOpe = subFormulas.get(j).charAt(posicion);

                        if (auxiliarOpe == '\u2192') {
                            operarCondicional(tabla, i, j, aux4, aux3);
                        } else if (auxiliarOpe == '^') {
                            operarConjuncion(tabla, i, j, aux4, aux3);
                        } else if (auxiliarOpe == 'V') {
                            operarDisyuncion(tabla, i, j, aux4, aux3);
                        } else if (auxiliarOpe == '\u2194') {
                            operarBicondicional(tabla, i, j, aux4, aux3);
                        }
                    }

                }
            }

        }
    }

    /**
     * Metodo que ordena el arraylist de acuerdo al tamano de la proposicion y
     * atomo, de forma que en la parte inicial del ArrayList van a quedar los
     * atomos y a medida que avanzan las posiciones del arrayList quedan las
     * expresiones que se van haciendo mas grandes
     *
     * @param lista, ArrayList que contiene los atomos y expresiones
     * @return ArrayList con los elementos ordenados de acuerdo al tamano desde
     * el mas pequeÃ±o al mas grande
     */
    public static ArrayList<String> OrdenarArray(ArrayList<String> lista) {

        /**
         * Variables que ayudan en el metodo de ordenamiento del ArrayList
         */
        int p, j;

        /**
         * Variable que guarda temporalmente el elemento que se quiere mover de
         * posicion dentro del ArrayList
         */
        String aux;
        for (p = 1; p < lista.size(); p++) { // Desde el segundo elemento hasta
            aux = lista.get(p); // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux.length() < lista.get(j).length())) { // Mientras
                // queden
                // posiciones
                // y
                // el
                // valor de aux sea menor que los
                lista.remove(j + 1);
                lista.add(j + 1, lista.get(j));
                ; // de la izquierda, se desplaza a
                j--; // la derecha
            }
            lista.remove(j + 1);
            lista.add(j + 1, aux); // Colocamos aux en su sitio
        }
        return lista;

    }

    /**
     * Metodo que determina en el caso que el operador sea un si y solo si , la
     * tabla de la verdad
     *
     * @param tabla , tabla de tipo object que contendra el valor de las
     * proposiciones y sus respectivos atomos y subexpresiones
     * @param i ,Posiciones de la columna de la tabla
     * @param j ,Posiciones de subexpresiones
     * @param aux4 ,Variable que guarda la subexpresion que se va a operar
     * @param aux3 ,Variable que guarda la subexpresionn que se va a operar
     */
    private static void operarBicondicional(Object[][] tabla, int i, int j, String aux4, String aux3) {
        for (int k = 0; k < tabla[0].length; k++) {
            if (tabla[0][k].toString().equals(aux3)) {
                for (int k2 = 0; k2 < tabla[0].length; k2++) {
                    if (tabla[0][k2].toString().equals(aux4)) {
                        if (tabla[i][k2].toString().equalsIgnoreCase(tabla[i][k].toString())) {
                            tabla[i][j] = 1;
                        } else {
                            tabla[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo que determina la tabla de la verdad en el caso que el operador
     * indique una disyuncion
     *
     * @param tabla,tabla de tipo object que contendrÃ¡ el valor de las
     * proposiciones y sus respectivos atomos y subexpresiones
     * @param i,Posiciones de la columna de la tabla
     * @param j,Posiciones de subexpresiones
     * @param aux4,Variable que guarda la subexpresiÃ³n que se va a operar
     * @param aux3,Variable que guarda la subexpresiÃ³n que se va a operar
     */
    private static void operarDisyuncion(Object[][] tabla, int i, int j, String aux4, String aux3) {
        for (int k = 0; k < tabla[0].length; k++) {
            if (tabla[0][k].toString().equals(aux3)) {
                for (int k2 = 0; k2 < tabla[0].length; k2++) {
                    if (tabla[0][k2].toString().equals(aux4)) {
                        if (tabla[i][k2].toString().equalsIgnoreCase("0")
                                && tabla[i][k].toString().equalsIgnoreCase("0")) {
                            tabla[i][j] = 0;
                        } else {
                            tabla[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo que determina la tabla de la verdad en el caso que el operador
     * indique una conjuncion
     *
     * @param tabla,tabla de tipo object que contendra el valor de las
     * proposiciones y sus respectivos atomos y subexpresiones
     * @param i,Posiciones de la columna de la tabla
     * @param j,Posiciones de subexpresiones
     * @param aux4,Variable que guarda la subexpresion que se va a operar
     * @param aux3,Variable que guarda la subexpresionn que se va a operar
     */
    private static void operarConjuncion(Object[][] tabla, int i, int j, String aux4, String aux3) {
        for (int k = 0; k < tabla[0].length; k++) {
            if (tabla[0][k].toString().equals(aux3)) {
                for (int k2 = 0; k2 < tabla[0].length; k2++) {
                    if (tabla[0][k2].toString().equals(aux4)) {
                        if (tabla[i][k2].toString().equalsIgnoreCase("1")
                                && tabla[i][k].toString().equalsIgnoreCase("1")) {
                            tabla[i][j] = 1;
                        } else {
                            tabla[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo que determina la tabla de la verdad en el caso que el operador sea
     * un condicional o en otras palabras , un entonces
     *
     * @param tabla,tabla de tipo object que contendra el valor de las
     * proposiciones y sus respectivos atomos y subexpresiones
     * @param i,Posiciones de la columna de la tabla
     * @param j,Posiciones de subexpresiones
     * @param aux4,Variable que guarda la subexpresion que se va a operar
     * @param aux3,Variable que guarda la subexpresion que se va a operar
     */
    private static void operarCondicional(Object[][] tabla, int i, int j, String aux4, String aux3) {
        for (int k = 0; k < tabla[0].length; k++) {
            if (tabla[0][k].toString().equals(aux3)) {
                for (int k2 = 0; k2 < tabla[0].length; k2++) {
                    if (tabla[0][k2].toString().equals(aux4)) {
                        if (tabla[i][k2].toString().equalsIgnoreCase("1")
                                && tabla[i][k].toString().equalsIgnoreCase("0")) {
                            tabla[i][j] = 0;
                        } else {
                            tabla[i][j] = 1;
                        }
                    }
                }
            }
        }
    }

    public static int getNumeroAtomicas() {
        return numeroAtomicas;
    }

    public static void setNumeroAtomicas(int numeroAtomicas) {
        Parser.numeroAtomicas = numeroAtomicas;
    }

    public static ArrayList<Character> getAtomos() {
        return atomos;
    }

    public static void setAtomos(ArrayList<Character> atomos) {
        Parser.atomos = atomos;
    }

    public static ArrayList<String> getFormulas() {
        return formulas;
    }

    public static void setFormulas(ArrayList<String> formulas) {
        Parser.formulas = formulas;
    }

    public static String getAux() {
        return aux;
    }

    public static void setAux(String aux) {
        Parser.aux = aux;
    }

    public static ArrayList<String> getSubFormulas() {
        return subFormulas;
    }

    public static void setSubFormulas(ArrayList<String> subFormulas) {
        Parser.subFormulas = subFormulas;
    }

    public static Object[][] getTabla() {
        return tabla;
    }

    public static void setTabla(Object[][] tabla) {
        Parser.tabla = tabla;
    }
}
