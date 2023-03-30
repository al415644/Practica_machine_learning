package es.uji.al415644.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    public Map<String,Integer> labelsToIndex = new HashMap<String,Integer>();
    public List<RowWithLabel> RowsWithLables = new ArrayList<>();

    public TableWithLabels() {
        labelsToIndex = new HashMap<>();
        headers = new ArrayList<>();
        RowsWithLables = new ArrayList<>();
    }
    public TableWithLabels(List<String> headers) {
        super(headers);
        RowsWithLables = new ArrayList<>();
        labelsToIndex = new HashMap<>();
    }

    public void addRowWithLabel(RowWithLabel fila){
        RowsWithLables.add(fila);
    }
    public void addType(String tipo){
        if (!labelsToIndex.containsKey(tipo)){
            labelsToIndex.put(tipo,labelsToIndex.size());
        }
    }
    public Integer numeroDeLlave (String llave){
        return labelsToIndex.get(llave);
    }
    public RowWithLabel getRowWithLabelAt(int rowNumber){
        return RowsWithLables.get(rowNumber);
    }
    public boolean hasLlave(String llave) {
        if (labelsToIndex.containsKey(llave)) {
            return true;
        }
        return false;
    }
    public int tamano(){
        return RowsWithLables.size();
    }
}
