package es.uji.al415644.datos;

import es.uji.al415644.datos.Row;
import es.uji.al415644.datos.RowWithLabel;
import es.uji.al415644.datos.Table;
import es.uji.al415644.datos.TableWithLabels;

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
            for (String cosa : linea) {
                lista.add(Double.parseDouble(cosa));
            }
            Row fila = new Row(lista);
            tabla.addRow(fila);
        }

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
            List<Double> lista= new ArrayList<>();
            for (String cosa : linea) {
                lista.add(Double.parseDouble(cosa));
            }if (!tabla.hasLlave(linea[linea.length-1])){
                tabla.addType(linea[linea.length-1]);
            }
            RowWithLabel fila = new RowWithLabel(lista, tabla.numeroDeLlave(linea[linea.length-1]));
            tabla.addRow(fila);
        }

        return tabla;
    }
}