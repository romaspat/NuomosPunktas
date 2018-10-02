package business;

import kompiuteriai.KompiuterisImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KompiuteriuPaieska {

    private List<KompiuterisImpl> result = new ArrayList<>();

    public KompiuteriuPaieska yraLaisvi(List<KompiuterisImpl> kompiuteriai, Boolean arLaisvi) {
        if (arLaisvi != null) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (arLaisvi) {
                    if (kompiuteris.getGrazinimoData() != null) {
                        if (!result.contains(kompiuteris)) {
                            result.add(kompiuteris);
                        }
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalPavadinima(List<KompiuterisImpl> kompiuteriai, String pavadinimas) {
        if (!pavadinimas.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getPavadinimas().toLowerCase().contains(pavadinimas.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalDydi(List<KompiuterisImpl> kompiuteriai, String dydis) {
        if (!dydis.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getDydis().toLowerCase().contains(dydis.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalProcesoriu(List<KompiuterisImpl> kompiuteriai, String procesorius) {
        if (!procesorius.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getProcesorius().toLowerCase().contains(procesorius.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalAtminti(List<KompiuterisImpl> kompiuteriai, String atmintis) {
        if (!atmintis.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getAtmintis().toLowerCase().contains(atmintis.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalDiska(List<KompiuterisImpl> kompiuteriai, String diskas) {
        if (!diskas.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getDiskas().toLowerCase().contains(diskas.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska pagalOs(List<KompiuterisImpl> kompiuteriai, String os) {
        if (!os.isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getOs().toLowerCase().contains(os.toLowerCase())) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska maziauNeiKainaDienai(List<KompiuterisImpl> kompiuteriai, Double dienosKaina) {
        if (dienosKaina > 0) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getDienosKaina() < dienosKaina) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska maziauNeiKainaSavaitei(List<KompiuterisImpl> kompiuteriai, Double savaitesKaina) {
        if (savaitesKaina > 0) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getDienosKaina() < savaitesKaina) {
                    if (!result.contains(kompiuteris)) {
                        result.add(kompiuteris);
                    }
                }
            }
        }
        return this;
    }

    public KompiuteriuPaieska yraLaisviDatai(List<KompiuterisImpl> kompiuteriai, LocalDate data) {
        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (kompiuteris.getGrazinimoData() != null && data.isAfter(kompiuteris.getGrazinimoData())) {
                if (!result.contains(kompiuteris)) {
                    result.add(kompiuteris);
                }
            }
        }
        return this;
    }

    public List<KompiuterisImpl> getResult() {
        return result;
    }

}
