import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<Kompiuteris> {

    private Sandelis nuomosSandelis;

    private static NuomosPunktas instance = null;

    private NuomosPunktas() {
        nuomosSandelis = new Sandelis();
    }

    @Override
    public List<Kompiuteris> grazintiSarasa(boolean pozymis) {
        List<Kompiuteris> temp = new ArrayList<>();

        for (Kompiuteris kompiuteris : nuomosSandelis.grazintiVisus()) {
            if (kompiuteris.isIsnuomota() == pozymis) {
                temp.add(kompiuteris);
            }
        }
        return temp;
    }

    @Override
    public List<Kompiuteris> grazintiLaisvusDatai(LocalDate data) {
        List<Kompiuteris> temp = new ArrayList<>();

        for (Kompiuteris kompiuteris : nuomosSandelis.grazintiVisus()) {
            if (kompiuteris.isIsnuomota()) {
                if (data.isAfter(kompiuteris.getGrazinimoData())) {
                    temp.add(kompiuteris);
                }
            } else {
                temp.add(kompiuteris);
            }
        }
        return temp;
    }

    @Override
    public void isnuomotiKompiuteri(int id, int terminas) {
        nuomosSandelis.grazintiVisus().get(id).setIsnuomota(true);
        nuomosSandelis.grazintiVisus().get(id).setIsnuomavimoData(LocalDate.now());
        nuomosSandelis.grazintiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
    }

    @Override
    public void grazintiKompiuteri(int id) {
        nuomosSandelis.grazintiVisus().get(id).setIsnuomota(false);
        nuomosSandelis.grazintiVisus().get(id).setIsnuomavimoData(null);
        nuomosSandelis.grazintiVisus().get(id).setGrazinimoData(null);
    }

    public Sandelis getNuomosSandelis() {
        return nuomosSandelis;
    }

    public static NuomosPunktas getInstance(){
        if (instance == null) {
           instance = new NuomosPunktas();
        }
        return instance;
    }
}
