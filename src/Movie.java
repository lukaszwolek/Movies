
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Movie {


    public static void main(String args []) throws Exception {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        long ileLinii = Files.lines(Paths.get("movies.txt")).count();
        double numberOfFilm2 = Math.random()*ileLinii;
        int numberOfFilm = (int) numberOfFilm2;
        String[] Movies = new String[(int) ileLinii];
        int i=0;

        //System.out.println("wylosowano film nr "+numberOfFilm);


        while (scanner.hasNextLine())  {    //zapis tytułów do tablicy Stringów
            String line = scanner.nextLine();
            Movies[i] = line;
            i++;
        }
        //System.out.println(Movies);
        String FilmName = Movies[(int) numberOfFilm];

        //System.out.println(FilmName);

        char [] Wynik = new char[FilmName.length()];

        System.out.println(Wynik.length);

        for (int k=0; k< FilmName.length(); k++) {
            if (FilmName.charAt(k) == ' ') {
                Wynik[k] = ' ';
            } else Wynik[k] = '_';


        }

        System.out.println(Wynik);
        boolean czyRozw = false;
        boolean koniecProb = false;
        int iloscProb = 0;
        char [] wrongLetters = new char[10];
        

        while (!czyRozw && !koniecProb) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Wpisz litere:");
            String litera = scan.nextLine();
            boolean czyZgadles = false;
            char znak = ' ';

            for (int j = 0; j < FilmName.length(); j++) {

                znak = litera.charAt(0);
                //System.out.println(znak);
                if (znak == FilmName.charAt(j)) {
                    Wynik[j] = znak;
                    czyZgadles = true;

                }
            }
            System.out.println(Wynik);

            czyRozw = true;
            //sprawdzanie czy sa jeszcze puste pola
            for (int i2 = 0; i2 < FilmName.length(); i2++) {
                if (Wynik[i2] == '_') {
                    czyRozw = false;
                    break;
                }
            }
            if (!czyZgadles) {
                iloscProb = iloscProb + 1;
                wrongLetters[iloscProb-1] = znak;
            }
            System.out.println("ilosc nieudanych prob: "+iloscProb+ " błędne litery: ");
            System.out.println(wrongLetters);
            if (iloscProb >9) koniecProb = true;

        }
        if (!koniecProb) {
            System.out.println("brawo!!!");
        } else  {
            System.out.println("przegrałeś!!!");
        }
    }

}
