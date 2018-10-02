package nuomospunktas.business;

import nuomospunktas.kompiuteriai.KompiuterisImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KompiuteriuPaieska {

    private List<KompiuterisImpl> result = new ArrayList<>();
    private List<KompiuterisImpl> temp = new ArrayList<>();

    public KompiuteriuPaieska(List<KompiuterisImpl> result) {
        this.result = result;
    }

    public KompiuteriuPaieska visiKompiuteriai() {
        if (result.size() > 100) {
            throw new RuntimeException();
        }
        return this;
    }

    public KompiuteriuPaieska tikLaisvi() {
            if (result.size() > 0) {
                for (KompiuterisImpl kompiuteris : result) {
                    if (kompiuteris.getGrazinimoData() != null) {
                        if (kompiuteris.getGrazinimoData().isAfter(LocalDate.now())) {
                            temp.add(kompiuteris);
                        }
                    }
                }
                result.removeAll(temp);
                temp = new ArrayList<>();
            }
        return this;
    }

    public KompiuteriuPaieska tikIsnuomoti() {
        if (result.size() > 0) {
            for (KompiuterisImpl kompiuteris : result) {
                if (kompiuteris.getGrazinimoData() == null) {
                        temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
            temp = new ArrayList<>();
        }
        return this;
    }

    public KompiuteriuPaieska pagalPavadinima(String pavadinimas) {
        if (!pavadinimas.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getPavadinimas().toLowerCase().contains(pavadinimas.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalTipa(String tipas) {
        if (!tipas.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getTipas().toLowerCase().contains(tipas.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalDydi(String dydis) {
        if (!dydis.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getDydis().toLowerCase().contains(dydis.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalProcesoriu(String procesorius) {
        if (!procesorius.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getProcesorius().toLowerCase().contains(procesorius.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalAtminti(String atmintis) {
        if (!atmintis.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getAtmintis().toLowerCase().contains(atmintis.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalDiska(String diskas) {
        if (!diskas.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getDiskas().toLowerCase().contains(diskas.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska pagalOs(String os) {
        if (!os.isEmpty()) {
            for (KompiuterisImpl kompiuteris : result) {
                if (!kompiuteris.getOs().toLowerCase().contains(os.toLowerCase())) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska maziauNeiKainaDienai(Double dienosKaina) {
        if (dienosKaina > 0) {
            for (KompiuterisImpl kompiuteris : result) {
                if (kompiuteris.getDienosKaina() > dienosKaina) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska maziauNeiKainaSavaitei(Double savaitesKaina) {
        if (savaitesKaina > 0) {
            for (KompiuterisImpl kompiuteris : result) {
                if (kompiuteris.getDienosKaina() > savaitesKaina) {
                    temp.add(kompiuteris);
                }
            }
            result.removeAll(temp);
        }
        temp = new ArrayList<>();
        return this;
    }

    public KompiuteriuPaieska yraLaisviDatai(LocalDate data) {
        for (KompiuterisImpl kompiuteris : result) {
            if (kompiuteris.getGrazinimoData() != null && data.isAfter(kompiuteris.getGrazinimoData())) {
                temp.add(kompiuteris);
            }
        }
        result.removeAll(temp);
        temp = new ArrayList<>();
        return this;
    }

    public List<KompiuterisImpl> getResult() {
        return result;
    }

}
