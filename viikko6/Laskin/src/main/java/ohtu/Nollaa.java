
package ohtu;

import javax.swing.JTextField;


public class Nollaa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int edellinenArvo;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovellus = sovellus;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        
        if(sovellus == null) return;
        
        edellinenArvo = sovellus.tulos();
        sovellus.nollaa();
        syote.setText("");
        tulos.setText("0");
    }

    @Override
    public void peru() {
        if(sovellus == null) return;
        
        sovellus.plus(edellinenArvo);
        int laskunTulos = sovellus.tulos();
        syote.setText("");
        tulos.setText("" + laskunTulos);
    }
    
}
