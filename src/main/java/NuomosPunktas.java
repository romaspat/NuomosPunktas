import business.KompiuteriuPaieska;
import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;
import services.DataType;
import services.KompiuteriaiDAOServiceFactory;

import java.time.LocalDate;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<KompiuterisImpl> {

    private IKompiuteriaiDAO<KompiuterisImpl> kompiuteriaiDAO =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.DEMO);

    private KompiuteriuPaieska kompiuteriuPaieska = new KompiuteriuPaieska(kompiuteriaiDAO.gautiVisus());

    public List<KompiuterisImpl> ieskotiKompiuteriu() {
        try {
            return kompiuteriuPaieska.visiKompiuteriai().getResult();
        } catch (RuntimeException e) {
            System.out.println("Exception occurred");
        }
        return null;
    }

    public List<KompiuterisImpl> ieskotiKompiuteriu(boolean laisvi) {
        if (laisvi) {
            return kompiuteriuPaieska.tikLaisvi().getResult();
        } else {
            return kompiuteriuPaieska.tikIsnuomoti().getResult();
        }
    }





    @Override
    public void isnuomotiKompiuteri(int id, int terminas) {
        if (kompiuteriaiDAO.gautiVisus().size() > id && id >= 0) {
            kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
            kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
        }
    }

    @Override
    public void grazintiKompiuteri(int id) {
        if (kompiuteriaiDAO.gautiVisus().size() > id && id >= 0) {
            kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(null);
            kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(null);
        }

    }

    IKompiuteriaiDAO<KompiuterisImpl> getKompiuteriaiDAO() {
        return kompiuteriaiDAO;
    }
}