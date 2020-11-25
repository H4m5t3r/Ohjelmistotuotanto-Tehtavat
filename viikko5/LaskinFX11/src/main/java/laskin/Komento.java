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
public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected int viimeinenOperaatioluku;
    
    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    public abstract void suorita();
    
    public abstract void peru();
}
