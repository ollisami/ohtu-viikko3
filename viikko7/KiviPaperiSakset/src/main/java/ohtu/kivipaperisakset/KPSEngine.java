
package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPSEngine {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public void pelaa() {
        
        Tuomari tuomari = new Tuomari();
        String ekanSiirto;
        String tokanSiirto;
      
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        while(true) {

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = toisenPelaajanSiirto(ekanSiirto);

            if(!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto))
                break;

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String toisenPelaajanSiirto(String ekanSiirto);
}
