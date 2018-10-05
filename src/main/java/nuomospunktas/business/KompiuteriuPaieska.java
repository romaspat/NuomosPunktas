package nuomospunktas.business;

import nuomospunktas.kompiuteriai.Kompiuteris;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class KompiuteriuPaieska {

    private Kompiuteris kompiuteris;

    public List<Kompiuteris> ieskoti(List<Kompiuteris> kompiuteriai, Map<String, String> kriterijai) {

        List<Kompiuteris> result = new ArrayList<>();
        boolean arYra;
        String paieskosFraze;

        for (Kompiuteris kompiuteris : kompiuteriai) {

            arYra = true;

            for (PaieskosKey value : PaieskosKey.values()) {
                paieskosFraze = kriterijai.get(value.toString());
                if (kriterijai.containsKey(value.toString()) && paieskosFraze!= null) {

                    switch (value) {
                        case tipas: {
                            arYra = arYra && kompiuteris.getTipas().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case pavadinimas: {
                            arYra = arYra && kompiuteris.getPavadinimas().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case dydis: {
                            arYra = arYra && kompiuteris.getDydis().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case procesorius: {
                            arYra = arYra && kompiuteris.getProcesorius().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case atmintis: {
                            arYra = arYra && kompiuteris.getAtmintis().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case diskas: {
                            arYra = arYra && kompiuteris.getDiskas().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case os: {
                            arYra = arYra && kompiuteris.getOs().toLowerCase().contains(paieskosFraze.toLowerCase());
                            break;
                        }
                        case dienosKaina: {
                            if (arSkaicius(paieskosFraze)) {
                                arYra = arYra && kompiuteris.getDienosKaina() <= Double.parseDouble(paieskosFraze);
                            }
                            break;
                        }
                        case savaitesKaina: {
                            if (arSkaicius(paieskosFraze)) {
                                arYra = arYra && kompiuteris.getSavaitesKaina() <= Double.parseDouble(paieskosFraze);
                            }
                            break;
                        }
                        case grazinimoData: {
                            if (arValidiData(paieskosFraze)) {
                                arYra = arYra && kompiuteris.getGrazinimoData().isBefore(LocalDate.parse(paieskosFraze));
                            }
                            break;
                        }
                        default: {
                            arYra = true;
                            break;
                        }
                    }
                }
            }
            if (arYra) {
                result.add(kompiuteris);
            }
        }
        return result;
    }

    private boolean arSkaicius(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean arValidiData(String str) {
        try {
            LocalDate.parse(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}