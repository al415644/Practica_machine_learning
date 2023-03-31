package es.uji.al415644.datos;

import java.util.List;

public class RowWithLabel extends Row {

    public int numberClass;
    public RowWithLabel(List<Double> e1, int numberClass) {
        super(e1);
        this.numberClass = numberClass;
    }

    public int getNumberClass() {
        return numberClass;
    }
}
