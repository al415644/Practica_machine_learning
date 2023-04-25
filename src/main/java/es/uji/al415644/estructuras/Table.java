package es.uji.al415644.estructuras;

import java.util.ArrayList;
import java.util.List;

public class Table {

    public Table() {
        headers = new ArrayList<>();
        rows = new ArrayList<>();
    }
    public List<String> headers = new ArrayList<>();
    public List<Row> rows = new ArrayList<>();

    public Table(List<String> headers){
        this.headers = headers;
        rows = new ArrayList<>();
    }
    public void addRow(Row fila){
        rows.add(fila);
    }
    public int tamano(){
        return rows.size();
    }
    public void addheaders(String header) {
        headers.add(header);
    }
    public Row getRowAt(int rowNumber){
        return rows.get(rowNumber);
    }
    public List<String> getHeaders(){return headers;}
}