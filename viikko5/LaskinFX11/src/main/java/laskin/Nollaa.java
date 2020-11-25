/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author taleiko
 */
public class Nollaa extends Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.syotekentta = tuloskentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        tuloskentta.setText("0");
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
