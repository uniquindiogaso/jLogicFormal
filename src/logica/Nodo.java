package logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * La clase Nodo que genera cada rama del arbol
 *
 * @author Carlos Toro, Gustavo Salgado y Laura Rúa
 * @version 1.0
 * @see http://www.java2s.com/Code/Java/Advanced-Graphics/Tree.htm
 */
public class Nodo extends JPanel {

    /**
     * Arraylist de las subformulas
     */
    ArrayList<String> subFormulas = new ArrayList<>();

    /**
     * atributo valor de la clase Nodo
     *
     */
    private String valor;
    /**
     * atributo conector de la clase Nodo
     *
     */
    private char conectorPrincipal;
    /**
     * atributo posConectorPrincipal de la clase Nodo
     *
     */
    private int posConectorPrincipal;
    /**
     * atributo buf de la clase Nodo
     *
     */
    BufferedImage buf = new BufferedImage(794, 487, BufferedImage.TYPE_3BYTE_BGR);
    /**
     * atributo nodoIzq de la clase Nodo
     *
     */
    public Nodo nodoIzq;
    /**
     * atributo nododer de la clase Nodo
     *
     */
    public Nodo nodoDer;
    /**
     * atributo color de la clase Nodo
     *
     */
    Color color = Color.GREEN;
    private boolean entro = false;

