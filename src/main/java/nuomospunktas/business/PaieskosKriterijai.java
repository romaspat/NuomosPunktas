package nuomospunktas.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaieskosKriterijai {

    private PaieskosField field;
    private String value;

    public PaieskosKriterijai() {

    }

    public PaieskosKriterijai(String value) {
        super();
        this.value = value;
    }


    public Map<String, String> convertToMap(List<PaieskosKriterijai> kriterijai) {

        Map<String, String> result = new HashMap<>();

        for (PaieskosKriterijai paieskosKriterijus : kriterijai) {
            switch (field) {
                case tipas:
                    result.put(PaieskosField.tipas.toString(), paieskosKriterijus.value);
                    break;
                case pavadinimas:
                    result.put(PaieskosField.pavadinimas.toString(), paieskosKriterijus.value);
                    break;
                case dydis:
                    result.put(PaieskosField.dydis.toString(), paieskosKriterijus.value);
                    break;
                case procesorius:
                    result.put(PaieskosField.procesorius.toString(), paieskosKriterijus.value);
                    break;
                case atmintis:
                    result.put(PaieskosField.atmintis.toString(), paieskosKriterijus.value);
                    break;
                case diskas:
                    result.put(PaieskosField.diskas.toString(), paieskosKriterijus.value);
                    break;
                case os:
                    result.put(PaieskosField.os.toString(), paieskosKriterijus.value);
                    break;
                case dienosKaina:
                    result.put(PaieskosField.dienosKaina.toString(), paieskosKriterijus.value);
                    break;
                case savaitesKaina:
                    result.put(PaieskosField.savaitesKaina.toString(), paieskosKriterijus.value);
                    break;
                case grazinimoData:
                    result.put(PaieskosField.grazinimoData.toString(), paieskosKriterijus.value);
                    break;
                default:
                    break;
            }

        }
        return result;
    }
}
