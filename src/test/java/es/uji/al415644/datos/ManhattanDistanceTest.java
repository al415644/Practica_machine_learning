package es.uji.al415644.datos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {

    @Test
    void calculateDistance() {
        final ManhattanDistance manhattanDistance = new ManhattanDistance();

        // Caso 1: Listas vacías
        double result1 = manhattanDistance.calculateDistance(Collections.emptyList(), Collections.emptyList());
        assertEquals(-1, result1, 0.0001);

        // Caso 2: Distancia entre dos puntos en una dimensión
        double result2 = manhattanDistance.calculateDistance(Arrays.asList(1.0), Arrays.asList(4.0));
        assertEquals(3, result2, 0.0001);

        // Caso 3: Distancia entre dos puntos en varias dimensiones
        double result3 = manhattanDistance.calculateDistance(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(4.0, 5.0, 6.0));
        assertEquals(9, result3, 0.0001);
        }
    }