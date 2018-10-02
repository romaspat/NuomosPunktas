package nuomospunktas;

import nuomospunktas.business.KompiuteriuPaieska;
import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.DataType;
import nuomospunktas.services.KompiuteriaiDAOServiceFactory;

import java.time.LocalDate;
import java.util.List;

public class NuomosPunktas implements NuomosOperacijos<Kompiuteris> {

    private IKompiuteriaiDAO<Kompiuteris> kompiuteriaiDAO =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.DEMO);



    private KompiuteriuPaieska kompiuteriuPaieska = new KompiuteriuPaieska(kompiuteriaiDAO.gautiVisus());

    public List<Kompiuteris> ieskotiKompiuteriu() {
        try {
            return kompiuteriuPaieska.visiKompiuteriai().getResult();
        } catch (RuntimeException e) {
            System.out.println("Exception occurred");
        }
        return null;
    }

    public List<Kompiuteris> ieskotiKompiuteriu(boolean laisvi) {
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

    IKompiuteriaiDAO<Kompiuteris> getKompiuteriaiDAO() {
        return kompiuteriaiDAO;
    }
}