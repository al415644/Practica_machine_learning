package es.uji.al415644.datos;

import es.uji.al415644.estructuras.Row;
import es.uji.al415644.estructuras.RowWithLabel;
import es.uji.al415644.estructuras.Table;
import es.uji.al415644.estructuras.TableWithLabels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSV {
    public Table readtable(String nombreFichero) throws FileNotFoundException{
        Table tabla = new Table();
        Scanner fichero = new Scanner(new File(nombreFichero));
        String[] linea = fichero.nextLine().split(",");
        for(String header :linea) {
            tabla.addheaders(header);
        }
        while(fichero.hasNextLine()) {
            linea = fichero.nextLine().split(",");
            List<Double> lista= new ArrayList<>();
            for (int i = 0; i < linea.length; i++) {
                lista.add((Double.parseDouble(linea[i])));
            }
            Row fila = new Row(lista);
            tabla.addRow(fila);
        }
        fichero.close();
        return tabla;
    }
    public Table readTableWithLabels(String nombreFichero) throws FileNotFoundException{
        TableWithLabels tabla = new TableWithLabels();
        Scanner fichero = new Scanner(new File(nombreFichero));
        String[] linea = fichero.nextLine().split(",");
        for(String header :linea) {
            tabla.addheaders(header);
        }
        while(fichero.hasNextLine()) {
            linea = fichero.nextLine().split(",");
            List<Double> lista = new ArrayList<>();
            for (int i = 0; i < linea.length - 1; i++) {
                lista.add((Double.parseDouble(linea[i])));
            }
            if (!tabla.contieneLlave(linea[linea.length - 1])){
                tabla.addLabel(linea[linea.length - 1]);
        }
            RowWithLabel fila = new RowWithLabel(lista, tabla.getValue(linea[linea.length-1]));
            tabla.addRow(fila);
        }

        return tabla;
    }
}