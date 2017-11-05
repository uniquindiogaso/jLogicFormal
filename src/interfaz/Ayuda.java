
package interfaz;

/**
 *
 * @author gusta
 */
public class Ayuda extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ayuda() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle(".:: Manual de Usuario - Uso Calculadora Proposicional ::.");
        
        menuManual.setSelectionRow(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuManual = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        lAyuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        menuManual.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Manual de Usuario");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Ventana Principal");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Ingreso Fórmula");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Satisfacibilidad");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tautología");
        treeNode1.add(treeNode2);
        menuManual.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        menuManual.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                menuManualValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(menuManual);

        jScrollPane2.setViewportView(lAyuda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 548, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuManualValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_menuManualValueChanged
        
        String menu = evt.getPath().getLastPathComponent().toString();
        
        if ("Ventana Principal".equalsIgnoreCase(menu)){
           lAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda/demo.png")));
       }else if ("Ingreso Fórmula".equalsIgnoreCase(menu)){
           lAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda/demo.png")));
       }else if ("Satisfacibilidad".equalsIgnoreCase(menu)){
           lAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda/demo.png")));
       }else if ("Tautología".equalsIgnoreCase(menu)){
           lAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ayuda/demo.png")));
       }
        
    }//GEN-LAST:event_menuManualValueChanged

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
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ayuda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lAyuda;
    private javax.swing.JTree menuManual;
    // End of variables declaration//GEN-END:variables
}
