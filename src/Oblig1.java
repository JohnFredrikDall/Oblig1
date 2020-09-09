import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static int maks(int [] a){

        //Sjekker først om tabellen har verdier eller ikke..
        //(1) operasjon for sammenlikning.
        if(a.length < 1){
            throw new NoSuchElementException("Listen er tom!");
        }

        //Deklarerer variabler for å definerer søkeområde i tabellen
        //(2) operasjoner for deklarasjonene begin = 0 og end = a.length-1
        int begin = 0;
        int end = a.length -1;

        //Løkken opprettes.
        //(1) operasjon setter i = begin.
        //i < end sammenliknes (n) ganger.
        //i++ utføres (n-1) ganger fordi den ikke utføres siste runde i løkken.
        for(int i = begin; i < end; i++){
            //Sammenlikningen a[i] > a[i+1] utføres (n-1) siden end = a.length-1.
            //Siden sammenlikningen består av to tabelloperasjoner og en sammenlikning
            //blir det totalt 3(n-1).
            if(a[i] > a[i+1]){
                //Hver gang a[i] > a[i+1] er sann utføres dette:
                int temp = a[i]; //1 sammenlikning + 1 tabelloperasjon = (2)
                a[i] = a[i + 1]; //1 sammenlikning + 2 tabelloperasjoner = (3)
                a[i + 1] = temp;//1 sammenlikning  + 1 tabelloperasjon = (2)
                //Total: (7x)
            }
        }
        //(1) tabelloperasjon
        return a[a.length - 1];

        //Algoritmen effektivitet kan da skrives som (2+5n+7x).

        //Når blir det flest ombyttinger?
        //Svar: Det blir flest ombyttinger (n-1) i lister der det største tallet kommer først i listen

        //Når blir det færrest?
        //Svar: Det blir færrest ombyttinger (0) i en liste der største tallet er bakerst i listen

    }

    public static int ombyttinger(int [] a){
        //Sjekker først om tabellen har verdier eller ikke..
        if(a.length < 1){
            throw new NoSuchElementException("Listen er tom!");
        }
        int byttinger = 0;
        int begin = 0;
        int end = a.length -1;

        for(int i = begin; i < end; i++){
            if(a[i] > a[i+1]){
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                byttinger++;
            }
        }
        return byttinger;
    }
    //Testingen av denne algoritmen gir et snitt på 1.9 byttinger for alle permutasjoner av 4
    //Hvis en ser på den tidligere maks() metoden var den (5n + x)
    //Sammenliknet med denne (2+5n+7x) blir gjennomsnitt antall operasjoner flere grunnet (2) og (7x) er større
    //Hvis vi kun ser på (5n) delen av begge algoritmene blir de like ettersom sammenlikningen skjer like mange ganger


    ///// Oppgave 2 //////////////////////////////////////
        public static boolean erSortert(int []a){
            for(int i = 1; i < a.length; i++){
                if(a[i-1] > a[i]){
                    return false;
                }
            }
            return true;
        }

    public static int antallUlikeSortert(int[] a) {
        if(a.length < 1){
            return 0;
        }
        if (erSortert(a)){ //Sjekker om listen er sortert
            int antall = 0; //Initialiserer teller
            for (int i = 0; i < a.length; i++) { //Løkke som løper gjennom array
                //While loop som sammenlikner [i] og [i+1]
                //Hvis hvis tallene er like hopper den videre og sjekker etter nye unike tall
                while (i < a.length - 1 && a[i] == a[i + 1]) {
                    i++;
                }
                antall++; //Teller opp unike instanser av tall
            }
            return antall; //Returnerer antall
        }
        else {
            throw new IllegalStateException("Tabellen er ikke sortert");
        }
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //Sjekker at lengden på arrayet er lengre enn null
        //Hvis ikke returner 0
        if(a.length < 1){
            return 0;
        }
        int antall = 0; //Teller for antall ganger et tall forekommer

        //Looper gjennom alle elementene
        for(int i = 0; i < a.length; i++){

            //Trekker ut et element og sammenlikner det med alle andre elementer i listen
            //Hvis elementet allerede er talt for, hopper det ut
            int j;
            for(j = 0; j < i; j++){
                if(a[i] == a[j]){
                    break;
                }
            }
            //Hvis ikke det allerede er talt, legger til i antall teller
            if(i == j) {
                antall++;
            }
        }
        return antall;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int end = a.length;
        int pointer = -1;
        int begin = 0;
        //Leser inn første verdi fra a[begin]
        //Hvis oddetall øker peker og bytter posisjon på a[begin] og a[pointer]
        //Hvis partall øker begin og itererer på nytt
        while (begin<end) {
            if(a[begin]% 2 != 0){
                pointer++;
                int temp = a[pointer];
                a[pointer] = a[begin];
                a[begin] = temp;
            }
            begin++;
        }

        //Sorterer fra indeks 0 til så mange plasser vi har flyttet partallene
        Arrays.sort(a, 0,pointer+1);
        //Sorterer fra så mange plasser vi har flyttet partallene til slutten av array
        Arrays.sort(a, pointer+1, a.length);
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        int j = -1;
        int i = 0;
        int end = a.length -1;

        if(a.length == 2){
            char temp = a[i+1];
            a[i+1] = a[i];
            a[i] = temp;
        }

        if(a.length > 2) {
            while (i < end - 1) {
                if (j < 0) {
                    char temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    j++;
                } else {
                    i++;
                    char temp = a[j];
                    a[j] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] a = new char [s.length() + t.length()];
        int j= 0;
        int k = 0;
        int l = 0;
        while(l < a.length){
            if(j < s.length()){
                a[l] = s.charAt(j);
                j++;
                l++;
            }
            if(k < t.length()){
                a[l] = t.charAt(k);
                k++;
                l++;
            }
        }
        return String.valueOf(a);
    }

    /// 7b)
    public static String flett(String... s) {
        int posInCharList = 0;
        int posInStringList = 0;
        int posInString = 0;
        int length = 0;
        for (String str: s) {
            length += str.length();
        }
        char[] a = new char [length];
        for(int i = posInCharList; i < length; i++){
            for(int j = posInStringList; j < s.length +1; j++){
                if(j == s.length){
                    j = 0;
                    posInString++;
                }
                if(posInString< s[j].length() && s[j].length() > 0){
                    a[i] = s[j].charAt(posInString);
                    i++;
                    if(i >= length){
                        break;
                    }
                }
                posInStringList++;
            }
        }

        return String.valueOf(a);
    }

}
