import java.time.LocalDate;

public class NesiojamasKompiuteris extends Kompiuteris {

    private String ekranas;

    public NesiojamasKompiuteris(String ekranas, int id, String pavadinimas, String procesorius,
                                 String atmintis, String diskas, String os, String kaina) {
        this.ekranas = ekranas;
        this.setId(id);
        this.setPavadinimas(pavadinimas);
        this.setProcesorius(procesorius);
        this.setAtmintis(atmintis);
        this.setDiskas(diskas);
        this.setOs(os);
        this.setKaina(kaina);
        this.setIsnuomota(false);
        this.setIsnuomavimoData(null);
        this.setGrazinimoData(null);
    }

    public void setEkranas(String ekranas) {
        this.ekranas = ekranas;
    }

    @Override
    public String toString(){
        return "ID: "+super.getId()+" "+ekranas+" "+super.toString();
    }
}
