/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author herquiloidehele
 */
public class Passos {
    
    
    private Vector<Vector<Double>> matrizA;
    private Vector<Double> matrizB;
    
    private Vector<Vector<Double>> matrizEscalonadaA;
    private Vector<Double> matrizEscalonadaB;
    
    
    
    public  ArrayList<Vector<Vector<Double>>> escalonamentoA;

    private Map<String, Double> resultados;

    
    public Passos(Vector<Vector<Double>> matrizA, Vector<Double> matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public Passos() {
    }
    
    
    
    public void setMatrizEscalonada(Vector<Vector<Double>> matrizA, Vector<Double> matrizB) {
            this.matrizEscalonadaA = matrizA;
            this.matrizEscalonadaB = matrizB;
    }

    public Vector<Vector<Double>> getMatrizEscalonadaA() {
        return matrizEscalonadaA;
    }

    public Vector<Double> getMatrizEscalonadaB() {
        return matrizEscalonadaB;
    }
    
    

    public Map<String, Double> getResultados() {
        return resultados;
    }

    public void setResultados(Map<String, Double> resultados) {
        this.resultados = resultados;
    }
    
    
    
    
    public static void main(String[] args) {
     
        int cont  = 0;
        Vector<Double> matrizB =  new Vector<>(Arrays.asList(10.0, 30.0, 20.0));
        Vector<Vector<Double>> matrizA = new Vector<>();
        
        
        for (int linha = 0; linha<matrizB.size(); linha++){
            matrizA.add(new Vector<Double>());
            for(int coluna =0; coluna<matrizB.size(); coluna++){
                matrizA.get(linha).add((double)++cont);
            }
        }
        
        Passos passoa = new Passos(matrizA, matrizB);
        
        
    }
    
    
    
    
}
