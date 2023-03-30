package es.uji.al415644;

import java.util.List;

public class RowWithLabel extends Row {

    public int numberClass;
    public RowWithLabel(List<Double> e1, Integer numberClass) {
        super(e1);
        this.numberClass = numberClass;
    }

    public int getNumberClass() {
        return numberClass;
    }
}
