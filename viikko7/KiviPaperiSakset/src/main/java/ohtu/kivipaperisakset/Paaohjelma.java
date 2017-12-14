package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean kaynnissa = true;
        while (kaynnissa) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            kaynnissa = pelaa(vastaus.charAt(vastaus.length()-1));
        }
    }
    public static boolean pelaa(char pelitapa) {
        KPSEngine peli;
        switch (pelitapa) {
            case 'a':
                peli = new KPSPelaajaVsPelaaja();
                break;
            case 'b':
                peli = new KPSTekoaly();
                break;
            case 'c':
                peli = new KPSParempiTekoaly();
                break;
            default:
                return false;
        }
        peli.pelaa();
        return true;
    }
}
