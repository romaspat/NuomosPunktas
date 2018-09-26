import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sandelis implements IOSandeliui<Kompiuteris> {

    private List<Kompiuteris> kompiuteriai;

    Sandelis() {
        kompiuteriai = new ArrayList<>();
        kompiuteriai.add(new PlansetinisKompiuteris("10\"", 1, "Samsung T580", "2Ghz",
                "2Gb", "16Gb", "Android", "15Eur/dienai"));
        kompiuteriai.add(new PlansetinisKompiuteris("7\"", 2, "Samsung T710", "2Ghz",
                "2Gb", "16Gb", "Android", "15Eur/dienai"));
        kompiuteriai.add(new NesiojamasKompiuteris("15\" touch", 3, "Lenovo Yoga 910", "i5-2Ghz",
                "8Gb", "256Gb SSD", "Windows 10", "20Eur/dienai"));
        kompiuteriai.add(new NesiojamasKompiuteris("15\"", 4, "HP Probook 450", "i5-2Ghz",
                "8Gb", "256Gb SSD", "Windows 10", "15Eur/dienai"));
        kompiuteriai.add(new StacionarusKompiuteris("SFF", 5, "Dell Optiplex 3010", "i5-2Ghz",
                "4Gb", "1000Gb", "Linux", "10Eur/dienai"));

    }

    @Override
    public void pridetiKompiuteri(Kompiuteris kompiuteris) {
        kompiuteriai.add(kompiuteris);
    }

    @Override
    public void ismestiKompiuteri(Kompiuteris kompiuteris) {
        kompiuteriai.remove(kompiuteris);
    }

    @Override
    public List<Kompiuteris> grazintiVisus() {
        return kompiuteriai;
    }

}