    /**
     * Metodo que crea el nodo del arbol
     * @param molecula
     * @throws Exception 
     */
    public Nodo(String molecula) throws Exception {
        valor = molecula;
        nodoIzq = nodoDer = null;
        if (valor.length() > 1) {
            conectorPrincipal = buscarConectorPrincipal(valor);
            System.out.println("conector principal" + conectorPrincipal);
            if (conectorPrincipal == '0') {
                throw new Exception("La expresion no es FBF");
            }
            generarArbol();
        } else {
            try {
                conectorPrincipal = valor.charAt(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cadena De Caracteres Vacia");
            }

        }
    }

    /**
     * Metodo que encuentra el conector principal de una molecula
     *
     * @param raiz el nodo que contiene la molecula
     * @return conector principal hallado
     */
    public char buscarConectorPrincipal(String valor) {
        int contador = 0;
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) == '(') {
                contador++;
            }
            if (valor.charAt(i) == ')') {
                contador--;
            }
            if (contador == 0) {
                if (valor.charAt(i) == '¬') {
                    if (valor.length() == 2) {
                        posConectorPrincipal = i;
                        return valor.charAt(i);
                    }
                    if (valor.charAt(i + 1) == '(') {
                        return '¬';
                    }
                    posConectorPrincipal = 2;
                    return valor.charAt(2);
                }
                i++;
                if ((i != valor.length()) && (isConectorBinario(valor.charAt(i)))) {
                    posConectorPrincipal = i;
                    return valor.charAt(i);
                }
            }
        }
        return '0';
    }

    /**
     * Metodo get del arraylist de subformulas
     * @return 
     */
    public ArrayList<String> getSubFormulas() {
        return subFormulas;
    }

    /**
     * Metodo set del arraylist de subformulas
     * @param subFormulas 
     */
    public void setSubFormulas(ArrayList<String> subFormulas) {
        this.subFormulas = subFormulas;
    }

    /**
     * Metodo que me dice si un caracter es conector binario o no
     *
     * @param ch caracter a analizar
     * @return true si es binario, false en caso contrario
     */
    public boolean isConectorBinario(char ch) {
        if (ch == 'V' || ch == '^' || ch == '→' || ch == '↔') {
            return true;
        }
        return false;
    }

    /**
     * Metodo que genera el arbol
     * @throws Exception 
     */
    public void generarArbol() throws Exception {

        String izquierda;

        if (posConectorPrincipal == 0) {
            if (valor.charAt(1) == '(' && valor.charAt(valor.length() - 1) == ')') {
                izquierda = valor.substring(2, valor.length() - 1);
            } else {
                izquierda = izquierda = valor.substring(1, valor.length());
            }

            nodoIzq = new Nodo(izquierda);
            return;
        }

        if (valor.charAt(0) == '(' && valor.charAt(posConectorPrincipal - 1) == ')') {
            izquierda = valor.substring(1, posConectorPrincipal - 1);
        } else {
            izquierda = valor.substring(0, posConectorPrincipal);
        }
        nodoIzq = new Nodo(izquierda);

        String derecha;
        if (valor.charAt(posConectorPrincipal + 1) == '(' && valor.charAt(valor.length() - 1) == ')') {
            derecha = valor.substring(posConectorPrincipal + 2, valor.length() - 1);
        } else {
            derecha = valor.substring(posConectorPrincipal + 1, valor.length());
        }

        nodoDer = new Nodo(derecha);
    }

    public Nodo getNodoIzq() {
        return nodoIzq;
    }

    public void setNodoIzq(Nodo nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public Nodo getNodoDer() {
        return nodoDer;
    }

    public void setNodoDer(Nodo nodoDer) {
        this.nodoDer = nodoDer;
    }

    public String valor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public char getConectorPrincipal() {
        return conectorPrincipal;
    }

    public void setConectorPrincipal(char conectorPrincipal) {
        this.conectorPrincipal = conectorPrincipal;
    }

    public int altura() {
        if (nodoIzq == null && nodoDer == null) {
            return 1;
        } else {
            int p1 = (nodoIzq == null) ? 0 : nodoIzq.altura();
            int p2 = (nodoDer == null) ? 0 : nodoDer.altura();

            return Math.max(p1, p2) + 1;
        }
    }

    /**
     * Metodo que dibuja el arbol
     * @param g varible del graphics
     * @param act nodo del arbol
     * @param x ubicacion en x
     * @param y ubicacion en y
     * @param x2 ubicacion de la linea en x
     * @param y2 ubicacion de la linea en y
     * @param p panel del arbol
     * @param colorP color del arbol
     */
    public void dibujarArbolSintactico(Graphics g, Nodo act, int x, int y, int x2, int y2, JPanel p, Color colorP) {

        if (colorP != null) {
            System.out.println("diferente de null");
            color = colorP;
        }

        if (act == null) {
            return;
        } else {
            int ancho = act.valor.length();

            System.out.println("ancho" + ancho);

            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 3, x2 + 15, y2 + 30);

            g.setColor(color);
            g.fillOval(x, y, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString("" + act.conectorPrincipal, (x) + 12, (y) + 20);

            if (act.getNodoIzq() != null) {
                dibujarArbolSintactico(g, act.getNodoIzq(), (x) - (anchoX(act.altura())), y + 100, x, y, p, color);

            }
            if (act.getNodoDer() != null) {
                dibujarArbolSintactico(g, act.getNodoDer(), (x) + (anchoX(act.altura())), y + 100, x, y, p, color);
            }
        }
    }

    /**
     * Metodo que identifica la subformula a dibujar
     * @param act el nodo del arbol
     * @param x ubicacion en x
     * @param y ubicacion en y
     * @param x2 ubicacion de la linea en x
     * @param y2 ubicacion de la linea en y
     * @param p el panel del arbol
     * @param colorP el color del arbol
     */
    public void dibujarSubformula(Nodo act, int x, int y, int x2, int y2, JPanel p, Color colorP) {

        Graphics2D g = (Graphics2D) p.getGraphics();

        if (colorP != null) {
            System.out.println("diferente de null");
            color = colorP;
        }

        if (act == null) {
            return;
        } else {
            int ancho = act.valor.length();

            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 3, x2 + 15, y2 + 30);

            System.out.println(color.toString());
            g.setColor(color);

            //el dibujo del circulo dependiendo la cantidad de letras y simbolos
            if (ancho >= 0 && ancho <= 2) {
                g.setColor(color);
                g.fillOval(x, y, 30, 30);
                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x) + 11, (y) + 20);

                System.out.println("0 y 2");
            }

            if (ancho >= 3 && ancho <= 5) {
                g.setColor(color);
                g.fillOval(x, y, 40, 33);

                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x) + 5, (y) + 20);
                System.out.println("3 y 8");
            }
            if (ancho >= 6 && ancho <= 8) {
                g.setColor(color);
                g.fillOval(x - 18, y, 55, 30);

                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x) - 11, (y) + 20);
                System.out.println("3 y 8");
            }
            if (ancho >= 9 && ancho <= 13) {
                g.setColor(color);
                g.fillOval(x - 25, y + 3, 85, 30);

                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x - 30) + 12, (y) + 25);
                System.out.println("9 y 13");
            }
            if (ancho >= 14 && ancho <= 18) {
                g.setColor(color);
                g.fillOval(x - 25, y + 10, 115, 30);
                System.out.println("14 y 18");
                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x - 20) + 12, (y) + 30);

            }
            if (ancho >= 19 && ancho <= 23) {
                g.setColor(color);
                g.fillOval(x - 52, y + 1, 132, 30);
                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x - 50), (y) + 20);
                System.out.println("19 y 23");

            }
            if (ancho >= 24 && ancho <= 27) {
                g.setColor(color);
                g.fillOval(x - 58, y + 10, 148, 30);
                g.setColor(Color.BLACK);
                g.drawString("" + act.valor, (x - 55), (y) + 30);
                System.out.println("24 y 27");

            }

            if (act.getNodoIzq() != null) {
                dibujarSubformula(act.getNodoIzq(), (x) - (anchoX(act.altura())), y + 100, x, y, p, color);

            }
            if (act.getNodoDer() != null) {
                dibujarSubformula(act.getNodoDer(), (x) + (anchoX(act.altura())), y + 100, x, y, p, color);
            }

        }
    }

    /**
     * Metodo que identifica el ancho
     * @param n numero que ubica en ancho
     * @return el valor en pixeles
     */
    public int anchoX(int n) {

        if (n == 6) {
            return 300;
        }
        if (n == 5) {
            return 180;
        }
        if (n == 4) {
            return 130;
        }
        if (n == 3) {
            return 80;
        }
        if (n == 2) {
            return 30;
        }
        if (n == 1) {
            return 0;
        }
        return 0;
    }

    public String getValor() {
        return valor;
    }

    /**
     * Metodo que guarda el arbol
     */
    private void pruebaGuardado() {
        try {
            BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.fillRect(25, 25, 50, 50);
            g2d.dispose();
            ImageIO.write(img, "JPEG", new File("D:\\LeapMotion\\foo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
