package nuomospunktas.business;


import nuomospunktas.kompiuteriai.Kompiuteris;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class KompiuteriuPaieskaTest {

    private KompiuteriuPaieska paieska;
    private List<Kompiuteris> data;
    private LocalDate diena;

    @Before
    public void init() {
        paieska = new KompiuteriuPaieska();
        data = new ArrayList<>();
        diena = LocalDate.of(2018, 10,4);

        data.add(new Kompiuteris().setId(0).setTipas("Plansetinis").setPavadinimas("Samsung T580").
                setDydis("10\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("16Gb").setOs("Android").
                setDienosKaina(15).setSavaitesKaina(60));
        data.add(new Kompiuteris().setId(1).setTipas("Plansetinis").setPavadinimas("Samsung T710").
                setDydis("7\"").setProcesorius("2Ghz").setAtmintis("2Gb").setDiskas("32Gb").setOs("Android").
                setDienosKaina(10).setSavaitesKaina(50));
        data.add(new Kompiuteris().setId(2).setTipas("Nesiojamas").setPavadinimas("Lenovo Yoga 910").
                setDydis("13\"").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("512Gb").setOs("Windows 10").
                setDienosKaina(20).setSavaitesKaina(50));
        data.add(new Kompiuteris().setId(3).setTipas("Nesiojamas").setPavadinimas("HP Probook 450").
                setDydis("15\"").setProcesorius("2Ghz").setAtmintis("4Gb").setDiskas("256Gb").setOs("Linux").
                setDienosKaina(15).setSavaitesKaina(60));
        data.add(new Kompiuteris().setId(4).setTipas("Stacionarus").setPavadinimas("Dell Optiplex 3010").
                setDydis("SFF").setProcesorius("3Ghz").setAtmintis("8Gb").setDiskas("1024Gb").setOs("Windows").
                setDienosKaina(10).setSavaitesKaina(50).setIsnuomavimoData(diena).setGrazinimoData(diena.plusDays(1)));

    }

    @Test
    public void cases() {

        Map<String, String> kriterijai = new HashMap<>();
        kriterijai.put("pavadinimas", "del");
        kriterijai.put("grazinimoData", LocalDate.of(2018,10,7).toString());

        assertEquals(1,paieska.ieskoti(data,kriterijai).size());

        kriterijai = new HashMap<>();
        kriterijai.put("dienosKaina", "12");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(2, paieska.ieskoti(data,kriterijai).size());
        assertEquals(1, paieska.ieskoti(data,kriterijai).get(0).getId());
        assertEquals(4, paieska.ieskoti(data,kriterijai).get(1).getId());


        kriterijai = new HashMap<>();
        kriterijai.put("die", "12");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(5, paieska.ieskoti(data,kriterijai).size());
        assertEquals(0, paieska.ieskoti(data,kriterijai).get(0).getId());
        assertEquals(1, paieska.ieskoti(data,kriterijai).get(1).getId());
        assertEquals(2, paieska.ieskoti(data,kriterijai).get(2).getId());
        assertEquals(3, paieska.ieskoti(data,kriterijai).get(3).getId());
        assertEquals(4, paieska.ieskoti(data,kriterijai).get(4).getId());


        kriterijai = new HashMap<>();
        kriterijai.put("dydis", "10");
        kriterijai.put("tipas", "plans");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(1, paieska.ieskoti(data,kriterijai).size());
        assertEquals(0, paieska.ieskoti(data,kriterijai).get(0).getId());

        kriterijai = new HashMap<>();
        kriterijai.put("dydis", null);
        assertEquals(5, paieska.ieskoti(data,kriterijai).size());
    }
}
