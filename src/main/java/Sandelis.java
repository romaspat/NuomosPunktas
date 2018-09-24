import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sandelis implements Paieska {

    private String sandelioPavadinimas;
    private List<Kompiuteris> sandelis = new ArrayList<>();

    public Sandelis(String sandelioPavadinimas) {
        this.sandelioPavadinimas = sandelioPavadinimas;
    }

    @Override
    public List<Kompiuteris> grazintiSarasa(boolean pozymis) {
        List<Kompiuteris> temp = new ArrayList<>();

        for (Kompiuteris kompiuteris : sandelis) {
            if (kompiuteris.isIsnuomota() == pozymis) {
                temp.add(kompiuteris);
            }
        }
        return temp;
    }

    @Override
    public List<Kompiuteris> grazintiLaisvusDatai(LocalDate data) {
        List<Kompiuteris> temp = new ArrayList<>();

        for (Kompiuteris kompiuteris : sandelis) {
            if (kompiuteris.isIsnuomota()) {
                if (data.isAfter(kompiuteris.getGrazinimoData())) {
                    temp.add(kompiuteris);
                }
            } else {
                temp.add(kompiuteris);
            }
        }
        return temp;
    }

    @Override
    public void pridetiKompiuteri(Kompiuteris kompiuteris) {
        sandelis.add(kompiuteris);
    }

    @Override
    public void ismestiKompiuteri(int id) {
        int i = 0;
        if (id >= 0 && id < sandelis.size()) {
            for (Kompiuteris kompiuteris : sandelis) {
                if (kompiuteris.getId() == id) {
                    i = kompiuteris.getId();
                }
            }
            sandelis.remove(i);
        }
    }

    public String getSandelioPavadinimas() {
        return sandelioPavadinimas;
    }

    public void setSandelioPavadinimas(String sandelioPavadinimas) {
        this.sandelioPavadinimas = sandelioPavadinimas;
    }

    public List<Kompiuteris> getSandelis() {
        return sandelis;
    }

}
