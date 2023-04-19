package es.uji.al415644;

import es.uji.al415644.datos.CSV;
import es.uji.al415644.estructuras.Table;
import es.uji.al415644.estructuras.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    Table datos = new Table();
    CSV nuevo;
    @Test
    void readtable() throws FileNotFoundException {
        nuevo = new CSV();
        Table tabla = nuevo.readtable("miles_dollars.csv");
        assertEquals(25, tabla.tamano());
    }

    @Test
    void readTableWithLabels() throws FileNotFoundException {
        nuevo = new CSV();
        TableWithLabels tabla = (TableWithLabels) nuevo.readTableWithLabels("iris.csv");
        assertEquals(150, tabla.tamano());
    }
}