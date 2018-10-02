package nuomospunktas;

import nuomospunktas.business.KompiuteriuPaieska;
import nuomospunktas.kompiuteriai.Kompiuteris;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        App app = new App();
        NuomosPunktas np = new NuomosPunktas();
        KompiuteriuPaieska paieska = new KompiuteriuPaieska(np.getKompiuteriaiDAO().gautiVisus());





        np.isnuomotiKompiuteri(2, 10);
        np.isnuomotiKompiuteri(4, 15);
        np.isnuomotiKompiuteri(0, 1);

        System.out.println("-------------");
        //List<Kompiuteris> visi = new ArrayList<>();
        List<Kompiuteris> result = new ArrayList<>();
        // visi = np.getKompiuteriaiDAO().gautiVisus();

        result = paieska.tikIsnuomoti().pagalPavadinima("n").getResult();
        app.spausdintiSarasa(result);

//        System.out.println("-------------");
//        List<Kompiuteris> laisviDatai = np.parodytiLaisvus(LocalDate.of(2018, 10, 2));
//        app.spausdintiSarasa(laisviDatai);
//
//        System.out.println("-------------");
//        app.spausdintiSarasa(np.getKompiuteriaiDAO().gautiVisus());


    }

    private void spausdintiSarasa(List<Kompiuteris> sarasas) {
        for (Kompiuteris kompiuterisImpl : sarasas) {
            System.out.println(kompiuterisImpl.toString());
        }
    }

}
