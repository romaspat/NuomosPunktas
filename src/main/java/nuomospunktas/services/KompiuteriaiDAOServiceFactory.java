package nuomospunktas.services;

import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.KompiuterisImpl;

public class KompiuteriaiDAOServiceFactory {

    public IKompiuteriaiDAO<KompiuterisImpl> getInstance(DataType dataType) {

        switch (dataType) {
            case DEMO:
                return new KompiuteriaiDAODemoService();
            case JSON:
                return new KompiuteriaiJsonDAOService();
            default:
                return null;
        }
    }
}
