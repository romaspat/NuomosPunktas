package nuomospunktas.services;

import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier(value = "kompiuteriaiDemo")
public class KompiuteriaiDAODemoService implements IKompiuteriaiDAO<Kompiuteris> {

    private List<Kompiuteris> kompiuteriai;
    {
        kompiuteriai = new ArrayList<>();
        kompiuteriai.add(new Kompiuteris().setId(gautiId()).setTipas("Plansetinis").setPavadinimas("Samsung T580").
                setDydis("10\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("16Gb").setOs("Android").
                setDienosKaina(15).setSavaitesKaina(60));
        kompiuteriai.add(new Kompiuteris().setId(gautiId()).setTipas("Plansetinis").setPavadinimas("Samsung T710").
                setDydis("7\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("32Gb").setOs("Android").
                setDienosKaina(10).setSavaitesKaina(50));
        kompiuteriai.add(new Kompiuteris().setId(gautiId()).setTipas("Nesiojamas").setPavadinimas("Lenovo Yoga 910").
                setDydis("13\"").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("512Gb").setOs("Windows 10").
                setDienosKaina(20).setSavaitesKaina(50));
        kompiuteriai.add(new Kompiuteris().setId(gautiId()).setTipas("Nesiojamas").setPavadinimas("HP Probook 450").
                setDydis("15\"").setProcesorius("2Ghz").setAtmintis("4Gb").setDiskas("256Gb").setOs("Linux").
                setDienosKaina(15).setSavaitesKaina(60));
        kompiuteriai.add(new Kompiuteris().setId(gautiId()).setTipas("Stacionarus").setPavadinimas("Dell Optiplex 3010").
                setDydis("SFF").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("1024Gb").setOs("Windows").
                setDienosKaina(10).setSavaitesKaina(50));
    }

    @Override
    public Kompiuteris gautiPagalId(int id) {
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                return kompiuteris;
            }
        }
        return null;
    }

    @Override
    public void pridetiKompiuteri(Kompiuteris kompiuteris) {
        kompiuteris.setId(gautiId());
        kompiuteriai.add(kompiuteris);
    }

    @Override
    public void ismestiKompiuteri(int id) {
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                kompiuteriai.remove(kompiuteris);
                return;
            }
        }
        kompiuteriai.remove(id);
    }

    @Override
    public List<Kompiuteris> gautiVisus() {
        return kompiuteriai;
    }

    @Override
    public void isnuomotiKompiuteri(Integer id, Integer terminas){
        if (!kompiuteriai.isEmpty()) {
            if (kompiuteriai.size() > id && id >= 0) {
                kompiuteriai.get(id).setIsnuomavimoData(LocalDate.now());
                kompiuteriai.get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
            }
        }
    }

    @Override
    public void grazintiKompiuteri(Integer id){
        if (!kompiuteriai.isEmpty()) {
            if (kompiuteriai.size() > id && id >= 0) {
                kompiuteriai.get(id).setIsnuomavimoData(null);
                kompiuteriai.get(id).setGrazinimoData(null);
            }
        }
    }

    private int gautiId() {

        int max = 0;

        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (max < kompiuteris.getId()) {
                max = kompiuteris.getId();
            }
        }
        return ++max;
    }

}
