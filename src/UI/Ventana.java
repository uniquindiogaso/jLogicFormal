/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Logica.AnalizadorProposicional;
import Logica.Nodo;

import Logica.Parser;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;



/**
 *
 * @author gusta
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public String formula = "";
    ArrayList<String> formulas = new ArrayList<>();

    private Nodo arbolS;
    private AnalizadorProposicional analizador;

    public Ventana() {
        initComponents();
        setBounds(0, 0, 875, 600);
        setLocationRelativeTo(null);

        //escucharTeclado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cVisorFormula = new javax.swing.JTextArea();
        btY = new javax.swing.JButton();
        btO = new javax.swing.JButton();
        btCondicional = new javax.swing.JButton();
        btNegacion = new javax.swing.JButton();
        btBiCondicional = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btParentesis = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        btAnalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVerdad = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuEj1 = new javax.swing.JMenuItem();
        menuEj2 = new javax.swing.JMenuItem();
        menuEj6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jButton7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton7.setText("()^()");

        jButton8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton8.setText("()V()");

        jButton9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton9.setText("()V()");

        jButton10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton10.setText("()^()");

        jButton11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton11.setText("()V()");

        jButton17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton17.setText("()V()");

        jButton18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton18.setText("()^()");

        jButton19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton19.setText("()^()");

        jButton20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton20.setText("()V()");

        jButton21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton21.setText("()V()");

        jButton22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton22.setText("()V()");

        jButton23.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton23.setText("()^()");

        jButton24.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton24.setText("()V()");

        jButton25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton25.setText("()^()");

        jButton26.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton26.setText("()V()");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Fórmula");

        cVisorFormula.setColumns(20);
        cVisorFormula.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cVisorFormula.setLineWrap(true);
        cVisorFormula.setRows(5);
        cVisorFormula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cVisorFormulaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(cVisorFormula);

        btY.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btY.setText("( )V( )");
        btY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btYActionPerformed(evt);
            }
        });

        btO.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btO.setText("( )^( )");
        btO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOActionPerformed(evt);
            }
        });

        btCondicional.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btCondicional.setText("( )→( )");
        btCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCondicionalActionPerformed(evt);
            }
        });

        btNegacion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btNegacion.setText("¬( )");
        btNegacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNegacionActionPerformed(evt);
            }
        });

        btBiCondicional.setBackground(new java.awt.Color(255, 153, 0));
        btBiCondicional.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btBiCondicional.setText("( )↔( )");
        btBiCondicional.setAlignmentY(0.0F);
        btBiCondicional.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBiCondicional.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btBiCondicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBiCondicionalActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton12.setText("()^()");

        jButton13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton13.setText("q");

        btParentesis.setBackground(new java.awt.Color(255, 153, 0));
        btParentesis.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btParentesis.setText("( )");
        btParentesis.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btParentesis.setPreferredSize(new java.awt.Dimension(51, 30));
        btParentesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParentesisActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton15.setText("()^()");

        jButton16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton16.setText("()V()");

        jButton27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton27.setText("()V()");

        jButton28.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton28.setText("()^()");

        jButton29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton29.setText("()^()");

        jButton30.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton30.setText("()V()");

        jButton31.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton31.setText("()V()");

        jButton32.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton32.setText("()V()");

        jButton33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton33.setText("()^()");

        jButton34.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton34.setText("()V()");

        jButton35.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton35.setText("()^()");

        jButton36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton36.setText("()V()");

        btAnalizar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btAnalizar.setText("Analizar");
        btAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Estadística: Operador Principal: v | Num Atomos : 5 | Es una tautologia | Es Satisfacible");

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tableaux", jPanel2);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaVerdad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaVerdad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tabla de Verdad", jPanel1);

        jMenu1.setText("Archivo");

        jMenuItem3.setText("Analizar");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Salir");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenu3.setText("Ejemplos");

        menuEj1.setText("2 Condiciones");
        menuEj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj1ActionPerformed(evt);
            }
        });
        jMenu3.add(menuEj1);

        menuEj2.setText("4 Condiciones");
        menuEj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj2ActionPerformed(evt);
            }
        });
        jMenu3.add(menuEj2);

        menuEj6.setText("6 Condiciones");
        menuEj6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj6ActionPerformed(evt);
            }
        });
        jMenu3.add(menuEj6);

        jMenu2.add(jMenu3);

        jMenuItem1.setText("Manual");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Acerca de");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(btBiCondicional)
                                        .addGap(11, 11, 11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton27)
                                            .addComponent(jButton32))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton15)
                                    .addComponent(jButton33)
                                    .addComponent(jButton28))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btY)
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton12)
                                    .addComponent(jButton29)
                                    .addComponent(jButton35))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton34)
                                        .addGap(11, 11, 11)
                                        .addComponent(jButton31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton30)
                                        .addGap(11, 11, 11)
                                        .addComponent(jButton36))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(btAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton16)
                                        .addGap(11, 11, 11)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btO)
                                .addGap(11, 11, 11)
                                .addComponent(btNegacion, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btCondicional))))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btO)
                            .addComponent(btNegacion)
                            .addComponent(btCondicional))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addGap(11, 11, 11)
                                .addComponent(jButton29)
                                .addGap(11, 11, 11)
                                .addComponent(jButton35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16)
                                    .addComponent(jButton13))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton34)
                                    .addComponent(jButton31))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton30)
                                    .addComponent(jButton36))
                                .addGap(11, 11, 11)
                                .addComponent(btAnalizar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btParentesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btY))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15)
                            .addComponent(btBiCondicional))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton33)
                            .addComponent(jButton32))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28)
                            .addComponent(jButton27))))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btYActionPerformed
        escribir(btY.getText());
    }//GEN-LAST:event_btYActionPerformed

    private void btBiCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBiCondicionalActionPerformed
        escribir(btBiCondicional.getText());
    }//GEN-LAST:event_btBiCondicionalActionPerformed

    private void btOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOActionPerformed
        escribir(btO.getText());
    }//GEN-LAST:event_btOActionPerformed

    private void btNegacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNegacionActionPerformed
        escribir(btNegacion.getText());
    }//GEN-LAST:event_btNegacionActionPerformed

    private void cVisorFormulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cVisorFormulaKeyReleased
        escribir(evt);
    }//GEN-LAST:event_cVisorFormulaKeyReleased

    private void btParentesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParentesisActionPerformed
        escribir(btParentesis.getText());
    }//GEN-LAST:event_btParentesisActionPerformed

    private void btCondicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCondicionalActionPerformed
        escribir(btCondicional.getText());
    }//GEN-LAST:event_btCondicionalActionPerformed

    private void btAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalizarActionPerformed
        analizarFormulas();
    }//GEN-LAST:event_btAnalizarActionPerformed

    private void menuEj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj1ActionPerformed
        cVisorFormula.setText("(p)↔(r)");
    }//GEN-LAST:event_menuEj1ActionPerformed

    private void menuEj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj2ActionPerformed
        cVisorFormula.setText("((p)↔(r))V((s)^(t))");
    }//GEN-LAST:event_menuEj2ActionPerformed

    private void menuEj6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj6ActionPerformed
        cVisorFormula.setText("((p)→(q))V((¬(p))↔((t)^((x)↔(z))))");
    }//GEN-LAST:event_menuEj6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalizar;
    private javax.swing.JButton btBiCondicional;
    private javax.swing.JButton btCondicional;
    private javax.swing.JButton btNegacion;
    private javax.swing.JButton btO;
    private javax.swing.JButton btParentesis;
    private javax.swing.JButton btY;
    private javax.swing.JTextArea cVisorFormula;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menuEj1;
    private javax.swing.JMenuItem menuEj2;
    private javax.swing.JMenuItem menuEj6;
    private javax.swing.JTable tablaVerdad;
    // End of variables declaration//GEN-END:variables

    private void escribir(String valor) {
        try {
            cVisorFormula.getDocument().insertString(cVisorFormula.getCaretPosition(), valor, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, "No se logro escribir en Display", ex);
        }
    }

    private void escribir(java.awt.event.KeyEvent evt) {
        //97 = a q= 113 z=122
        if (evt.getKeyCode() >= 113 && evt.getKeyCode() <= 122) {
            escribir(String.valueOf(evt.getKeyChar()));
        }
    }

    /**
     * @see
     * http://www.javacreed.com/how-to-capture-key-events-with-jframe-or-window/
     */
    private void escucharTeclado() {
        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(final KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_TYPED) {
                    escribir(e);
                }
                // Pass the KeyEvent to the next KeyEventDispatcher in the chain
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }

    private void analizarFormulas() {
        formulas.clear();
        Parser.hallarFormulas(cVisorFormula.getText().replace(" ", ""));
        formulas = Parser.getFormulas();
        if (Parser.bienFormada(formulas)) {
            Parser.encontrarFormulasRepetidas();
            Parser.literales(formulas);
            Parser.construirTabla();

            boolean sa = Parser.verSatisfacibilidad(Parser.getTabla());
            if (sa) {
                JOptionPane.showMessageDialog(null, "Es satisfacible");
                imprimirTablaConsola();
                dibujarArbol();
            } else {
                JOptionPane.showMessageDialog(null, "No es satisfacible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingreso una formula mal formada");
        }
    }

    private void imprimirTablaConsola() {
        String aux = "";
        for (int i = 0; i < Parser.getTabla().length; i++) {
            for (int j = 0; j < Parser.getTabla()[0].length; j++) {
                aux += Parser.getTabla()[i][j] + " ";
            }
            aux += "\n";
        }

        System.out.print(aux);

        for (int i = 0; i < Parser.getFormulas().size(); i++) {
            System.out.println(" " + Parser.getFormulas().get(i));
        }

        String[] cols = new String[Parser.getSubFormulas().size()];
        cols = Parser.getSubFormulas().toArray(cols);

        DefaultTableModel model = new DefaultTableModel(Parser.getTabla(), cols);
        tablaVerdad.setModel(model);
    }

    private void dibujarArbol() {
        try {
            paint(getGraphics());
            boolean sintactico = false;

            analizador = new AnalizadorProposicional();
            arbolS = analizador.crearArbolSintactico(cVisorFormula.getText());
            
            System.out.println("pArbolSintactico.getHeight() " + jPanel2.getHeight());
            if (sintactico == false) {
                arbolS.dibujarSubformula(arbolS,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 242,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 242,
                        jPanel2, Color.GREEN);
                
                System.out.println("arbol " + arbolS);

            } else if (sintactico == true) {
                arbolS.dibujarArbolSintactico(jPanel2.getGraphics(), arbolS,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 242,
                        jPanel2.getWidth() / 2, jPanel2.getHeight() - 242,
                        jPanel2, Color.GREEN);

            }
        } catch (Exception ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

           
    }

}