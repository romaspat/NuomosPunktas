package nuomospunktas;

import nuomospunktas.kompiuteriai.Kompiuteris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        App app = new App();
        NuomosPunktas np = new NuomosPunktas();
        // KompiuteriuPaieska paieska = new KompiuteriuPaieska(np.getKompiuteriaiDAO().gautiVisus());
        //app.spausdintiSarasa(np.getKompiuteriaiDAO().gautiVisus());

        np.isnuomotiKompiuteri(2, 10);
        np.isnuomotiKompiuteri(4, 15);
        np.isnuomotiKompiuteri(0, 1);

        np.grazintiKompiuteri(0);
        np.grazintiKompiuteri(4);
        np.grazintiKompiuteri(2);

        System.out.println("-------------");
        //List<Kompiuteris> visi = new ArrayList<>();
        List<Kompiuteris> result = new ArrayList<>();
        // visi = np.getKompiuteriaiDAO().gautiVisus();

        Map<String, String> kriterijai = new HashMap<>();
//        kriterijai.put("pavadinimas", "sams");
//        kriterijai.put("tipas", "nes");
        kriterijai.put("grazinimoData", "2018-10-10");
        result = np.ieskotiKompiuteriu(kriterijai);

        //  result = paieska.tikIsnuomoti().pagalPavadinima("n").getResult();
        app.spausdintiSarasa(result);


//        System.out.println("-------------");
//        List<Kompiuteris> laisviDatai = np.parodytiLaisvus(LocalDate.of(2018, 10, 2));
//        app.spausdintiSarasa(laisviDatai);
//
//        System.out.println("-------------");
//        app.spausdintiSarasa(np.getKompiuteriaiDAO().gautiVisus());


    }

    private void spausdintiSarasa(List<Kompiuteris> sarasas) {
        if (sarasas != null) {
            for (Kompiuteris kompiuteris : sarasas) {
                System.out.println(kompiuteris.toHumanString());
            }
        }
    }

}
