package nuomospunktas.services;

import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class KompiuteriaiDAOFactSpr {

    @Value("${dataType:demo}")
    private String dataType;

    @Autowired
    @Qualifier(value = "kompiuteriaiDemo")
    private KompiuteriaiDAODemoService kompiuteriaiDemo;

    @Autowired
    @Qualifier(value = "kompiuteriaiJson")
    private KompiuteriaiJsonDAOService kompiuteriaiStorage;


    public IKompiuteriaiDAO<Kompiuteris> getInstance() {

        switch (dataType) {
            case "demo":
                return kompiuteriaiDemo;
            case "json":
                return kompiuteriaiStorage;
            default:
                throw new RuntimeException();
        }
    }
}
