import business.KompiuteriuPaieska;
import kompiuteriai.KompiuterisImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        App app = new App();
        NuomosPunktas np = new NuomosPunktas();

        KompiuteriuPaieska paieska = new KompiuteriuPaieska();


        np.isnuomotiKompiuteri(2, 10);
        np.isnuomotiKompiuteri(4, 15);
        np.isnuomotiKompiuteri(0, 1);

        System.out.println("-------------");
        List<KompiuterisImpl> result = new ArrayList<>();
        result = np.getKompiuteriaiDAO().gautiVisus();

        result = paieska.yraLaisvi(result, true).maziauNeiKainaDienai(result, 20.0).
                pagalDiska(result, "256").getResult();
        app.spausdintiSarasa(result);

//        System.out.println("-------------");
//        List<KompiuterisImpl> laisviDatai = np.parodytiLaisvus(LocalDate.of(2018, 10, 2));
//        app.spausdintiSarasa(laisviDatai);
//
//        System.out.println("-------------");
//        app.spausdintiSarasa(np.getKompiuteriaiDAO().gautiVisus());



    }

    private void spausdintiSarasa(List<KompiuterisImpl> sarasas) {
        for (KompiuterisImpl kompiuterisImpl : sarasas) {
            System.out.println(kompiuterisImpl.toString());
        }
    }

}
