package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPSEngine {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String toisenPelaajanSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return scanner.nextLine();
    }
}