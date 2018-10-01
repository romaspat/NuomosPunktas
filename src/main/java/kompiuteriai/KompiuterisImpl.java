package kompiuteriai;

import java.time.LocalDate;

public abstract class KompiuterisImpl implements IKompiuteris {

    private int id;
    private String pavadinimas;
    private String dydis;
    private String procesorius;
    private String atmintis;
    private String diskas;
    private String os;
    private Double dienosKaina;
    private Double savaitesKaina;
    private LocalDate isnuomavimoData=null;
    private LocalDate grazinimoData=null;

    @Override
    public int getId() {
        return id;
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

    public KompiuterisImpl setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
        return this;
    }

    public KompiuterisImpl setDydis(String dydis) {
        this.dydis = dydis;
        return this;
    }

    public KompiuterisImpl setProcesorius(String procesorius) {
        this.procesorius = procesorius;
        return this;
    }

    public KompiuterisImpl setAtmintis(String atmintis) {
        this.atmintis = atmintis;
        return this;
    }

    public KompiuterisImpl setDiskas(String diskas) {
        this.diskas = diskas;
        return this;
    }

    public KompiuterisImpl setOs(String os) {
        this.os = os;
        return this;
    }

    public KompiuterisImpl setDienosKaina(double dienosKaina) {
        this.dienosKaina = dienosKaina;
        return this;
    }

    public KompiuterisImpl setSavaitesKaina(double savaitesKaina) {
        this.savaitesKaina = savaitesKaina;
        return this;
    }


    @Override
    public KompiuterisImpl setId(int id) {
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
        return "" + id + " " + pavadinimas + " " + dydis + " " + procesorius + " " + atmintis + " " + diskas + " " + os +
                " " + dienosKaina + " Eur/dienai " + savaitesKaina + " Eur/savaitei " + s;
    }
}
