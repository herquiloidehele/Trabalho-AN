/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author herquiloidehele
 */
public class GerarPDF {

    
    private static final String RESOLUCAO = "resolucao.pdf";
    private static final Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.GREEN);
    private static final Font PARAGRAFO_BRANCO = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.WHITE);
    private PdfPTable tabela;
    private Document documento;
    private int ordemMatriz;
    private Section seccao;
    private Vector<PdfPCell> variaveis = new Vector<>();
    
    
    public GerarPDF(int ordemMatriz) {
        this.ordemMatriz = ordemMatriz;
        this.tabela = new PdfPTable(this.ordemMatriz + 1);
        documento = new Document();
    }
    
    
    /**
     * Cria e adiciona todo conteudo que deve 
     * conter no documento
     * @param nomeFicheiro - nome do ficheiro que sera criado 
     */
    public void criarDocumento(String nomeFicheiro) {
                
        Anchor ancora = new Anchor("First Chapter", FONT_TITULO);
        ancora.setName("Titulo");
        Chapter capitulo = new Chapter(new Paragraph(ancora), 1);
        seccao = capitulo.addSection(new Paragraph("Resoculãco de Sistema de Equacões lineares (GAUSS)", FONT_TITULO));
        
        
        seccao.add(addEmptyLine(new Paragraph(), 3));
        seccao.add(this.criarTabela(this.criarVariaveis()));
   
        try {
            try {
                PdfWriter.getInstance(documento, new FileOutputStream(nomeFicheiro));
                documento.open();
                documento.add(seccao);
                documento.addTitle("Resoluacao do Metodo de Gauss");
                documento.addAuthor("Analise Numerica");
                documento.close();
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(null, "Erro no documento \n"+ ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Ficheiro nao encontrado \n"+ ex.getMessage());
        }
        
        
        
    }
    
    
    /**
     * Cria as variaveis X1, X2, ... Xn e B
     * para o cabecalho da tabela
     * 
     * @return retorna um vector de variaveis
     */
    private Vector<PdfPCell> criarVariaveis(){
        
        for(int i = 0; i<this.ordemMatriz; i++){
            PdfPCell celula = new PdfPCell(new Phrase("X"+(i+1)));
            celula.setHorizontalAlignment(Element.ALIGN_CENTER);
            this.variaveis.add(celula);
        }

        return this.variaveis;
    }
    
    /**
     * Cria uma toda tabela com os seus elementos
     * 
     * @param variaveis - as variaveis que ficam no cabecalho
     * @return a tabela criada
     */
    private PdfPTable criarTabela(Vector<PdfPCell> variaveis){
        
        for(PdfPCell variavel: variaveis){
            this.tabela.addCell(variavel);    
        }
        
        PdfPCell variavel = new PdfPCell(new Phrase("B"));
        variavel.setHorizontalAlignment(Element.ALIGN_CENTER);
        this.variaveis.add(variavel);
        this.tabela.addCell(variavel);
        this.tabela.setHeaderRows(1);

        this.adicionarElementos();
        this.adicionarLinhaBanco(2);
        return this.tabela;
    }
    
    /**
     * adiciona um deeterminado numero de linhas em branco
     * @param paragraph
     * @param number 
     */
    private static Paragraph addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
        return paragraph;
    }
        
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        GerarPDF pdf = new GerarPDF(3);
        pdf.criarDocumento(RESOLUCAO);
        
        
        
//        pdf.criarDocumento(RESOLUCAO);
        
        String concatenacoes = "";
        int valores = 0;
        
//        for(int linha = 0; linha<3; linha++){
//            for(int coluna = 0; coluna<3; coluna++){
//                concatenacoes.concat("  "+(++valores));
//            }
//        }
        
        
        
    }

    private void adicionarElementos() {
        
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                tabela.addCell("A"+(i+1)+""+(j+1));
            }
        }
        
    }
    
    
    /**
     * adiciona uma linha em branco na tabela
     */
    private void adicionarLinhaBanco(int quantidade){
       for(int i =0; i< (this.ordemMatriz+1) * quantidade; i++){
           this.tabela.addCell(new Paragraph("A", PARAGRAFO_BRANCO));
       } 
    }
    
    
    
}
