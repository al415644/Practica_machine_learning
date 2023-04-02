package es.uji.al415644.datos;

import java.util.*;
import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.lang.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            int num = (int) algoritm.estimate(testData.getRowAt(i).getData());
            this.estimaciones.put(testItemNames.get(i), num);
        }
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations){

        ArrayList<String> devolver = crearLista(nameLikedItem, numRecommendations);
        return devolver;
    }

    private ArrayList<String> crearLista(String nameLikedItem, int numRecommendations){
        int codigo_grupo = estimaciones.get(nameLikedItem);
        ArrayList<String> lista = new ArrayList<>();
        Iterator<String> it = estimaciones.keySet().iterator();
        while(it.hasNext() && numRecommendations> lista.size()){
            String name = it.next();
            if(name != nameLikedItem && estimaciones.get(name)==codigo_grupo){
                lista.add(name);
            }
        }
        return lista;
    }
    public Map<String, Integer> getEstimaciones(){
        return estimaciones;
    }

}
