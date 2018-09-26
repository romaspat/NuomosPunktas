import java.time.LocalDate;
import java.util.List;

public interface NuomosOperacijos<T> {

    List<T> grazintiSarasa(boolean pozymis); //jei true grazins isnuomotus
    List<T> grazintiLaisvusDatai(LocalDate data); //grazins laisvus datai
    void isnuomotiKompiuteri(int id, int terminas);
    void grazintiKompiuteri(int id);

}
