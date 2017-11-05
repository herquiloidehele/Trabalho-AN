/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author herquiloidehele
 */
public class Campo extends JTextField{

    private String texto;
    
    public Campo(String placeholder) {
        this.texto = placeholder;
//        this.setText(texto);
//        this.setPreferredSize(new Dimension(30, 30));
//        this.setSize(30, 30);
//        this.setSize(new Dimension(50, 50));
    }
    
    
}
