package es.uji.al415644.machinelearning;

import es.uji.al415644.estructuras.Row;
import es.uji.al415644.estructuras.Table;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMeansTest {
    @Test
    public void testTrain() throws Exception {
        KMeans kMeans = new KMeans<>(2, 100, 1);
        Table datos = new Table();
        datos.addRow(new Row(Arrays.asList(1.0, 1.0)));
        datos.addRow(new Row(Arrays.asList(2.0,2.0)));
        datos.addRow(new Row(Arrays.asList(3.0,3.0)));
        kMeans.train(datos);
        assertEquals(2, kMeans.getRepresentantes().size());
        assertEquals(2, kMeans.getGrupos().size());
        kMeans = new KMeans<>(6, 100, 1);
        try {
            kMeans.train(datos);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertEquals("Mas grupos que datos", e.getMessage());
        }
    }


    @Test
    void estimate() throws Exception {
            KMeans kMeans = new KMeans(3, 10, 1234);
            Table datos = new Table();
            datos.addRow(new Row(Arrays.asList(1.0, 2.0, 3.0)));
            datos.addRow(new Row(Arrays.asList(4.0, 5.0, 6.0)));
            datos.addRow(new Row(Arrays.asList(7.0, 8.0, 9.0)));
            kMeans.train(datos);

            List<Double> dato_comparar = Arrays.asList(2.0, 3.0, 4.0);
            assertEquals(0, kMeans.estimate(dato_comparar));

            dato_comparar = Arrays.asList(5.0, 6.0, 7.0);
            assertEquals(1, kMeans.estimate(dato_comparar));

            dato_comparar = Arrays.asList(8.0, 9.0, 10.0);
            assertEquals(2, kMeans.estimate(dato_comparar));
        }
    }