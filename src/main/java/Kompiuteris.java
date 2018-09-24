import java.time.LocalDate;

public abstract class Kompiuteris {

    private int id;
    private String pavadinimas;
    private String procesorius;
    private String atmintis;
    private String diskas;
    private String os;
    private String kaina;

    private boolean isnuomota;
    private LocalDate isnuomavimoData;
    private LocalDate grazinimoData;

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getProcesorius() {
        return procesorius;
    }

    public String getAtmintis() {
        return atmintis;
    }

    public void setAtmintis(String atmintis) {
        this.atmintis = atmintis;
    }

    public String getDiskas() {
        return diskas;
    }

    public void setDiskas(String diskas) {
        this.diskas = diskas;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getKaina() {
        return kaina;
    }

    public void setKaina(String kaina) {
        this.kaina = kaina;
    }

    public boolean isIsnuomota() {
        return isnuomota;
    }

    public void setIsnuomota(boolean isnuomota) {
        this.isnuomota = isnuomota;
    }

    public LocalDate getIsnuomavimoData() {
        return isnuomavimoData;
    }

    public void setIsnuomavimoData(LocalDate isnuomavimoData) {
        this.isnuomavimoData = isnuomavimoData;
    }

    public LocalDate getGrazinimoData() {
        return grazinimoData;
    }

    public void setGrazinimoData(LocalDate grazinimoData) {
        this.grazinimoData = grazinimoData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public void setProcesorius(String procesorius) {
        this.procesorius = procesorius;
    }

    @Override
    public String toString() {
        String s = "";
        if (isnuomota) {
            s = "IŠNUOMOTAS. Gražinimo data: " + grazinimoData;
        } else {
            s = "LAISVAS";
        }
        return "" + pavadinimas + " " + procesorius + " " + atmintis + " " + diskas + " " + os + " " + kaina + " " + s;
    }
}
