import java.time.LocalDate;
import java.util.List;

public interface Paieska {

    public List<Kompiuteris> grazintiSarasa(boolean pozymis); //jei true grazins isnuomotus
    public List<Kompiuteris> grazintiLaisvusDatai(LocalDate data); //grazins lais

    public void pridetiKompiuteri(Kompiuteris kompiuteris);
    public void ismestiKompiuteri(int id);

}
