package nuomospunktas.kompiuteriai;

import java.time.LocalDate;

public class Kompiuteris {

    private int id;
    private String tipas;
    private String pavadinimas;
    private String dydis;
    private String procesorius;
    private String atmintis;
    private String diskas;
    private String os;
    private Double dienosKaina;
    private Double savaitesKaina;
    private LocalDate isnuomavimoData = null;
    private LocalDate grazinimoData = null;


    public int getId() {
        return id;
    }

    public String getTipas() {
        return tipas;
    }


    public String getPavadinimas() {
        return pavadinimas;
    }


    public String getDydis() {
        return dydis;
    }


    public String getProcesorius() {
        return procesorius;
    }


    public String getAtmintis() {
        return atmintis;
    }


    public String getDiskas() {
        return diskas;
    }


    public String getOs() {
        return os;
    }


    public Double getDienosKaina() {
        return dienosKaina;
    }


    public Double getSavaitesKaina() {
        return savaitesKaina;
    }


    public LocalDate getIsnuomavimoData() {
        return isnuomavimoData;
    }


    public LocalDate getGrazinimoData() {
        return grazinimoData;
    }

    public Kompiuteris setIsnuomavimoData(LocalDate isnuomavimoData) {
        this.isnuomavimoData = isnuomavimoData;
        return this;
    }

    public Kompiuteris setGrazinimoData(LocalDate grazinimoData) {
        this.grazinimoData = grazinimoData;
        return this;
    }

    public Kompiuteris setTipas(String tipas) {
        this.tipas = tipas;
        return this;
    }

    public Kompiuteris setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
        return this;
    }

    public Kompiuteris setDydis(String dydis) {
        this.dydis = dydis;
        return this;
    }

    public Kompiuteris setProcesorius(String procesorius) {
        this.procesorius = procesorius;
        return this;
    }

    public Kompiuteris setAtmintis(String atmintis) {
        this.atmintis = atmintis;
        return this;
    }

    public Kompiuteris setDiskas(String diskas) {
        this.diskas = diskas;
        return this;
    }

    public Kompiuteris setOs(String os) {
        this.os = os;
        return this;
    }

    public Kompiuteris setDienosKaina(double dienosKaina) {
        this.dienosKaina = dienosKaina;
        return this;
    }

    public Kompiuteris setSavaitesKaina(double savaitesKaina) {
        this.savaitesKaina = savaitesKaina;
        return this;
    }



    public Kompiuteris setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + tipas + " " + pavadinimas + " " + dydis + " " + procesorius + " " + atmintis + " "
                + diskas + " " + os + " " + dienosKaina + " " + savaitesKaina + " " + isnuomavimoData
                + " " + grazinimoData;
    }

    public String toHumanString() {
        String s;
        if (grazinimoData != null) {
            s = "IŠNUOMOTAS. Gražinimo data: " + grazinimoData;
        } else {
            s = "LAISVAS";
        }
        return "" + id + " " + tipas + " " + pavadinimas + " " + dydis + " " + procesorius + " " + atmintis + " "
                + diskas + " " + os + " " + dienosKaina + " Eur/dienai " + savaitesKaina + " Eur/savaitei " + s;
    }
}
