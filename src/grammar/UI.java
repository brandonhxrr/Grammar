package grammar;

import static grammar.GrammarFINAL.analyzeExpression;
import static grammar.GrammarFINAL.createDerivationTree;
import static grammar.GrammarFINAL.pila;

public class UI extends javax.swing.JFrame {
    
    int x, y, state; 
    String derivTree;
        
    public UI() {
        this.setTitle("");
        
        initComponents();
        valida.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        abrir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        close_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        exprText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        valida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        derivArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1110, 655));
        setMinimumSize(new java.awt.Dimension(1110, 655));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1110, 655));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        mainPanel.setMaximumSize(new java.awt.Dimension(1119, 655));
        mainPanel.setMinimumSize(new java.awt.Dimension(1119, 655));
        mainPanel.setPreferredSize(new java.awt.Dimension(1119, 655));
        mainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainPanelMouseDragged(evt);
            }
        });
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mainPanelMouseReleased(evt);
            }
        });
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        abrir.setBackground(new java.awt.Color(0, 51, 255));
        abrir.setFont(new java.awt.Font("JetBrains Mono NL", 0, 14)); // NOI18N
        abrir.setForeground(new java.awt.Color(51, 51, 51));
        abrir.setText("Verificar");
        abrir.setBorder(null);
        abrir.setContentAreaFilled(false);
        abrir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        abrir.setFocusable(false);
        abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abrirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abrirMouseExited(evt);
            }
        });
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        mainPanel.add(abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 150, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close_btn.setBackground(new java.awt.Color(255, 255, 255));
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close_disabled.png"))); // NOI18N
        close_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        close_btn.setBorderPainted(false);
        close_btn.setContentAreaFilled(false);
        close_btn.setFocusable(false);
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_btnMouseExited(evt);
            }
        });
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });
        jPanel1.add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-google-tag-manager-25.png"))); // NOI18N
        jLabel3.setText("Grammar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 40));

        exprText.setFont(new java.awt.Font("JetBrains Mono NL", 0, 18)); // NOI18N
        exprText.setText("Ingresa la expresión");
        exprText.setBorder(null);
        exprText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exprTextMouseClicked(evt);
            }
        });
        mainPanel.add(exprText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, -1));
        mainPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 340, 20));

        valida.setFont(new java.awt.Font("JetBrains Mono NL", 1, 18)); // NOI18N
        valida.setForeground(new java.awt.Color(255, 0, 0));
        valida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valida.setText("Válida");
        mainPanel.add(valida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 500, -1));

        derivArea.setEditable(false);
        derivArea.setColumns(20);
        derivArea.setFont(new java.awt.Font("JetBrains Mono", 0, 14)); // NOI18N
        derivArea.setRows(5);
        jScrollPane1.setViewportView(derivArea);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 640, 360));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 655));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseReleased
        this.setOpacity(1f);
    }//GEN-LAST:event_mainPanelMouseReleased

    private void mainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_mainPanelMousePressed

    private void mainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseDragged
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y + evt.getY()-y );
        this.setOpacity(0.9f);
    }//GEN-LAST:event_mainPanelMouseDragged

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        
        pila.clear();
        valida.setVisible(true);
        state = analyzeExpression(exprText.getText());
        
        if(!pila.empty() || state == 17){
            valida.setForeground(new java.awt.Color(255, 0, 0));
            derivArea.setText("");
            valida.setText("La expresión no pertenece a la gramática");
        }else{
            derivArea.setText("");
            derivTree = createDerivationTree(exprText.getText());
            derivArea.setText(derivTree);
            valida.setForeground(new java.awt.Color(0, 153, 51));
            valida.setText("La expresión pertenece a la gramática");
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void abrirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseExited
        abrir.setContentAreaFilled(false);
        abrir.setForeground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_abrirMouseExited

    private void abrirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseEntered
        abrir.setContentAreaFilled(true);
        abrir.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_abrirMouseEntered

    private void close_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseEntered
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close_enabled.png")));
    }//GEN-LAST:event_close_btnMouseEntered

    private void close_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseExited
        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/close_disabled.png")));
    }//GEN-LAST:event_close_btnMouseExited

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

    private void exprTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exprTextMouseClicked
        exprText.setText("");
        valida.setVisible(false);
    }//GEN-LAST:event_exprTextMouseClicked

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton close_btn;
    private javax.swing.JTextArea derivArea;
    private javax.swing.JTextField exprText;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel valida;
    // End of variables declaration//GEN-END:variables

}
