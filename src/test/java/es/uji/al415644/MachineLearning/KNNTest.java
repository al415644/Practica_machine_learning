package es.uji.al415644.MachineLearning;

import es.uji.al415644.datos.CSV;
import es.uji.al415644.datos.TableWithLabels;
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
        CSV prueba = new CSV();
        KNN datos = new KNN();
        datos.train((TableWithLabels) prueba.readTableWithLabels("iris.csv"));
        List<Double> irisPrueba1 = new ArrayList<>();
        List<Double> irisPrueba2 = new ArrayList<>();
        List<Double> irisPrueba3 = new ArrayList<>();
        List<Double> irisPrueba4 = new ArrayList<>();
        List<Double> pruebaListaVacia = new ArrayList<>();
        //Flor parecida a Iris setosa
        irisPrueba1.add(4.9);
        irisPrueba1.add(2.9);
        irisPrueba1.add(1.7);
        irisPrueba1.add(0.2);
        //Flor parecida a Iris virginica
        irisPrueba2.add(7.0);
        irisPrueba2.add(3.3);
        irisPrueba2.add(6.0);
        irisPrueba2.add(1.5);
        //Flor parecida a Iris virginica 4.9,2.4,3.3,1.0,Iris-versicolor
        irisPrueba3.add(5.0);
        irisPrueba3.add(2.5);
        irisPrueba3.add(3.0);
        irisPrueba3.add(0.9);
        //Flor parecida a Iris virginica
        irisPrueba4.add(7.2);
        irisPrueba4.add(3.2);
        irisPrueba4.add(6.0);
        irisPrueba4.add(1.8);
        /*
        Iris-setosa -> 0
        Iris-versicolor -> 1
        Iris-virginica -> 2
         */
        assertEquals(0,datos.estimate(irisPrueba1));
        assertEquals(2,datos.estimate(irisPrueba2));
        assertEquals(1,datos.estimate(irisPrueba3));
        assertEquals(2,datos.estimate(irisPrueba4));
        assertEquals(-1,datos.estimate(pruebaListaVacia));
    }

    @Test
    @DisplayName("Test metrica Euclidea")
    void metricaEuclidea() throws FileNotFoundException {
        CSV prueba = new CSV();
        KNN test = new KNN();
        List<Double> irisPrueba1 = new ArrayList<>();
        List<Double> irisPrueba2 = new ArrayList<>();
        List<Double> irisMetrica0 = new ArrayList<>();
        List<Double> pruebaListaVacia = new ArrayList<>();
        irisPrueba1.add(4.9);
        irisPrueba1.add(2.9);
        irisPrueba1.add(1.7);
        irisPrueba1.add(0.2);

        irisPrueba2.add(7.0);
        irisPrueba2.add(3.3);
        irisPrueba2.add(6.0);
        irisPrueba2.add(1.5);

        irisMetrica0.add(7.2);
        irisMetrica0.add(3.2);
        irisMetrica0.add(6.0);
        irisMetrica0.add(1.8);
        assertEquals(0.24,test.distancia(irisPrueba1,prueba.readTableWithLabels("iris.csv").getRowAt(30).getData()),0.01d);//Flor linea 32
        assertEquals(0.37,test.distancia(irisPrueba2,prueba.readTableWithLabels("iris.csv").getRowAt(125).getData()),0.01d);//Flor linea 127
        assertEquals(0,test.distancia(irisMetrica0,prueba.readTableWithLabels("iris.csv").getRowAt(125).getData()),0.01d);//Flor linea 127
        assertEquals(-1,test.distancia(pruebaListaVacia,prueba.readTableWithLabels("iris.csv").getRowAt(1).getData()),0.01d);//Flor linea 3
        assertEquals(-1,test.distancia(irisPrueba1,pruebaListaVacia),0.01d);//Ninguna flor
    }
}