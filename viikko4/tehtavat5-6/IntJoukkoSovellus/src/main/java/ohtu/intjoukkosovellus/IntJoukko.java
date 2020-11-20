
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        luvut = new int[kapasiteetti];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        
        if (alkioidenLkm == 0) {
            luvut[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            lisaaLukuJokaEiKuuluJoukkoon(luku);
            return true;
        }
        return false;
    }
    
    private boolean taulukkoOnTaynna() {
        return alkioidenLkm % luvut.length == 0;
    }
    
    private void lisaaLukuJokaEiKuuluJoukkoon(int luku) {
        luvut[alkioidenLkm] = luku;
        alkioidenLkm++;
            
        if (taulukkoOnTaynna()) {
            muodostaIsompiTaulukko();
        }
    }
    
    private void muodostaIsompiTaulukko() {
        int[] taulukkoOld = new int[luvut.length];
        kopioiTaulukko(luvut, taulukkoOld);
        luvut = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, luvut);
    }
    
    private int indeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean kuuluu(int luku) {
        return indeksi(luku) != -1;
    }

    public boolean poista(int luku) {
        int kohta = indeksi(luku);
        if (kohta == -1) {
            return false;
        }
        
        siirraTaulukonLuvutYksiTaaksepainTastaKohdasta(kohta);
        alkioidenLkm--;
        return true;
    }
    
    private void siirraTaulukonLuvutYksiTaaksepainTastaKohdasta(int kohta) {
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            luvut[j] = luvut[j + 1];
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        }
        
        String tuotos = "{";
        tuotos = lisaaLuvutToStringMerkkijonoon(tuotos);
        tuotos += "}";
        return tuotos;
    }
    
    private String lisaaLuvutToStringMerkkijonoon(String tuotos) {
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += luvut[i];
            tuotos += ", ";
        }
        return tuotos += luvut[alkioidenLkm - 1];
    }


    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(luvut, 0, taulu, 0, taulu.length);
        return taulu;
    }
    
    
    public static IntJoukko lisaaKaikki(int[] taaltaOtetaanLuvut) {
        IntJoukko kaikkiLuvutLisatty = new IntJoukko();
        for (int i = 0; i < taaltaOtetaanLuvut.length; i++) {
            kaikkiLuvutLisatty.lisaa(taaltaOtetaanLuvut[i]);
        }
        return kaikkiLuvutLisatty;
    }
    
    public static IntJoukko lisaaKaikki(IntJoukko alkujoukko, int[] taaltaOtetaanLuvut) {
        for (int i = 0; i < taaltaOtetaanLuvut.length; i++) {
            alkujoukko.lisaa(taaltaOtetaanLuvut[i]);
        }
        return alkujoukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = lisaaKaikki(a.toIntArray());
        lisaaKaikki(x, b.toIntArray());
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int luku : a.toIntArray()) {
            if (b.kuuluu(luku)) {
                y.lisaa(luku);
            }
        }
        return y;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = lisaaKaikki(a.toIntArray());
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }
        return z;
    }

}
