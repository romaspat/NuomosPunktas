package nuomospunktas.kompiuteriai;

import java.time.LocalDate;

public abstract class Kompiuteris implements IKompiuteris {

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

    @Override
    public int getId() {
        return id;
    }

    public String getTipas() {
        return tipas;
    }

    @Override
    public String getPavadinimas() {
        return pavadinimas;
    }

    @Override
    public String getDydis() {
        return dydis;
    }

    @Override
    public String getProcesorius() {
        return procesorius;
    }

    @Override
    public String getAtmintis() {
        return atmintis;
    }

    @Override
    public String getDiskas() {
        return diskas;
    }

    @Override
    public String getOs() {
        return os;
    }

    @Override
    public Double getDienosKaina() {
        return dienosKaina;
    }

    @Override
    public Double getSavaitesKaina() {
        return savaitesKaina;
    }

    @Override
    public LocalDate getIsnuomavimoData() {
        return isnuomavimoData;
    }

    @Override
    public LocalDate getGrazinimoData() {
        return grazinimoData;
    }

    public void setIsnuomavimoData(LocalDate isnuomavimoData) {
        this.isnuomavimoData = isnuomavimoData;
    }

    public void setGrazinimoData(LocalDate grazinimoData) {
        this.grazinimoData = grazinimoData;
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


    @Override
    public Kompiuteris setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
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
