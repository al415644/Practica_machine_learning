package es.uji.al415644.MachineLearning;

import es.uji.al415644.datos.Algorithm;
import es.uji.al415644.datos.RowWithLabel;
import es.uji.al415644.datos.TableWithLabels;

import java.util.List;

public class KNN<T,U,W> implements Algorithm<TableWithLabels,List<Double>,Integer > {
    private TableWithLabels data;

    public KNN(){}

    public void train (TableWithLabels tabla) { data = tabla;}
    public Integer estimate (List<Double> sample) {
        double min = Double.POSITIVE_INFINITY;
        int numclase = 0;
        RowWithLabel actualRow = null;
        for (int i = 0; i < data.tamano(); i++) {
            actualRow = data.getRowWithLabelAt(i);
            double distancia = distancia(sample, actualRow.getData());
            if (distancia < min) {
                min = distancia;
                numclase = actualRow.getNumberClass();
            }
        }
            return numclase;
    }

    public double distancia(List<Double> sample, List<Double> elemento) {
        double distancia;
        double sumaEuclidea = 0;
        for (int i = 0; i < sample.size (); i++) {
            sumaEuclidea += Math. pow ((sample. get (i) - elemento. get (i)), 2);
        }
        distancia = Math.sqrt(sumaEuclidea);
        return distancia;
    }

}