import java.time.LocalDate;

public class StacionarusKompiuteris extends Kompiuteris {

    private String korpusas;

    public StacionarusKompiuteris(){

    }

    public StacionarusKompiuteris(String korpusas,int id, String pavadinimas, String procesorius,
                                  String atmintis, String diskas, String os, String kaina) {
        this.korpusas = korpusas;
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

    public String getKorpusas() {
        return korpusas;
    }

    @Override
    public String toString(){
        return "ID: "+super.getId()+" "+korpusas+" "+super.toString();
    }

    public void setKorpusas(String korpusas) {
        this.korpusas = korpusas;
    }
}
