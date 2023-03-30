package es.uji.al415644;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    Table datos = new Table();
    CSV nuevo;
    @Test
    void readtable() throws FileNotFoundException {
        nuevo = new CSV();
        Table tabla = nuevo.readtable("ficheropatest.csv");
        assertEquals(12, tabla.tamano());
    }

    @Test
    void readTableWithLabels() {
        assertEquals(50, datos.tamano());
    }
}