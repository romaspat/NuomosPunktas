import java.time.LocalDate;
import java.util.List;

public interface NuomosOperacijos<T> {

    List<T> parodytiSarasa(boolean pozymis); //jei true grazins isnuomotus
    List<T> parodytiLaisvusDatai(LocalDate data); //grazins laisvus datai
    void isnuomotiKompiuteri(int id, int terminas);
    void grazintiKompiuteri(int id);

}
