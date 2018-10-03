package nuomospunktas.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nuomospunktas.NuomosPunktas;
import nuomospunktas.business.KompiuteriuPaieskaMapas;
import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.KompiuteriaiDAOFactSpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nuoma")
public class NuomosPunktasAPIController {

    @Autowired
    private KompiuteriaiDAOFactSpr kompiuteriai;

    @Autowired
    private KompiuteriuPaieskaMapas paieskaMapas;

    @GetMapping
    public List<Kompiuteris> parodytiVisus() {
        return kompiuteriai.getInstance().gautiVisus();
    }

    @PostMapping("/search")
    public List<Kompiuteris> ieskoti(@RequestBody String kriterijai) {

        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> kriterijaiMap = gson.fromJson(kriterijai, type);

        if (kriterijai == null || (kriterijai != null && kriterijai.isEmpty())) {
            return new ArrayList<>();
        }
        return paieskaMapas.ieskoti(kompiuteriai.getInstance().gautiVisus(),kriterijaiMap);
    }
}
