package es.uji.al415644.estructuras;

import java.util.HashMap;
import java.util.Map;

public class TableWithLabels extends Table {

    public Map<String, Integer> labelsToIndex = new HashMap<String, Integer>();

    public TableWithLabels() {
        labelsToIndex = new HashMap<>();
    }

    public void addLabel(String etiqueta) {
        labelsToIndex.put(etiqueta, labelsToIndex.size());
    }

    public RowWithLabel getRowAt(int posicion) {
        return (RowWithLabel) super.getRowAt(posicion);
    }

    public boolean contieneLlave(String etiqueta) {
        return labelsToIndex.containsKey(etiqueta);
    }

    public int getValue(String etiqueta) {
        return labelsToIndex.get(etiqueta);
    }
}
