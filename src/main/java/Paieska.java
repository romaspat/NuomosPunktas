import java.time.LocalDate;
import java.util.List;

public interface Paieska {

    List<Kompiuteris> grazintiSarasa(boolean pozymis); //jei true grazins isnuomotus
    List<Kompiuteris> grazintiLaisvusDatai(LocalDate data); //grazins lais

}
