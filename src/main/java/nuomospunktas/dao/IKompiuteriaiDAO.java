package nuomospunktas.dao;

import java.util.List;

public interface IKompiuteriaiDAO<T> {

    T gautiPagalId(int id);
    void pridetiKompiuteri(T kompiuteris);
    void ismestiKompiuteri(int id);
    List<T> gautiVisus();
 //   public void atnaujintiSarasa();

    void isnuomotiKompiuteri(Integer id, Integer terminas);
    void grazintiKompiuteri(Integer id);

}
