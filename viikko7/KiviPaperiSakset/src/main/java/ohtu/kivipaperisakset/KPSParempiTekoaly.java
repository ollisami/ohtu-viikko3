package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPSEngine {

    private static TekoalyParannettu tekoaly = new TekoalyParannettu(20);

    @Override
    protected String toisenPelaajanSiirto(String ekanSiirto) {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return siirto;
    }
}
