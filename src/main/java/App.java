import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {

        App app = new App();
        NuomosPunktas np = NuomosPunktas.getInstance();
        Sandelis sand = new Sandelis();


        np.isnuomotiKompiuteri(2, 10);
        np.isnuomotiKompiuteri(4, 15);
        np.isnuomotiKompiuteri(0, 1);

        System.out.println("-------------");
        List<Kompiuteris> tikIsnuomoti = np.grazintiSarasa(true);
        app.spausdintiSarasa(tikIsnuomoti);

        System.out.println("-------------");
        List<Kompiuteris> laisviDatai = np.grazintiLaisvusDatai(LocalDate.of(2018, 9, 25));
        app.spausdintiSarasa(laisviDatai);

        System.out.println("-------------");
        app.spausdintiSarasa(np.getNuomosSandelis().grazintiVisus());

    }

    public void spausdintiSarasa(List<Kompiuteris> sarasas) {
        for (Kompiuteris kompiuteris : sarasas) {
            System.out.println(kompiuteris.toString());
        }
    }

}
