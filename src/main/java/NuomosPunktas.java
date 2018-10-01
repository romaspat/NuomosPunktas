import kompiuteriai.KompiuterisImpl;
import services.KompiuteriaiDAOImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<KompiuterisImpl> {

    private KompiuteriaiDAOImpl nuomosKompiuteriaiDAOImpl = new KompiuteriaiDAOImpl();


    @Override
    public List<KompiuterisImpl> parodytiSarasa(boolean pozymis) {
        List<KompiuterisImpl> temp = new ArrayList<>();

        for (KompiuterisImpl kompiuterisImpl : nuomosKompiuteriaiDAOImpl.gautiVisus()) {
            if (pozymis ^= (kompiuterisImpl.getGrazinimoData() != null)) {
                temp.add(kompiuterisImpl);
            }
        }
        return temp;
    }

    @Override
    public List<KompiuterisImpl> parodytiLaisvusDatai(LocalDate data) {
        List<KompiuterisImpl> temp = new ArrayList<>();
        if (!nuomosKompiuteriaiDAOImpl.gautiVisus().isEmpty()) {
            for (KompiuterisImpl kompiuteris : nuomosKompiuteriaiDAOImpl.gautiVisus()) {
                if (kompiuteris.getGrazinimoData()!=null && data.isAfter(kompiuteris.getGrazinimoData())) {
                    temp.add(kompiuteris);
                }
            }
            return temp;
        }
        return null;
    }

    @Override
    public void isnuomotiKompiuteri(int id, int terminas) {
        nuomosKompiuteriaiDAOImpl.gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
        nuomosKompiuteriaiDAOImpl.gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
    }

    @Override
    public void grazintiKompiuteri(int id) {
        nuomosKompiuteriaiDAOImpl.gautiVisus().get(id).setIsnuomavimoData(null);
        nuomosKompiuteriaiDAOImpl.gautiVisus().get(id).setGrazinimoData(null);
    }

    KompiuteriaiDAOImpl getNuomosKompiuteriaiDAOImpl() {
        return nuomosKompiuteriaiDAOImpl;
    }
}