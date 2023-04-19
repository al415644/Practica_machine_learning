package es.uji.al415644.datos;

import es.uji.al415644.clientes.RecSys;
import es.uji.al415644.estructuras.Row;
import es.uji.al415644.estructuras.Table;
import es.uji.al415644.machinelearning.KMeans;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        try {
            Table emptyTable = new Table();
            recSys.run(emptyTable, testItemNames);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Test
    void recommend() throws Exception {
        Table table = new Table();
        table.addRow(new Row(Arrays.asList(3.0,4.0, 1.0)));
        table.addRow(new Row(Arrays.asList(1.0,2.0, 4.0)));
        table.addRow(new Row(Arrays.asList(8.0,1.0, 4.0)));

        // Crear lista de nombres de elementos de prueba
        ArrayList<String> testItemNames = new ArrayList<String>();
        testItemNames.add("Texto1");
        testItemNames.add("Texto2");
        testItemNames.add("nombreDeElementoConocido");

        // Crear objeto RecSys y llamar a run
        KMeans kMeans = new KMeans<>(2, 100, 1);
        kMeans.train(table);
        RecSys recSys = new RecSys(kMeans);
        recSys.run(table, testItemNames);

        // Prueba: comprobar que todas las recomendaciones tienen el mismo valor en el mapa
        String nombre = "nombreDeElementoConocido";
        int numRec = 3;
        List<String> rec = recSys.recommend(nombre, numRec);

        // Obtener el valor del item recomendado en el mapa
        int value = recSys.getEstimaciones().get(rec.get(0));

        // Comprobar que todos los items recomendados tienen el mismo valor en el mapa
        for (String item : rec) {
            assertEquals(value, (int) recSys.getEstimaciones().get(item));
        }
    }
}