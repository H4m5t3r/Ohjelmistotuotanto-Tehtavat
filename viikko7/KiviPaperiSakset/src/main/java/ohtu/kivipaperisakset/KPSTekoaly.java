package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {
    Tekoaly tekoaly;
    
    public KPSTekoaly() {
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String toisenSiirto() {
        String tekoalynValinta = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tekoalynValinta);
        return tekoalynValinta;
    }
}