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
public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        viimeinenOperaatioluku = Integer.parseInt(syotekentta.getText());
        tuloskentta.setText(Integer.toString((Integer.parseInt(tuloskentta.getText()) + Integer.parseInt(syotekentta.getText()))));
        syotekentta.setText("");
    }

    @Override
    public void peru() {
        tuloskentta.setText(Integer.toString(Integer.parseInt(tuloskentta.getText()) - viimeinenOperaatioluku));
    }
    
}
