
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI   = 5,  // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
                                                 // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;          // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;     // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alustaJoukko(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        alustaJoukko(kapasiteetti, OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatusKoko) {
        alustaJoukko(kapasiteetti, kasvatusKoko);
    }
    
    private void alustaJoukko(int kapasiteetti, int kasvatusKoko) {
        if (kapasiteetti < 0 || kasvatusKoko < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatusKoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            ljono[0] = luku;
            alkioidenLkm++;
            return true;
        } else if (!taulukkoSisaltaaLuvun(luku)) {
            lisaaJosEiSisalla(luku);
            return true;
        }       
        return false;
    }
    
    private void lisaaJosEiSisalla(int luku) {
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm % ljono.length == 0) {
            int[] taulukkoOld = ljono;
            kopioiTaulukko(ljono, taulukkoOld);
            ljono = new int[alkioidenLkm + kasvatuskoko];
            kopioiTaulukko(taulukkoOld, ljono);
        }
    }

    public boolean taulukkoSisaltaaLuvun (int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {      
        if(taulukkoSisaltaaLuvun(luku)) {
            poistaTaulukosta(luku);
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    private void poistaTaulukosta(int poistettava) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (poistettava == ljono[i]) {
                ljono[i] = 0;
                siirraTaulukkoa(i);
                break;
            }   
        }
    }
    
    private void siirraTaulukkoa(int kohdasta) {
        int apu = 0;
        for (int i = kohdasta; i < alkioidenLkm; i++) {
            apu = ljono[i];
            ljono[i] = ljono[i + 1];
            ljono[i + 1] = apu;
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String tuotos = alkioidenLkm == 0 ? "{" : "{" + ljono[0];
        for (int i = 1; i < alkioidenLkm; i++) {
            tuotos += ", ";
            tuotos += ljono[i];
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
   
    private static IntJoukko lisaaJoukostaJoukkoon (IntJoukko x, IntJoukko lisattava) {
        int[] aTaulu = lisattava.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        return x;
    }

    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        x = lisaaJoukostaJoukkoon(x, a);
        x = lisaaJoukostaJoukkoon(x, b);
        return x;
    }

    private static IntJoukko lisaaLeikkaus(IntJoukko x, IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    x.lisaa(bTaulu[j]);
                }
            }
        }
        return x;
    }
    
    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        return lisaaLeikkaus(y, a, b);
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] bTaulu = b.toIntArray();
        z = lisaaJoukostaJoukkoon(z, a);
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
        return z;
    }      
}