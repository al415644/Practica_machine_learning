package es.uji.al415644;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data = new ArrayList<>();

    public Row(List<Double> e1){
        for(double dato : e1){
            data.add(dato);
        }
    }
    public Row () {
        data = new ArrayList<>();
    }

    public List<Double> getData() {
        return data;
    }
}
