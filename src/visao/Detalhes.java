/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

/**
 *
 * @author herquiloidehele
 */
public class Detalhes extends javax.swing.JFrame {

    /**
     * Creates new form Detalhes
     */
    
    private int ordemMatriz;
    private JScrollPane jscrollPane;
    
    public Detalhes() {
        initComponents(); 
    }

    public Detalhes(int ordemMatriz)  {
        this.initComponents();
        this.ordemMatriz = ordemMatriz;
        ((GridLayout)this.jpVariaveis.getLayout()).setColumns(ordemMatriz); 
    }
    
    
    /**
     * cria cada componente componte composto pela matriz A e matriz B
     * -- cada card da resolucao
     * @param matrizA
     * @param matrizB
     * @return 
     */
    public void criarCompnente(){
        JPanel principal = new JPanel(null);
        principal.setSize(100, 100);   
        principal.setBackground(Color.white);
        
        JPanel jpMatrizA = new JPanel(new GridLayout(2, 2, 4, 4));
        jpMatrizA.setBackground(Color.WHITE);
        jpMatrizA.setBorder(new MatteBorder(0, 2, 0, 2, Color.black));
        
        
        JPanel jpMatrizB = new JPanel(new GridLayout(2, 1, 4, 4));
        jpMatrizB.setBackground(Color.white);
        jpMatrizB.setBorder(new MatteBorder(0, 0, 0, 2, Color.black));
       
        
        jpMatrizA.setBounds(40, 0, 200, 100);
        jpMatrizB.setBounds(260, 0, 50, 100);
        
        principal.add(jpMatrizA);
        principal.add(jpMatrizB);
        
        jpDetalhes.add(principal);
        
    }
    

    /**
     * com base nos valores que sao recebidos, introduz os valores na card
     * @param matrizA
     * @param matrizB
     * @param a
     * @param b 
     */
    public void adicionarConteudo( Vector<Vector<Double>> a, Vector<Double> b, String operacao){
        
        JPanel principal = new JPanel(null);
        principal.setSize(100, 100);   
        principal.setBackground(Color.white);
        
        JPanel jpMatrizA = new JPanel(new GridLayout(2, 2, 4, 4));
        ((GridLayout)jpMatrizA.getLayout()).setColumns(ordemMatriz);
        ((GridLayout)jpMatrizA.getLayout()).setRows(ordemMatriz);
        
        
        jpMatrizA.setBackground(Color.WHITE);
        jpMatrizA.setBorder(new MatteBorder(0, 2, 0, 2, Color.black));
        
        
        JPanel jpMatrizB = new JPanel(new GridLayout(2, 1, 4, 4));
        ((GridLayout)jpMatrizB.getLayout()).setColumns(1);
        ((GridLayout)jpMatrizB.getLayout()).setRows(ordemMatriz);
        
        jpMatrizB.setBackground(Color.white);
        jpMatrizB.setBorder(new MatteBorder(0, 0, 0, 2, Color.black));
       
        
        jpMatrizA.setBounds(40, 0, 300, 100);
        jpMatrizB.setBounds(360, 0, 100, 100);
        
        
        for (int linha = 0; linha < this.ordemMatriz; linha++){
            jpMatrizB.add(new JLabel(String.valueOf(b.get(linha))));
            for(int coluna =0; coluna< this.ordemMatriz; coluna++){
                jpMatrizA.add(new JLabel(String.valueOf(a.get(linha).get(coluna))));
            }
        }
        
        principal.add(jpMatrizA);
        principal.add(jpMatrizB);
        principal.validate();
        jpDetalhes.add(principal);
        jpDetalhes.validate();
        
        
        
        JLabel teste = new JLabel(operacao);
        teste.setForeground(Color.red);
        teste.setFont(new Font("Arial", Font.BOLD, 20));
        jpPassos.add(teste);
        jpPassos.validate();
    }
    
    
    public void setOrderMatriz(int ordemMatriz){
        this.ordemMatriz = ordemMatriz;
        this.criarVariaveis(this.ordemMatriz);
        
    }
    
    
    public void criarVariaveis(int ordemMatriz){
        ((GridLayout)jpVariaveis.getLayout()).setColumns(ordemMatriz+1);
        for(int i = 0; i<ordemMatriz; i++){
            JLabel variavel = new JLabel("X"+(i+1));
//            variavel.setSize(100,100);
            variavel.setForeground(new Color(30, 144, 255));
            this.jpVariaveis.add(variavel);
            jpVariaveis.validate();
        }
        
        JLabel variavelB = new JLabel("B");
        variavelB.setSize(50,50);
        variavelB.setForeground(new Color(30, 144, 255));
        this.jpVariaveis.add(variavelB);
            jpVariaveis.validate();
    }
    
    
    
    public void removerCalculos(){
        jpDetalhes.removeAll();
        jpDetalhes.validate();
        jpDetalhes.repaint();
        
        jpVariaveis.removeAll();
        jpVariaveis.validate();
        jpVariaveis.repaint();
        
        jpPassos.removeAll();
        jpPassos.validate();
        jpPassos.repaint();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpConteudo = new javax.swing.JPanel();
        jpMatrizA = new javax.swing.JPanel();
        jpMatrizB = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpDetalhes = new javax.swing.JPanel();
        jpVariaveis = new javax.swing.JPanel();
        jpPassos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jpMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizA.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        jpMatrizA.setMinimumSize(new java.awt.Dimension(100, 100));
        jpMatrizA.setLayout(new java.awt.GridLayout(2, 2, 4, 4));

        jpMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jpMatrizB.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        javax.swing.GroupLayout jpConteudoLayout = new javax.swing.GroupLayout(jpConteudo);
        jpConteudo.setLayout(jpConteudoLayout);
        jpConteudoLayout.setHorizontalGroup(
            jpConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(jpConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpConteudoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jpMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpConteudoLayout.setVerticalGroup(
            jpConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
            .addGroup(jpConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpConteudoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpConteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpMatrizB, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jpMatrizA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(4);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpDetalhes.setBackground(new java.awt.Color(255, 255, 255));
        jpDetalhes.setLayout(new java.awt.GridLayout(6, 1, 10, 10));

        jpVariaveis.setBackground(new java.awt.Color(255, 255, 255));
        jpVariaveis.setLayout(new java.awt.GridLayout(1, 3, 10, 10));

        jpPassos.setBackground(new java.awt.Color(255, 255, 255));
        jpPassos.setLayout(new java.awt.GridLayout(6, 1, 10, 10));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 144, 255));
        jLabel1.setText("Explicacao da Resolucao");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpVariaveis, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jpPassos, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpVariaveis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpPassos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDetalhes, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
            
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalhes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalhes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpConteudo;
    private javax.swing.JPanel jpDetalhes;
    private javax.swing.JPanel jpMatrizA;
    private javax.swing.JPanel jpMatrizB;
    private javax.swing.JPanel jpPassos;
    private javax.swing.JPanel jpVariaveis;
    // End of variables declaration//GEN-END:variables
}
