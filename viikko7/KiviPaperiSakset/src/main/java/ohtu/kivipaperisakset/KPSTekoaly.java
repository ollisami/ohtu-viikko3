package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPSEngine {

    private static final Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenPelaajanSiirto(String ekanSiirto) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }
}