package nuomospunktas.controllers;


import nuomospunktas.kompiuteriai.Kompiuteris;
import nuomospunktas.services.KompiuteriaiDAOFactSpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nuomospunktas")
public class NuomosPunktasAPIController {

    @Autowired
    private KompiuteriaiDAOFactSpr kompiuteriaiFactory;

    @GetMapping
    public List<Kompiuteris> getAll() {
        return kompiuteriaiFactory.getInstance().gautiVisus();
    }



}
