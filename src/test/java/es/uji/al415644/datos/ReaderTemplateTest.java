package es.uji.al415644.datos;

import es.uji.al415644.estructuras.Table;
import es.uji.al415644.estructuras.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTemplateTest {
    @Test
    void testTable() throws FileNotFoundException {
        ReaderTemplate nuevo = new CSVUnlabeledFileReader("miles_dollars.csv");
        assertEquals(25, nuevo.readTableFromSource().tamano());
    }
    @Test
    void testColumnas() throws FileNotFoundException {
        ReaderTemplate nuevo = new CSVUnlabeledFileReader("miles_dollars.csv");
        assertEquals(2, nuevo.readTableFromSource().getHeaders().size());
    }
    @Test
    void testTableWithLabels() throws FileNotFoundException {
        ReaderTemplate nuevoLabeled = new CSVLabledFileReader("iris.csv");
        assertEquals(150, nuevoLabeled.readTableFromSource().tamano());
    }
    @Test
    void testColumnasLabled() throws FileNotFoundException {
        ReaderTemplate nuevoLabeled = new CSVLabledFileReader("iris.csv");
        assertEquals(5, nuevoLabeled.readTableFromSource().getHeaders().size());
    }
}