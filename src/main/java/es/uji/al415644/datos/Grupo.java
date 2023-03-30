package es.uji.al415644.datos;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private int numero;
    private List<Double> representante;
    private List<Row> miembros = new ArrayList<>();

    public Grupo(int numero){
        representante = new ArrayList<>();
        miembros = new ArrayList<>();
        this.numero = numero;
    }
    public void add(Row miembro){
        miembros.add(miembro);
    }
    public void addRep(List<Double> repre){
        this.representante = repre;
    }
    public List<Row> GetListaMiembros(){
        return miembros;
    }
}
