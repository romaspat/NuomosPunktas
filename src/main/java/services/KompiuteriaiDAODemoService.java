package services;

import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;
import kompiuteriai.NesiojamasKompiuteris;
import kompiuteriai.PlansetinisKompiuteris;
import kompiuteriai.StacionarusKompiuteris;

import java.util.ArrayList;
import java.util.List;

public class KompiuteriaiDAODemoService implements IKompiuteriaiDAO<KompiuterisImpl> {

    private List<KompiuterisImpl> kompiuteriai;
    {
        kompiuteriai = new ArrayList<>();
        kompiuteriai.add(new PlansetinisKompiuteris().setId(gautiId()).setTipas("PK").setPavadinimas("Samsung T580").
                setDydis("10\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("16Gb").setOs("Android").
                setDienosKaina(15).setSavaitesKaina(60));
        kompiuteriai.add(new PlansetinisKompiuteris().setId(gautiId()).setTipas("PK").setPavadinimas("Samsung T710").
                setDydis("7\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("32Gb").setOs("Android").
                setDienosKaina(10).setSavaitesKaina(50));
        kompiuteriai.add(new NesiojamasKompiuteris().setId(gautiId()).setTipas("NK").setPavadinimas("Lenovo Yoga 910").
                setDydis("13\"").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("512Gb").setOs("Windows 10").
                setDienosKaina(20).setSavaitesKaina(50));
        kompiuteriai.add(new NesiojamasKompiuteris().setId(gautiId()).setTipas("NK").setPavadinimas("HP Probook 450").
                setDydis("15\"").setProcesorius("2Ghz").setAtmintis("4Gb").setDiskas("256Gb").setOs("Linux").
                setDienosKaina(15).setSavaitesKaina(60));
        kompiuteriai.add(new StacionarusKompiuteris().setId(gautiId()).setTipas("SK").setPavadinimas("Dell Optiplex 3010").
                setDydis("SFF").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("1024Gb").setOs("Windows").
                setDienosKaina(10).setSavaitesKaina(50));
    }

    @Override
    public KompiuterisImpl gautiPagalId(int id) {
        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                return kompiuteris;
            }
        }
        return null;
    }

    @Override
    public void pridetiKompiuteri(KompiuterisImpl kompiuteris) {
        kompiuteris.setId(gautiId());
        kompiuteriai.add(kompiuteris);
    }

    @Override
    public void ismestiKompiuteri(int id) {
        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                kompiuteriai.remove(kompiuteris);
                return;
            }
        }
        kompiuteriai.remove(id);
    }

    @Override
    public List<KompiuterisImpl> gautiVisus() {
        return kompiuteriai;
    }

    private int gautiId() {

        int max = 0;

        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (max < kompiuteris.getId()) {
                max = kompiuteris.getId();
            }
        }
        return ++max;
    }
}
