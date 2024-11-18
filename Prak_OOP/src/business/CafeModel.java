package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CafeModel {
    private Cafe cafe;

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public void leseAusDatei(String typ) throws IOException {
        if ("csv".equals(typ)) {
            try (BufferedReader ein = new BufferedReader(new FileReader("Cafe.csv"))) {
                String[] zeile = ein.readLine().split(";");
                this.cafe = new Cafe(zeile[0], zeile[1], zeile[2], 
                                     Boolean.parseBoolean(zeile[3]), zeile[4].split("_"));
            }
        } else {
            throw new UnsupportedOperationException("Dateityp nicht unterstützt.");
        }
    }

    public void schreibeCafeInCsvDatei() throws IOException {
        if (this.cafe != null) {
            try (BufferedWriter aus = new BufferedWriter(new FileWriter("CafeAusgabe.csv", true))) {
                aus.write(cafe.gibCafeZurueck(';'));
            }
        } else {
            throw new IllegalStateException("Kein Cafe gespeichert.");
        }
    }
}
