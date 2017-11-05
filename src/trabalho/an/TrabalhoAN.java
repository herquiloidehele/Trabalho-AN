/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.an;

import java.util.Vector;

/**
 *
 * @author herquiloidehele
 */
public class TrabalhoAN {

    
    
    /**
     * Data um matriz, percore e imprime os elementos que 
     * se localizam na diagonal.
     * @param matriz
     * @return pivos - retorana um array de  pivos
     */
    public static Vector<Double> getPivot(double matriz[][]){
        Vector<Double> pivos = new Vector<>();
        
        for(int linha=0; linha<matriz.length; linha++){
            for(int coluna=0; coluna<matriz.length; coluna++){
                if(linha == coluna)
                    pivos.add(matriz[linha][coluna]);
            }
        }
        
        return pivos;    
    }
    
    
    
    /**
     * Calcula os multiplicadores para cada linha baseado no pivot para a coluna
     * @param matriz
     * @param linha
     * @return 
     */
    public static Double getMultiplicador(double matriz[][], int linha, int colunaPivot, double pivot){
        return (matriz[linha][colunaPivot]/pivot);
    }
    
    
    
    
    /**
     * imprime a matriz dada;
     * @param matriz 
     */
    public static void imprimirMatriz(double [][] matriz){
        
    }
    
    
    public static void main(String[] args) {
        double matriz [][] = {{1,2,3},
                              {4,5,6},
                              {7,8,9}};
        
        imprimirMatriz(matriz);
        
        System.out.println(getPivot(matriz));
             
    }
    
}
