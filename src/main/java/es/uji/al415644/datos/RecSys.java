package es.uji.al415644.datos;

import java.util.*;

public class RecSys{
    private Algorithm algoritm;
    private Map<String,Integer> estimaciones;
    public RecSys(Algorithm algoritmo){
        this.algoritm = algoritmo;
        this.estimaciones = new HashMap<>();
    }

    public void train(Table trainData) throws Exception {
        algoritm.train(trainData);
    }

    public void run(Table testData, List<String> testItemNames){
        llenarMapa(testData, testItemNames);
    }

    private void llenarMapa(Table testData, List<String> testItemNames){
        for (int i = 0; i < testData.tamano(); i++) {
            int num = (int) algoritm.estimate(testData.getRowAt(i));
            this.estimaciones.put(testItemNames.get(i), num);
        }
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations){

        ArrayList<String> devolver = crearLista(nameLikedItem, numRecommendations);
        return devolver;
    }

    private ArrayList<String> crearLista(String nameLikedItem, int numRecommendations){
        int codigo_grupo = estimaciones.get(nameLikedItem);
        ArrayList<String> keys = (ArrayList<String>) estimaciones.keySet();
        ArrayList<Integer> values = (ArrayList<Integer>) estimaciones.values();
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(codigo_grupo) && lista.size()<numRecommendations){
                lista.add(keys.get(i));
            }
        }
        return lista;
    }
}
