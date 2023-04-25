package es.uji.al415644.datos;

import es.uji.al415644.estructuras.Row;
import es.uji.al415644.estructuras.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUnlabeledFileReader extends ReaderTemplate {
    private Scanner fichero;

    public CSVUnlabeledFileReader(String nombreFichero) {
        super(nombreFichero);
    }

    void openSource(String source) throws FileNotFoundException {
        fichero = new Scanner(new File(source));
    }
    void processHeaders(String headers){
        String[] cabeceras = headers.split(",");
        for (int i = 0; i < cabeceras.length; i++) {
            tabla.addheaders(cabeceras[i]);
        }
    }
    void processData(String data){
        String[] linea = data.split(",");
        List<Double> lista= new ArrayList<>();
        for (int i = 0; i < linea.length; i++) {
            lista.add((Double.parseDouble(linea[i])));
        }
        Row fila = new Row(lista);
        tabla.addRow(fila);
    }
    void closeSource(){
        fichero.close();
    }
    boolean hasMoreData(){
        return fichero.hasNextLine();
    }
    String getNextData(){
        return fichero.nextLine();
    }

}
