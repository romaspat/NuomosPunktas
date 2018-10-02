import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;
import services.DataType;
import services.KompiuteriaiDAOServiceFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<KompiuterisImpl> {

    private IKompiuteriaiDAO<KompiuterisImpl> kompiuteriaiDAO =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.DEMO);

    private List<KompiuterisImpl> kompiuteriai = kompiuteriaiDAO.gautiVisus();

    @Override
    public List<KompiuterisImpl> parodytiLaisvus(boolean pozymis) {
        List<KompiuterisImpl> temp = new ArrayList<>();

        for (KompiuterisImpl kompiuterisImpl : kompiuteriai) {
            if (pozymis ^ (kompiuterisImpl.getGrazinimoData() != null)) {
                temp.add(kompiuterisImpl);
            }
        }
        return temp;
    }

    @Override
    public List<KompiuterisImpl> parodytiLaisvus(LocalDate data) {
        List<KompiuterisImpl> temp = new ArrayList<>();
        if (!kompiuteriaiDAO.gautiVisus().isEmpty()) {
            for (KompiuterisImpl kompiuteris : kompiuteriai) {
                if (kompiuteris.getGrazinimoData() != null && data.isAfter(kompiuteris.getGrazinimoData())) {
                    temp.add(kompiuteris);
                }
            }
            return temp;
        }
        return null;
    }

    @Override
    public void isnuomotiKompiuteri(int id, int terminas) {
        if (kompiuteriaiDAO.gautiVisus().size()> id && id>=0) {
            kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
            kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
        }
    }

    @Override
    public void grazintiKompiuteri(int id) {
        if (kompiuteriaiDAO.gautiVisus().size()>id&&id>=0) {
            kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(null);
            kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(null);
        }

    }

    IKompiuteriaiDAO<KompiuterisImpl> getKompiuteriaiDAO() {
        return kompiuteriaiDAO;
    }
}