package es.uji.al415644.machinelearning;

import es.uji.al415644.datos.CSV;
import es.uji.al415644.datos.EuclideanDistance;
import es.uji.al415644.estructuras.TableWithLabels;
import es.uji.al415644.interfaces.Distances;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    @Test
    @DisplayName("Test estimacion de clase")
    void estimate() throws FileNotFoundException {
        Distances distancia = new EuclideanDistance();
        KNN datos = new KNN(distancia);
        CSV prueba = new CSV();
        datos.train((TableWithLabels) prueba.readTableWithLabels("iris.csv"));
        List<Double> lista1 = new ArrayList<>();
        lista1.add(4.5);
        lista1.add(2.3);
        lista1.add(1.0);
        lista1.add(0.4);
        assertEquals(0, datos.estimate(lista1));
    }

    @Test
    @DisplayName("Test metrica Euclidea")
    void metricaEuclidea() throws FileNotFoundException {
        CSV prueba = new CSV();
        Distances distancia = new EuclideanDistance();
        KNN test = new KNN(distancia);
        List<Double> Prueba1 = new ArrayList<>();
        List<Double> Prueba2 = new ArrayList<>();

        Prueba1.add(4.9);
        Prueba1.add(2.9);
        Prueba1.add(1.7);
        Prueba1.add(0.2);

        Prueba2.add(7.0);
        Prueba2.add(3.3);
        Prueba2.add(6.0);
        Prueba2.add(1.5);


        assertEquals(0.24,test.distancia(Prueba1,prueba.readTableWithLabels("iris.csv").getRowAt(30).getData()),0.01d);
        assertEquals(0.37,test.distancia(Prueba2,prueba.readTableWithLabels("iris.csv").getRowAt(125).getData()),0.01d);
    }
}