package es.uji.al415644.datos;

import es.uji.al415644.interfaces.Distances;

import java.util.List;

public class EuclideanDistance implements Distances {


    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        if(p.isEmpty() || q.isEmpty()) {
            return -1;
        }
        double distancia;
        double sumaEuclidea = 0;
        for (int i = 0; i < p.size (); i++) {
            sumaEuclidea += Math. pow ((p. get (i) - q. get (i)), 2);
        }
        distancia = Math.sqrt(sumaEuclidea);
        return distancia;
    }
}
