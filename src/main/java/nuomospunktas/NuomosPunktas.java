package nuomospunktas;

import nuomospunktas.business.KompiuteriuPaieska;
import nuomospunktas.business.KompiuteriuPaieskaMapas;
import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.DataType;
import nuomospunktas.services.KompiuteriaiDAOServiceFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class NuomosPunktas implements NuomosOperacijos<Kompiuteris> {

    private IKompiuteriaiDAO<Kompiuteris> kompiuteriaiDAO =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.DEMO);

    KompiuteriuPaieskaMapas paieska = new KompiuteriuPaieskaMapas();

    public List<Kompiuteris> ieskotiKompiuteriu(Map<String,String> kriterijai) {
        try {

            return paieska.ieskoti(kompiuteriaiDAO.gautiVisus(), kriterijai);

        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
        return null;
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