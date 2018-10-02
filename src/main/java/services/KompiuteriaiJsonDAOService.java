package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.IKompiuteriaiDAO;
import kompiuteriai.KompiuterisImpl;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class KompiuteriaiJsonDAOService implements IKompiuteriaiDAO<KompiuterisImpl> {


    private String JSON_FNAME = "kompiuteriai.json";
    private List<KompiuterisImpl> kompiuteriai;

//    public KompiuteriaiJsonDAOService() {
//            init();
//    }

    @Override
    public KompiuterisImpl gautiPagalId(int id) {
        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                return kompiuteris;
            }
        }
        return null;
    }

    @Override
    public void pridetiKompiuteri(KompiuterisImpl kompiuteris) {
        kompiuteris.setId(gautiId());
        if (kompiuteriai.add(kompiuteris)) {
            saveList();
        }
    }

    @Override
    public void ismestiKompiuteri(int id) {
        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                if (kompiuteriai.remove(kompiuteris)) {
                    saveList();
                }
                return;
            }
        }
    }

    @Override
    public List<KompiuterisImpl> gautiVisus() {
        return kompiuteriai;
    }

    private void init() {
        File f = new File(JSON_FNAME);
        try {
            if (f.createNewFile()) {
                Reader reader = new FileReader(f);

                Type listType = new TypeToken<ArrayList<KompiuterisImpl>>() {
                }.getType();
                kompiuteriai = new Gson().fromJson(reader, listType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveList() {
        try {
            FileUtils.writeStringToFile(new File(JSON_FNAME), new Gson().toJson(kompiuteriai), StandardCharsets.UTF_8, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int gautiId() {

        int max = 0;

        for (KompiuterisImpl kompiuteris : kompiuteriai) {
            if (max < kompiuteris.getId()) {
                max = kompiuteris.getId();
            }
        }
        return ++max;
    }

}
