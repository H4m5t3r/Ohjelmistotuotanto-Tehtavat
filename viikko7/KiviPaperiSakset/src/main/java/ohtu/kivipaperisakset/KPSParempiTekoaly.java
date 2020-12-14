package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KiviPaperiSakset {
    TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly() {
        this.tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String toisenSiirto() {
        String tekoalynValinta = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tekoalynValinta);
        return tekoalynValinta;
    }
}