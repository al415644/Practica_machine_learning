package es.uji.al415644.datos;

import es.uji.al415644.MachineLearning.KMeans;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RecSysTest {

    @Test
    void run() throws Exception {
            // Crear tabla de datos de prueba
            Table table = new Table();
            table.addRow(new Row(Arrays.asList(3.0,4.0, 1.0)));
            table.addRow(new Row(Arrays.asList(1.0,2.0, 4.0)));

            // Crear lista de nombres de elementos de prueba
            ArrayList<String> testItemNames = new ArrayList<String>();
            testItemNames.add("Texto1");
            testItemNames.add("Texto2");

            // Crear objeto RecSys y llamar a run
            KMeans kMeans = new KMeans<>(2, 100, 1);
            kMeans.train(table);
            RecSys recSys = new RecSys(kMeans);
            recSys.run(table, testItemNames);

            // Comprobar que el mapa de estimaciones contiene los valores correctos
            assertEquals(2, recSys.getEstimaciones().size());
            assertEquals(1, recSys.getEstimaciones());
            assertEquals(0, recSys.getEstimaciones());

    }

    @Test
    void recommend() {

    }
}