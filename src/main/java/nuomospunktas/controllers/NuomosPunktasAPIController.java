package nuomospunktas.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nuomospunktas.business.KompiuteriuPaieskaMapas;
import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.KompiuteriaiDAOFactSpr;
import nuomospunktas.services.KompiuteriaiJsonDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
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

    @PostMapping("rent/{id}/{days}")
    public void isnuomotiKompiuteri(@PathVariable("id") @NumberFormat Integer id, @PathVariable("days") @NumberFormat Integer terminas) {
        if (!kompiuteriai.getInstance().gautiVisus().isEmpty()) {
            if (kompiuteriai.getInstance().gautiVisus().size() > id && id >= 0) {
                kompiuteriai.getInstance().gautiVisus().get(id).setIsnuomavimoData(LocalDate.now());
                kompiuteriai.getInstance().gautiVisus().get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
            }
            if (kompiuteriai.getInstance() instanceof KompiuteriaiJsonDAOService) {
                ((KompiuteriaiJsonDAOService) kompiuteriai.getInstance()).atnaujintiSarasa();
            }
        }
    }

    @PostMapping("return/{id}")
    public void grazintiKompiuteri(@PathVariable("id") @NumberFormat Integer id) {
        if (!kompiuteriai.getInstance().gautiVisus().isEmpty()) {
            if (kompiuteriai.getInstance().gautiVisus().size() > id && id >= 0) {
                kompiuteriai.getInstance().gautiVisus().get(id).setIsnuomavimoData(null);
                kompiuteriai.getInstance().gautiVisus().get(id).setGrazinimoData(null);
            }

            if (kompiuteriai.getInstance() instanceof KompiuteriaiJsonDAOService) {
                ((KompiuteriaiJsonDAOService) kompiuteriai.getInstance()).atnaujintiSarasa();
            }
        }

    }
}
