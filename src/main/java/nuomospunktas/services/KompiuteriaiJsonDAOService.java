package nuomospunktas.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nuomospunktas.dao.IKompiuteriaiDAO;
import nuomospunktas.kompiuteriai.Kompiuteris;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "kompiuteriaiJson")
public class KompiuteriaiJsonDAOService implements IKompiuteriaiDAO<Kompiuteris> {


    public static final String JSON_FNAME = "kompiuteriai.json";
    private List<Kompiuteris> kompiuteriai;

    public KompiuteriaiJsonDAOService(){
        try {
            File f = new File(JSON_FNAME);

            if (!f.exists()) {
                f.createNewFile();
            }
            Reader reader = new FileReader(f);

            Type listType = new TypeToken<ArrayList<Kompiuteris>>() {
            }.getType();

            kompiuteriai = new Gson().fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Kompiuteris gautiPagalId(int id) {
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                return kompiuteris;
            }
        }
        return null;
    }

    @Override
    public void pridetiKompiuteri(Kompiuteris kompiuteris) {
        kompiuteris.setId(gautiId());
        if (kompiuteriai.add(kompiuteris)) {
            saveList();
        }
    }

    @Override
    public void ismestiKompiuteri(int id) {
        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (kompiuteris.getId() == id) {
                if (kompiuteriai.remove(kompiuteris)) {
                    saveList();
                }
                return;
            }
        }
    }

    @Override
    public void isnuomotiKompiuteri(Integer id, Integer terminas){
        if (!kompiuteriai.isEmpty()) {
            if (kompiuteriai.size() > id && id >= 0) {
                kompiuteriai.get(id).setIsnuomavimoData(LocalDate.now());
                kompiuteriai.get(id).setGrazinimoData(LocalDate.now().plusDays(terminas));
            }
            saveList();
        }
    }

    @Override
    public void grazintiKompiuteri(Integer id){
        if (!kompiuteriai.isEmpty()) {
            if (kompiuteriai.size() > id && id >= 0) {
                kompiuteriai.get(id).setIsnuomavimoData(null);
                kompiuteriai.get(id).setGrazinimoData(null);
            }
            saveList();
        }
    }

    @Override
    public List<Kompiuteris> gautiVisus() {
        return kompiuteriai;
    }

    private void saveList() {
        try {
            File f = new File(JSON_FNAME);

            if (!f.exists()) {
                f.createNewFile();
            }
            FileUtils.writeStringToFile(f, new Gson().toJson(kompiuteriai), StandardCharsets.UTF_8, false);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int gautiId() {

        int max = 0;

        for (Kompiuteris kompiuteris : kompiuteriai) {
            if (max < kompiuteris.getId()) {
                max = kompiuteris.getId();
            }
        }
        return ++max;
    }

}
