import java.time.LocalDate;
import java.util.List;

public interface NuomosOperacijos<T> {

    List<T> parodytiLaisvus(boolean pozymis);

    List<T> parodytiLaisvus(LocalDate data);

    void isnuomotiKompiuteri(int id, int terminas);

    void grazintiKompiuteri(int id);

}
