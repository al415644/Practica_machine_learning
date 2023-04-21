package es.uji.al415644.datos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanDistanceTest {

    @Test
    void calculateDistance() {

        final EuclideanDistance euclideanDistance = new EuclideanDistance();

        // Prueba con listas vacías
        double result1 = euclideanDistance.calculateDistance(Collections.emptyList(), Collections.emptyList());
        assertEquals(-1, result1, 0.0001);

        // Prueba con una dimensión
        double result2 = euclideanDistance.calculateDistance(Arrays.asList(1.0), Arrays.asList(4.0));
        assertEquals(3.0, result2, 0.0001);

        // Prueba con varias dimensiones
        double result3 = euclideanDistance.calculateDistance(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(4.0, 5.0, 6.0));
        assertEquals(5.1962, result3, 0.0001);


        }



    }