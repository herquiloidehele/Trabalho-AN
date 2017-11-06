/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import apple.laf.JRSUIUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Gauss;

/**
 *
 * @author herquiloidehele
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    
    
    private ArrayList<JTextField> matrizA = new ArrayList<>();
    private ArrayList<JLabel> igualdades = new ArrayList<>();
    private ArrayList<JTextField> matrizB = new ArrayList<>();
    
    
    private ArrayList<JLabel> matrizAResultado = new ArrayList<>();
    private ArrayList<JLabel> matrizBResutado = new ArrayList<>();
    private ArrayList<JLabel> igualdadesResultado = new ArrayList<>();
    
    private int ordemMatriz = 3;
    
    private Gauss gaus;
    private ArrayList<JTextField> composNulos = new ArrayList<>();
    
    public JanelaPrincipal() {
        initComponents();
        this.inicializarElementos();
     
    }

    public void adicionarMatrizA(){
        Campo campo = new Campo("0");
        this.jpMatrizA.add(campo);
        this.matrizA.add(campo);
    }
    
    public void removerMatrizA(){
        this.jpMatrizA.remove(this.matrizA.remove(this.matrizA.size()-1));
    }
    
    
    
    public void adicionarIgualdades(){
        JLabel label = new JLabel("=");
        label.setFont(new Font("Arial", 1, 30));
        this.igualdades.add(label);
        this.jpIgualdade.add(label);
    }
    
    
    public void removerIgualdade(){
        this.jpIgualdade.remove(this.igualdades.remove(this.igualdades.size()-1));
    }
    
    public void adicionarMatrizB(){
        Campo campo = new Campo("");
        this.jpMatrizB.add(campo);
        this.matrizB.add(campo);
    }
    
    public void removerMatrizB(){
        this.jpMatrizB.remove(this.matrizB.remove(this.matrizB.size()-1));
    }
    
    
    
    public void adicionarMatrizBResultado(){
        JLabel label = new JLabel("0.0");
        this.jpMatrizBResultado.add(label);
        this.matrizBResutado.add(label);
    }
    
    public void removerMatrizBResultado(){
        this.jpMatrizBResultado.remove(this.matrizBResutado.remove(this.matrizBResutado.size()-1));
    }
    
    public void adicionarMatrizAResultado(String conteudo){
        JLabel label = new JLabel(conteudo);
        this.jpMatrizAResultado.add(label);
        this.matrizAResultado.add(label);
    }
    
    public void removerMatrizAResultado(){
        this.jpMatrizAResultado.remove(this.matrizAResultado.remove(this.matrizAResultado.size()-1));
    }
    
    public void adicionarIngualdadeResultado(){
        JLabel label = new JLabel("=");
        this.jpIgualdadeResultado.add(label);
        this.igualdadesResultado.add(label);
    }
    
    public void removerIgualdadeResultado(){
        this.jpIgualdadeResultado.remove(this.igualdadesResultado.remove(this.igualdadesResultado.size()-1));
    }
    
    
    
    
    
    public void inicializarElementos(){
        ((GridLayout)jpMatrizA.getLayout()).setColumns(this.ordemMatriz);
        ((GridLayout)jpMatrizA.getLayout()).setRows(this.ordemMatriz);
        
        ((GridLayout)jpMatrizB.getLayout()).setRows(this.ordemMatriz);
        
        ((GridLayout)jpIgualdade.getLayout()).setRows(this.ordemMatriz);
        
        
        ((GridLayout)jpMatrizAResultado.getLayout()).setRows(this.ordemMatriz);
        
        ((GridLayout)jpIgualdadeResultado.getLayout()).setRows(this.ordemMatriz);
        
        ((GridLayout)jpMatrizBResultado.getLayout()).setRows(this.ordemMatriz);
        
        
        for(int i=0; i<Math.pow(this.ordemMatriz, 2); i++){
            this.adicionarMatrizA();
        }      
        
        for(int i=0; i<this.ordemMatriz; i++){
            this.adicionarIgualdades();
            this.adicionarMatrizB();
            
            this.adicionarMatrizAResultado("X"+(i+1));
            this.adicionarIngualdadeResultado();
            this.adicionarMatrizBResultado();
            
        }
        
       this.jpMatrizA.validate();
       this.jpIgualdade.validate();
       this.jpMatrizB.validate();
       
       
       this.jpMatrizAResultado.validate();
       this.jpIgualdadeResultado.validate();
       this.jpMatrizBResultado.validate();
    }
    
   
    
    public void aumentarElementos(){
        if(ordemMatriz < 6){
            this.ordemMatriz++;

            ((GridLayout)jpMatrizA.getLayout()).setColumns(this.ordemMatriz);
            ((GridLayout)jpMatrizA.getLayout()).setRows(this.ordemMatriz);

            ((GridLayout)jpMatrizB.getLayout()).setRows(this.ordemMatriz);

            ((GridLayout)jpIgualdade.getLayout()).setRows(this.ordemMatriz);
            
            ((GridLayout)jpMatrizAResultado.getLayout()).setRows(this.ordemMatriz);
        
            ((GridLayout)jpIgualdadeResultado.getLayout()).setRows(this.ordemMatriz);
        
            ((GridLayout)jpMatrizBResultado.getLayout()).setRows(this.ordemMatriz);

            for(int i = this.matrizA.size(); i<Math.pow(ordemMatriz, 2); i++)
                this.adicionarMatrizA();


            this.adicionarIgualdades();
            this.adicionarMatrizB();
            
            this.adicionarIngualdadeResultado();
            this.adicionarMatrizBResultado();
            this.adicionarMatrizAResultado("X"+this.ordemMatriz);

            this.jpMatrizA.validate();
            this.jpIgualdade.validate();
            this.jpMatrizB.validate();
            
            this.jpMatrizAResultado.validate();
            this.jpIgualdadeResultado.validate();
            this.jpMatrizBResultado.validate();
            
        }else
            JOptionPane.showMessageDialog(null, "Atingiu o limite Maximo");
        
    }
    
    public void diminuirElementos(){
        if(ordemMatriz > 2){
            this.ordemMatriz--;

            ((GridLayout)jpMatrizA.getLayout()).setColumns(this.ordemMatriz);
            ((GridLayout)jpMatrizA.getLayout()).setRows(this.ordemMatriz);

            ((GridLayout)jpMatrizB.getLayout()).setRows(this.ordemMatriz);

            ((GridLayout)jpIgualdade.getLayout()).setRows(this.ordemMatriz);
            
            ((GridLayout)jpMatrizAResultado.getLayout()).setRows(this.ordemMatriz);
        
            ((GridLayout)jpIgualdadeResultado.getLayout()).setRows(this.ordemMatriz);
        
            ((GridLayout)jpMatrizBResultado.getLayout()).setRows(this.ordemMatriz);

            for(double i = this.matrizA.size(); i>Math.pow(ordemMatriz, 2); i--)
                this.removerMatrizA();


            this.removerIgualdade();
            this.removerMatrizB();
            
            this.removerMatrizAResultado();
            this.removerIgualdadeResultado();
            this.removerMatrizBResultado();
            
            

           this.jpMatrizA.validate();
           this.jpIgualdade.validate();
           this.jpMatrizB.validate();
           
           this.jpMatrizAResultado.validate();
            this.jpIgualdadeResultado.validate();
            this.jpMatrizBResultado.validate();
        }else
            JOptionPane.showMessageDialog(null, "Atingiu o limite Minimo");
    }
    
    
 
    public void getMatrizA(){
        Vector<Double> elementosA = new Vector<>();
        Vector<Double> elementosB = new Vector<>();
        for(Component elemento: this.jpMatrizA.getComponents()){
            elementosA.add(Double.parseDouble(((JTextField)elemento).getText()));
        }
        
        
        for(Component elemento: this.jpMatrizB.getComponents()){
            elementosB.add(Double.parseDouble(((JTextField)elemento).getText()));
        }
        
        gaus = new Gauss(elementosA, elementosB, ordemMatriz);
        gaus.escalonar();
        gaus.retrosubstituicao();
        
    }
    
    
    public void setResultado(){
        System.out.println(gaus.getResultados());
        Map<String, Double> resultados = this.gaus.getResultados();
        for(int i = 0; i< this.jpMatrizBResultado.getComponents().length; i++){
           ((JLabel)this.jpMatrizBResultado.getComponents()[i]).setText(String.valueOf(resultados.get("X"+(i+1))));
        }
    }
    
    
    
    public boolean validarCampos(){
        boolean isValido = true;
        for(Component elemento: this.jpMatrizA.getComponents()){
            String valor = ((JTextField) elemento).getText().trim();
            if(valor.equals("") || this.hasString(valor)){
                ((JTextField) elemento).setBackground(Color.red);
                isValido = false;
            }else{
              ((JTextField) elemento).setBackground(Color.white);
            }
        }
        
        for(Component elemento: this.jpMatrizB.getComponents()){
            String valor = ((JTextField) elemento).getText().trim();
            if(valor.equals("") || this.hasString(valor)){
                ((JTextField) elemento).setBackground(Color.red);
                isValido = false;
            }else{
              ((JTextField) elemento).setBackground(Color.white);
            }
        }
        return isValido;      
    }

    
    public boolean hasString(String string){
        return string.matches("[0-9]*[^0-9]+[0-9]*");
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jpEquacao = new javax.swing.JPanel();
        jpMatrizA = new javax.swing.JPanel();
        jpIgualdade = new javax.swing.JPanel();
        jpMatrizB = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpIgualdadeResultado = new javax.swing.JPanel();
        jpMatrizBResultado = new javax.swing.JPanel();
        jpMatrizAResultado = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(30, 144, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Metodo de Gaus");
        jPanel1.add(jLabel1);

        jPanel3.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jpEquacao.setBackground(new java.awt.Color(255, 255, 255));
        jpEquacao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 144, 255)), "Coeficientes da Equacao Linear", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 16), new java.awt.Color(30, 144, 255))); // NOI18N

        jpMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizA.setMinimumSize(new java.awt.Dimension(100, 100));
        jpMatrizA.setLayout(new java.awt.GridLayout(2, 2, 4, 4));

        jpIgualdade.setBackground(new java.awt.Color(255, 255, 255));
        jpIgualdade.setPreferredSize(new java.awt.Dimension(20, 150));
        jpIgualdade.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        jpMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizB.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        javax.swing.GroupLayout jpEquacaoLayout = new javax.swing.GroupLayout(jpEquacao);
        jpEquacao.setLayout(jpEquacaoLayout);
        jpEquacaoLayout.setHorizontalGroup(
            jpEquacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEquacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMatrizA, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpIgualdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpMatrizB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jpEquacaoLayout.setVerticalGroup(
            jpEquacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEquacaoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpEquacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpIgualdade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jpMatrizA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpMatrizB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 144, 255)), "Solucoes da Equacao", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 16), new java.awt.Color(30, 144, 255))); // NOI18N

        jpIgualdadeResultado.setBackground(new java.awt.Color(255, 255, 255));
        jpIgualdadeResultado.setPreferredSize(new java.awt.Dimension(20, 150));
        jpIgualdadeResultado.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        jpMatrizBResultado.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizBResultado.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        jpMatrizAResultado.setBackground(new java.awt.Color(255, 255, 255));
        jpMatrizAResultado.setLayout(new java.awt.GridLayout(2, 1, 4, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jpMatrizAResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jpIgualdadeResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpMatrizBResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpMatrizBResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpIgualdadeResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jpMatrizAResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 144, 255)), "Ver Pass a Passo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(30, 144, 255))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Accoes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 16))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(30, 144, 255));
        jButton2.setText("Diminuir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(30, 144, 255));
        jButton4.setText("Adicionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setForeground(new java.awt.Color(30, 144, 255));
        jButton5.setText("Calcular");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jpEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpEquacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.diminuirElementos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.aumentarElementos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        if(this.validarCampos()){
            this.getMatrizA();
            this.setResultado();   
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jpEquacao;
    private javax.swing.JPanel jpIgualdade;
    private javax.swing.JPanel jpIgualdadeResultado;
    private javax.swing.JPanel jpMatrizA;
    private javax.swing.JPanel jpMatrizAResultado;
    private javax.swing.JPanel jpMatrizB;
    private javax.swing.JPanel jpMatrizBResultado;
    // End of variables declaration//GEN-END:variables
}
