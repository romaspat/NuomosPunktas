package nuomospunktas.business;


import nuomospunktas.NuomosPunktas;
import nuomospunktas.kompiuteriai.Kompiuteris;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KompiuteriuPaieskaMapasTest {

    NuomosPunktas np;

    @Before
    public void init() {
        np = new NuomosPunktas();
    }

    @Test
    public void cases() {

        Map<String, String> kriterijai = new HashMap<>();
        kriterijai.put("pavadinimas", "sam");
        kriterijai.put("grazinimoData", "2018-10-7");

        assertEquals(1,np.ieskotiKompiuteriu(kriterijai).size());

        kriterijai = new HashMap<>();
        kriterijai.put("dienosKaina", "12");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(3, np.ieskotiKompiuteriu(kriterijai).size());
        assertEquals(3, np.ieskotiKompiuteriu(kriterijai).get(0).getId());
        assertEquals(5, np.ieskotiKompiuteriu(kriterijai).get(1).getId());
        assertEquals(6, np.ieskotiKompiuteriu(kriterijai).get(2).getId());

        kriterijai = new HashMap<>();
        kriterijai.put("die", "12");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(5, np.ieskotiKompiuteriu(kriterijai).size());
        assertEquals(0, np.ieskotiKompiuteriu(kriterijai).get(0).getId());
        assertEquals(3, np.ieskotiKompiuteriu(kriterijai).get(1).getId());
        assertEquals(4, np.ieskotiKompiuteriu(kriterijai).get(2).getId());
        assertEquals(5, np.ieskotiKompiuteriu(kriterijai).get(3).getId());
        assertEquals(6, np.ieskotiKompiuteriu(kriterijai).get(4).getId());


        kriterijai = new HashMap<>();
        kriterijai.put("dydis", "10");
        kriterijai.put("tipas", "plans");
        kriterijai.put("savaitesKaina", "65");
        assertEquals(2, np.ieskotiKompiuteriu(kriterijai).size());
        assertEquals(3, np.ieskotiKompiuteriu(kriterijai).get(0).getId());
        assertEquals(4, np.ieskotiKompiuteriu(kriterijai).get(1).getId());
    }
}
