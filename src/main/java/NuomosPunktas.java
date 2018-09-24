import java.time.LocalDate;
import java.util.List;

public class NuomosPunktas {

    public static void main(String[] args) {

        NuomosPunktas np = new NuomosPunktas();
        Sandelis punktas = new Sandelis("Kompiuteriai nuomai");

        np.uzpildytiSandeli(punktas);
        np.isnuomotiKompiuteri(punktas.getSandelis().get(2), 5);
        np.isnuomotiKompiuteri(punktas.getSandelis().get(4), 15);
        np.isnuomotiKompiuteri(punktas.getSandelis().get(0), 1);

        System.out.println("-------------");
        List<Kompiuteris> tikIsnuomoti = punktas.grazintiSarasa(true);
        np.spausdintiSarasa(tikIsnuomoti);

        System.out.println("-------------");
        List<Kompiuteris> laisviDatai = punktas.grazintiLaisvusDatai(LocalDate.of(2018, 9, 25));
        np.spausdintiSarasa(laisviDatai);

        System.out.println("-------------");
        np.spausdintiSarasa(punktas.getSandelis());
        punktas.ismestiKompiuteri(2);
        System.out.println("-------------");
        np.spausdintiSarasa(punktas.getSandelis());

    }

    public void uzpildytiSandeli(Sandelis sandelis) {
        int i = 0;
        sandelis.pridetiKompiuteri(new PlansetinisKompiuteris("10\"", i++, "Samsung T580", "2Ghz",
                "2Gb", "16Gb", "Android", "15Eur/dienai"));
        sandelis.pridetiKompiuteri(new PlansetinisKompiuteris("7\"", i++, "Samsung T710", "2Ghz",
                "2Gb", "16Gb", "Android", "15Eur/dienai"));
        sandelis.pridetiKompiuteri(new NesiojamasKompiuteris("15\" touch", i++, "Lenovo Yoga 910", "i5-2Ghz",
                "8Gb", "256Gb SSD", "Windows 10", "20Eur/dienai"));
        sandelis.pridetiKompiuteri(new NesiojamasKompiuteris("15\"", i++, "HP Probook 450", "i5-2Ghz",
                "8Gb", "256Gb SSD", "Windows 10", "15Eur/dienai"));
        sandelis.pridetiKompiuteri(new StacionarusKompiuteris("SFF", i++, "Dell Optiplex 3010", "i5-2Ghz",
                "4Gb", "1000Gb", "Linux", "10Eur/dienai"));
    }

    public void isnuomotiKompiuteri(Kompiuteris kompiuteris, int terminas) {
        kompiuteris.setIsnuomota(true);
        kompiuteris.setIsnuomavimoData(LocalDate.now());
        kompiuteris.setGrazinimoData(LocalDate.now().plusDays(terminas));
    }

    public void grazintiKompiuteri(Kompiuteris kompiuteris) {
        kompiuteris.setIsnuomota(false);
        kompiuteris.setIsnuomavimoData(null);
        kompiuteris.setGrazinimoData(null);
    }

    public void spausdintiSarasa(List<Kompiuteris> sarasas) {
        for (Kompiuteris kompiuteris : sarasas) {
            System.out.println(kompiuteris.toString());
        }
    }
}
