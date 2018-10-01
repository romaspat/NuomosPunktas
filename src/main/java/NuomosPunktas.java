import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;
import services.DataType;
import services.KompiuteriaiDAODemoService;
import services.KompiuteriaiDAOServiceFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<KompiuterisImpl> {

    private IKompiuteriaiDAO<KompiuterisImpl> dAOService =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.DEMO);


    @Override
    public List<KompiuterisImpl> parodytiSarasa(boolean pozymis) {
        List<KompiuterisImpl> temp = new ArrayList<>();

        for (KompiuterisImpl kompiuterisImpl : dAOService.gautiVisus()) {
            if (pozymis ^= (kompiuterisImpl.getGrazinimoData() != null)) {
                temp.add(kompiuterisImpl);
            }
        }
        return temp;
    }

    @Override
    public List<KompiuterisImpl> parodytiLaisvusDatai(LocalDate data) {
        List<KompiuterisImpl> temp = new ArrayList<>();
        if (!dAOService.gautiVisus().isEmpty()) {
            for (KompiuterisImpl kompiuteris : dAOService.gautiVisus()) {
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
        dAOService.gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
        dAOService.gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
    }

    @Override
    public void grazintiKompiuteri(int id) {
        dAOService.gautiVisus().get(id).setIsnuomavimoData(null);
        dAOService.gautiVisus().get(id).setGrazinimoData(null);
    }

    IKompiuteriaiDAO<KompiuterisImpl> getdAOService() {
        return dAOService;
    }
}