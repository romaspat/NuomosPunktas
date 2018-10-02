package nuomospunktas.business;

import nuomospunktas.kompiuteriai.Kompiuteris;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KompiuteriuPaieskaMapas {

    public List<Kompiuteris> ieskoti(List<Kompiuteris> kompiuteriai, Map<String, String> kriterijai) {
        boolean tipas;
        boolean pavadinimas;
        boolean dydis;
        boolean procesorius;
        boolean atmintis;
        boolean diskas;
        boolean os;
        boolean dienosKaina;
        boolean savaitesKaina;
        boolean isnuomavimoData;
        boolean grazinimoData;


        List<Kompiuteris> result = new ArrayList<>();

        for (Kompiuteris kompiuteris : kompiuteriai) {
            tipas = false;
            pavadinimas = false;
            dydis = false;
            procesorius = false;
            atmintis = false;
            diskas = false;
            os = false;
            dienosKaina = false;
            savaitesKaina = false;
            isnuomavimoData = false;
            grazinimoData = false;

            if (kriterijai.containsKey("tipas") && kriterijai.get("tipas") != null) {
                tipas = kompiuteris.getTipas().toLowerCase().contains(kriterijai.get("tipas").toLowerCase());
            } else {
                tipas = true;
            }

            if (kriterijai.containsKey("pavadinimas") && kriterijai.get("pavadinimas") != null) {
                pavadinimas = kompiuteris.getPavadinimas().toLowerCase().contains(kriterijai.get("pavadinimas").toLowerCase());
            } else {
                pavadinimas = true;
            }

            if (kriterijai.containsKey("dydis") && kriterijai.get("dydis") != null) {
                dydis = kompiuteris.getDydis().toLowerCase().contains(kriterijai.get("dydis").toLowerCase());
            } else {
                dydis = true;
            }

            if (kriterijai.containsKey("procesorius") && kriterijai.get("procesorius") != null) {
                procesorius = kompiuteris.getProcesorius().toLowerCase().contains(kriterijai.get("procesorius").toLowerCase());
            } else {
                procesorius = true;
            }

            if (kriterijai.containsKey("atmintis") && kriterijai.get("atmintis") != null) {
                atmintis = kompiuteris.getAtmintis().toLowerCase().contains(kriterijai.get("atmintis").toLowerCase());
            } else {
                atmintis = true;
            }

            if (kriterijai.containsKey("diskas") && kriterijai.get("diskas") != null) {
                diskas = kompiuteris.getDiskas().toLowerCase().contains(kriterijai.get("diskas").toLowerCase());
            } else {
                diskas = true;
            }

            if (kriterijai.containsKey("os") && kriterijai.get("os") != null) {
                os = kompiuteris.getOs().toLowerCase().contains(kriterijai.get("os").toLowerCase());
            } else {
                os = true;
            }

            if (kriterijai.containsKey("dienosKaina") && kriterijai.get("dienosKaina") != null) {
                dienosKaina = kompiuteris.getDienosKaina() <= Double.parseDouble(kriterijai.get("dienosKaina"));
            } else {
                dienosKaina = true;
            }

            if (kriterijai.containsKey("savaitesKaina") && kriterijai.get("savaitesKaina") != null) {
                savaitesKaina = kompiuteris.getSavaitesKaina() <= Double.parseDouble(kriterijai.get("savaitesKaina"));
            } else {
                savaitesKaina = true;
            }

            if (kriterijai.containsKey("isnuomavimoData") && kriterijai.get("isnuomavimoData") == null) {
                isnuomavimoData = true;
            }

            if (kriterijai.containsKey("grazinimoData") && kriterijai.get("grazinimoData") != null) {
                grazinimoData = kompiuteris.getGrazinimoData().isAfter(LocalDate.parse(kriterijai.get("grazinimoData")));
            } else {
                grazinimoData = true;
            }




            if (tipas && pavadinimas && dydis && procesorius && atmintis
                && diskas && os && dienosKaina && savaitesKaina && isnuomavimoData && grazinimoData) {
                result.add(kompiuteris);
            }

        }
        return result;
    }

}