package nuomospunktas;

import nuomospunktas.business.KompiuteriuPaieskaMapas;
import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.DataType;
import nuomospunktas.services.KompiuteriaiDAOServiceFactory;
import nuomospunktas.services.KompiuteriaiJsonDAOService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class NuomosPunktas implements NuomosOperacijos<Kompiuteris> {

    private IKompiuteriaiDAO<Kompiuteris> kompiuteriaiDAO =
            new KompiuteriaiDAOServiceFactory().getInstance(DataType.JSON);

    private KompiuteriuPaieskaMapas paieska= new KompiuteriuPaieskaMapas();


    public List<Kompiuteris> ieskotiKompiuteriu(Map<String, String> kriterijai) {
        try {

            return paieska.ieskoti(kompiuteriaiDAO.gautiVisus(), kriterijai);

        } catch (Exception e) {
            System.out.println("Paieška nepavyko");
        }
        return null;
    }

    @Override
    public void isnuomotiKompiuteri(int id, int terminas) {
        if (!kompiuteriaiDAO.gautiVisus().isEmpty()) {
            if (kompiuteriaiDAO.gautiVisus().size() > id && id >= 0) {
                kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
                kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
            }
            if (kompiuteriaiDAO instanceof KompiuteriaiJsonDAOService) {
                ((KompiuteriaiJsonDAOService) kompiuteriaiDAO).atnaujintiSarasa();
            }
        }
    }

    @Override
    public void grazintiKompiuteri(int id) {
        if (!kompiuteriaiDAO.gautiVisus().isEmpty()) {
            if (kompiuteriaiDAO.gautiVisus().size() > id && id >= 0) {
                kompiuteriaiDAO.gautiVisus().get(id).setIsnuomavimoData(null);
                kompiuteriaiDAO.gautiVisus().get(id).setGrazinimoData(null);
            }

            if (kompiuteriaiDAO instanceof KompiuteriaiJsonDAOService) {
                ((KompiuteriaiJsonDAOService) kompiuteriaiDAO).atnaujintiSarasa();
            }
        }

    }

    public IKompiuteriaiDAO<Kompiuteris> getKompiuteriaiDAO() {
        return kompiuteriaiDAO;
    }

}