package es.uji.al415644.datos;

import es.uji.al415644.estructuras.RowWithLabel;
import es.uji.al415644.estructuras.TableWithLabels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVLabledFileReader extends CSVUnlabeledFileReader{

    public CSVLabledFileReader(String nombreFichero) {
        super(nombreFichero);
        this.tabla = new TableWithLabels();
    }
    void processData(String data){
        String[] linea = data.split(",");
        List<Double> lista= new ArrayList<>();
        for (int i = 0; i < linea.length - 1; i++) {
            lista.add((Double.parseDouble(linea[i])));
        }
        ((TableWithLabels)tabla).addLabel(linea[linea.length - 1]);
        int identificador = ((TableWithLabels)tabla).getValue(linea[linea.length-1]);
        RowWithLabel fila = new RowWithLabel(lista, identificador);
        tabla.addRow(fila);
    }
}