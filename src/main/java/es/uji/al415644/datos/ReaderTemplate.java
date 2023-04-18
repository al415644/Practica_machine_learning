package es.uji.al415644.datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ReaderTemplate {
    private Table tabla;

    private String nombreFichero;
    public ReaderTemplate(String nombreFichero){
        this.tabla = new Table();
        this.nombreFichero = nombreFichero;
    }
    abstract void openSource(String source) throws FileNotFoundException;
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract boolean hasMoreData();
    abstract String getNextData();

    public final Table readTableFromSource() throws FileNotFoundException {
        openSource(nombreFichero);
        if(hasMoreData()) {
            processHeaders(getNextData());
        }
        while(hasMoreData()){
            processData(getNextData());
        }
        closeSource();
        return tabla;
    }

}
