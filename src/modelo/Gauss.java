/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import visao.Detalhes;

/**
 *
 * @author herquiloidehele
 */
public class Gauss {
    
    private Vector<Vector<Double>> matrizA;
    private Vector<Double> matrizB;
    private LinkedList<Double> multiplicadores = new LinkedList<Double>();
    private int ordemMatriz;
    public Detalhes detalhes;
    
          
         
    
    
    
    private Map<String, Double> resultados = new HashMap<>();
    
    

    public Gauss(Vector<Vector<Double>> matrizA, Vector<Double> matrizB){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
       
        imprimirMatriz("Matriz Aumentada");
        
       
     }
    
    
    public Gauss(Vector<Double> matrizAsLista , Vector<Double> matrizB, int ordemMatriz, Detalhes jpDetalhes){
        this.ordemMatriz = ordemMatriz;
        this.comporMatriz(matrizAsLista, matrizB, ordemMatriz);
       
        
        this.setJPDetalhes(jpDetalhes);
        this.detalhes.setOrderMatriz(this.ordemMatriz);
        this.imprimirMatriz("Matriz Aumentada");
//        
    }
    
    
    public void adicionarDetalhes(Detalhes detalhes){
        this.detalhes = detalhes;
    }
    
    
    public void comporMatriz(Vector<Double> matrizAsLista , Vector<Double> matrizB, int ordemMatriz){
       
        this.matrizA = new Vector<>();
        this.matrizB = matrizB;
        
        int cont = 0;
        for(int linha = 0; linha<ordemMatriz; linha++){
            this.matrizA.add(new Vector<Double>());
           for(int coluna = 0; coluna<ordemMatriz; coluna++){
               this.matrizA.get(linha).add(matrizAsLista.get(cont++));
           }
        } 
    }
    
    
    
    
    /**
     * imprime todos elementos da matriz de forma formatada
     */
    public void imprimirMatriz(String operacao){


//        passos.adicionarElementos(matrizA);
        
        int indexMatrizB = 0;
        for(Vector linhas: matrizA){
            for(Object colunas:  linhas){
                System.out.print(colunas + "     ");
            }
            System.out.print(" =     "+ this.matrizB.get(indexMatrizB));
            System.out.println(" ");
            indexMatrizB++;
        }
        System.out.println("\n\n");
        
         this.detalhes.adicionarConteudo(this.matrizA, this.matrizB, operacao);
    }
    
    
     /** 
     * Calcula os multiplicadores para cada linha baseado no pivot para a coluna
     * @param matriz
     * @param linha
     * @return 
     */
    private  Double getMultiplicador(int linha, int colunaPivot, double pivot){
        return this.arredondar(matrizA.get(linha).get(colunaPivot)/pivot);
    }
    
    
    /**
     * metodo que Retorna o pivot dada um determinado indice
     * da coluna.
     * 
     */
    private double getPivot(int colunaEelemento){   
        return this.matrizA.get(colunaEelemento).get(colunaEelemento);
    }

    
    
    /**
     * Escalona a atriz de modo a gerar ma matriz diagonal superior
     * retorna a matriz A ja escalonada
     */
    public Vector<Vector<Double>> escalonar(){
 
        double multiplicador;
        int colunaPivoteamento = 0;
        int linhaPivot = 0;
        
        
        for(int pivoteamento = 0; pivoteamento<this.matrizA.size()-1; pivoteamento++){
            double multiplicadorExperno = 0;
            for(int linha = pivoteamento+1; linha<matrizA.size(); linha++){
                double pivot = this.getPivot(colunaPivoteamento);
                multiplicador = this.getMultiplicador(linha, colunaPivoteamento, pivot);
                 multiplicadorExperno = multiplicador;
                 multiplicadores.add(multiplicador);
                
                for(int coluna = colunaPivoteamento; coluna<matrizA.get(linha).size(); coluna++){

                    /**
                     * Ln = Ln - multiplicador*Ln-1
                     */

                    matrizA.get(linha).set(coluna, matrizA.get(linha).get(coluna) - multiplicador*this.matrizA.get(linhaPivot).get(coluna));
                    
                }
                matrizB.set(linha, matrizB.get(linha) - multiplicador*this.matrizB.get(linhaPivot));
                
                
                
                imprimirMatriz("Linha"+(linha+1) +"="+  "Linha"+(linha+1) +" - ("+ multiplicadores.removeFirst() +" * "+ "Llinha"+(linhaPivot+1)+")");
               
            }
           colunaPivoteamento++;
           linhaPivot++; 
        }
        return this.matrizA;
    }

    
    /**
     * metodo que calcula o valor de cada x da equacao 
     * atraves da retrosubstituicao
     */
    public void retrosubstituicao(){
        for(int linha = this.matrizA.size()-1; linha>=0; linha--){
            double resultLinha = this.matrizB.get(linha);

            for(int coluna = this.matrizA.get(linha).size()-1; coluna>=0; coluna--){
                
                if(coluna>=linha){
                    if(linha == coluna){
                        this.resultados.put("X"+(linha+1), this.arredondar(resultLinha/matrizA.get(linha).get(coluna)));
                        this.matrizB.set(linha, resultados.get("X"+(linha+1)));
                        break;
                    }
                    else
                    resultLinha = resultLinha - (matrizA.get(linha).get(coluna) * matrizB.get(coluna));    
                }
            }
            
        }
        imprimirMatriz("Aplicando Retrosubstituicao");  
    }
    
    
    public Map<String,Double> getResultados(){
        return this.resultados;
    }
    
    
    public double arredondar(double numero){
//        BigDecimal bd = new BigDecimal(numero);
//        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
//        return bd.doubleValue();
    return numero;
    }
    
    
    
    public void adicionarCobteudo(JPanel matrizA, JPanel matrizB){
        for (int linha = 0; linha < this.ordemMatriz; linha++){
            matrizB.add(new JLabel(String.valueOf(this.matrizB.get(linha))));
//            matrizB.validate();
            for(int coluna =0; coluna< this.ordemMatriz; coluna++){
                matrizA.add(new JLabel(String.valueOf(this.matrizA.get(linha).get(coluna))));
            }
        }
        
    }
    
    
    public void setJPDetalhes(Detalhes detalhes){
        this.detalhes = detalhes;
    }
    
    
    
    public Vector<Vector<Double>> getMatrizA() {
        return matrizA;
    }

    public Vector<Double> getMatrizB() {
        return matrizB;
    }
    

}
