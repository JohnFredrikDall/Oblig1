import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        assertEquals(true, false, "Implementer maks og denne testen");
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {

        //Alle permutasjoner av 4 tall
        int [][] perm = {
                {1, 2, 3, 4}, {2, 1, 3, 4}, {3, 1, 2, 4}, {1, 3, 2, 4}, {2, 3, 1, 4},
                {3, 2, 1, 4}, {3, 2, 4, 1}, {2, 3, 4, 1}, {4, 3, 2, 1}, {3, 4, 2, 1},
                {2, 4, 3, 1}, {4, 2, 3, 1}, {4, 1, 3, 2}, {1, 4, 3, 2}, {3, 4, 1, 2},
                {4, 3, 1, 2}, {1, 3, 4, 2}, {3, 1, 4, 2}, {2, 1, 4, 3}, {1, 2, 4, 3},
                {4, 2, 1, 3}, {2, 4, 1, 3}, {1, 4, 2, 3}, {4, 1, 2, 3}
        };

        int antByttinger = 0; //teller for antall bytter

        //Løkke går over alle permutasjonene og legger sammen antall bytter
        for (int[] ints : perm) {
            antByttinger += Oblig1.ombyttinger(ints);
        }
        //Finner snitt bytter for alle permutasjoner av 4 tall.
        double snitt = (double)antByttinger / (double)perm.length;

    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int[] d = {1, 1};
        int[] e = {1, 2, 3, 4, 5, 6, 7};
        int[] f = {1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7};

        System.out.println(Oblig1.antallUlikeSortert(d));
        System.out.println(Oblig1.antallUlikeSortert(e));
        System.out.println(Oblig1.antallUlikeSortert(f));

        //assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {
        assertEquals(true, false, "Implementer flett og denne testen");
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}