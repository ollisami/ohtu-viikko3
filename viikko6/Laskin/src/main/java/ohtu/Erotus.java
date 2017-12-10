
package ohtu;

import javax.swing.JTextField;


public class Erotus implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tulos;
    private JTextField syote;
    private int edellinenArvo;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tulos, JTextField syote) {
        this.sovellus = sovellus;
        this.tulos = tulos;
        this.syote = syote;
    }

    @Override
    public void suorita() {
        
        if(sovellus == null) return;
        
        try {
            int arvo = Integer.parseInt(syote.getText());
            sovellus.miinus(arvo);
            int laskunTulos = sovellus.tulos();
            syote.setText("");
            tulos.setText("" + laskunTulos);
            edellinenArvo = arvo;
        } catch (Exception e) {
        }
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
