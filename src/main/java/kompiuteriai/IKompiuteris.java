package kompiuteriai;

import java.time.LocalDate;

public interface IKompiuteris<T> {

    int getId();

    T setId(int i);

    String getPavadinimas();

    String getDydis();

    String getProcesorius();

    String getAtmintis();

    String getDiskas();

    String getOs();

    Double getDienosKaina();

    Double getSavaitesKaina();

    LocalDate getIsnuomavimoData();

    LocalDate getGrazinimoData();

}
