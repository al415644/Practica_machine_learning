package es.uji.al415644.MachineLearning;

import es.uji.al415644.datos.Row;
import es.uji.al415644.datos.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMeansTest {
    @Test
    public void testTrain() throws Exception {
        KMeans kMeans = new KMeans<>(2, 100, 1);
        Table datos = new Table();
        List<Double> row1 = new ArrayList<>();
        row1.add(1.0);
        row1.add(1.0);
        List<Double> row2 = new ArrayList<>();
        row2.add(2.0);
        row2.add(2.0);
        List<Double> row3 = new ArrayList<>();
        row3.add(3.0);
        row3.add(3.0);
        List<Double> row4 = new ArrayList<>();
        row4.add(4.0);
        row4.add(4.0);
        Row fila1 = new Row(row1);
        Row fila2 = new Row(row2);
        Row fila3 = new Row(row3);
        Row fila4 = new Row(row4);
        datos.addRow(fila1);
        datos.addRow(fila2);
        datos.addRow(fila3);
        datos.addRow(fila4);
        kMeans.train(datos);
        assertEquals(2, kMeans.getRepresentantes().size());
    }


    @Test
    void estimate() {

    }
}