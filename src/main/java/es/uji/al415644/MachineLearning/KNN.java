package es.uji.al415644.MachineLearning;

import es.uji.al415644.interfaces.Algorithm;
import es.uji.al415644.interfaces.DistanceClient;
import es.uji.al415644.interfaces.Distances;
import es.uji.al415644.datos.RowWithLabel;
import es.uji.al415644.datos.TableWithLabels;

import java.util.List;

public class KNN<T,U,W> implements Algorithm<TableWithLabels,List<Double>,Integer>, DistanceClient {
    private TableWithLabels data;
    private Distances distancia;

    public KNN(Distances distancia){
        this.distancia = distancia;
    }

    public void train (TableWithLabels tabla) { data = tabla;}
    public Integer estimate (List<Double> sample) {
        if (sample.isEmpty()) {
            return -1;
        }
        double min = Double.POSITIVE_INFINITY;
        int numclase = 0;
        RowWithLabel actualRow = null;
        for (int i = 0; i < data.tamano(); i++) {
            actualRow = data.getRowAt(i);
            double distancia = distancia(sample, actualRow.getData());
            if (distancia < min) {
                min = distancia;
                numclase = actualRow.getNumberClass();
            }
        }
            return numclase;
    }

    public double distancia(List<Double> sample, List<Double> elemento) {
        return this.distancia.calculateDistance(sample, elemento);
    }
    public void setDistance(Distances distancia){
        this.distancia = distancia;
    }
}