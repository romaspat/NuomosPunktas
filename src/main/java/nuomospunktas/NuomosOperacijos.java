package nuomospunktas;

import java.time.LocalDate;
import java.util.List;

public interface NuomosOperacijos<T> {

    void isnuomotiKompiuteri(int id, int terminas);

    void grazintiKompiuteri(int id);

}
