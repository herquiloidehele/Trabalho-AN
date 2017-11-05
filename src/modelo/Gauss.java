/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author herquiloidehele
 */
public class Gauss {
    
    private Vector<Vector<Double>> matrizA;
    private Vector<Double> matrizB;
    private Vector<Double> multiplicadores;
    
    
    private Map<String, Double> resultados;
    
    
    /**
     * imprime a matriz dada;
     */
    public Gauss(Vector<Vector<Double>> matrizA, Vector<Double> matrizB){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.resultados = new HashMap<>();
        this.multiplicadores = new Vector<>();
    }
    
    
    /**
     * imprime todos elementos da matriz de forma formatada
     */
    public void imprimirMatriz(){
        int indexMatrizB = 0;
        for(Vector linhas: matrizA){
            for(Object colunas:  linhas){
                System.out.print(colunas + "     ");
            }
            System.out.print(" =     "+ this.matrizB.get(indexMatrizB));
            System.out.println(" ");
            indexMatrizB++;
        }
    }
    
    
     /** 
     * Calcula os multiplicadores para cada linha baseado no pivot para a coluna
     * @param matriz
     * @param linha
     * @return 
     */
    private  Double getMultiplicador(int linha, int colunaPivot, double pivot){
        return (matrizA.get(linha).get(colunaPivot))/pivot;
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
        
            for(int linha = pivoteamento+1; linha<matrizA.size(); linha++){
                double pivot = this.getPivot(colunaPivoteamento);
                multiplicador = this.getMultiplicador(linha, colunaPivoteamento, pivot);

                
                for(int coluna = colunaPivoteamento; coluna<matrizA.get(linha).size(); coluna++){

                    /**
                     * Ln = Ln - multiplicador*Ln-1
                     */

                    matrizA.get(linha).set(coluna, matrizA.get(linha).get(coluna) - multiplicador*this.matrizA.get(linhaPivot).get(coluna));
                    
                }
                System.out.println(this.matrizB.get(linhaPivot));
                matrizB.set(linha, matrizB.get(linha) - multiplicador*this.matrizB.get(linhaPivot));
            }
           colunaPivoteamento++;
           linhaPivot++; 
        }
        
        return this.matrizA;
    }

    
    
    public static void main(String[] args) {
         Vector<Vector<Double>> matrizA = new Vector<Vector<Double>>();
         Vector<Double> matrizB = new Vector<Double>(Arrays.asList(2.0, 1.0, 3.0));
         
         Scanner ler = new Scanner(System.in);
         
        int cont = 0;
        
         
        for (int linha = 0; linha<3; linha++){
            matrizA.add(new Vector<Double>());
            for(int coluna = 0; coluna<3; coluna++){   
                System.out.println("Introduza o A"+linha+""+coluna);
                matrizA.get(linha).add((double)ler.nextDouble());
            }
            
        }
         
        Gauss gaus = new Gauss(matrizA, matrizB);
        
        gaus.imprimirMatriz();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
//        gaus.escalonarBaixo();
//        gaus.escalonarCima();
//        Vector<Double> pivos = gaus.getPivot();
//        System.out.println("Pivos \n "+ gaus.getPivot());
////
//          System.out.println(gaus.getMultiplicador(2, 1, gaus.getPivot(1)));
        gaus.escalonar();
//        System.out.println("Matriz Escalonada");
//        System.out.println("");
//        System.out.println("");
////
        gaus.imprimirMatriz();
        
    }
    
    
}
