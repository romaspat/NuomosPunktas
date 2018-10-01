package services;

import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;

import java.util.ArrayList;
import java.util.List;

public class KompiuteriaiJsonDAOService implements IKompiuteriaiDAO<KompiuterisImpl> {


    private String JSON_FNAME = "kompiuteriai.json";
    private List<KompiuterisImpl> kompiuteriai = new ArrayList<>();

    @Override
    public KompiuterisImpl gautiPagalId(int id) {
        return null;
    }

    @Override
    public void pridetiKompiuteri(KompiuterisImpl kompiuteris) {

    }

    @Override
    public void ismestiKompiuteri(int id) {

    }

    @Override
    public List<KompiuterisImpl> gautiVisus() {
        return null;
    }
}
