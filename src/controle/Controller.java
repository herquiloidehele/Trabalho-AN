/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Map;
import java.util.Vector;
import modelo.Gauss;

/**
 *
 * @author herquiloidehele
 */
public class Controller {
    
    
    private Vector<Double> elementos;
    private int orderm;
    private Vector<Vector<Double>> matrizA = new Vector<Vector<Double>>();
    private Gauss gauss;
    
    
    
    public Controller(Vector<Double> elementos, Vector<Double> matrizB, int ordermMatriz){
       this.elementos = elementos;
       this.orderm = ordermMatriz;
       this.comporElementos();
       this.gauss = new Gauss(matrizA, matrizB);
       calcular();
       gauss.imprimirMatriz();
    }
    
   public void calcular(){
       this.matrizA = gauss.escalonar();
   }
    
   
   
    private void comporElementos(){
        int cont = 0;
        
        for(int linha = 0; linha<this.orderm; linha++){
            this.matrizA.add(new Vector<Double>());
           for(int coluna = 0; coluna<this.orderm; coluna++){
               this.matrizA.get(linha).add(elementos.get(cont++));
           }
        }
        
        
    }
    
    
    public Vector<Vector<Double>> getMatrizA(){
        return this.matrizA;
    }
    
    
    
    public Map<String,Double> getResultados(){
        return gauss.getResultados();
    }
    
}
