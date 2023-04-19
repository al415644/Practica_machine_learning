package es.uji.al415644.clientes;

import es.uji.al415644.estructuras.Table;
import es.uji.al415644.interfaces.Algorithm;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < testData.tamano(); i++) {
            int num = (int) algoritm.estimate(testData.getRowAt(i).getData());
            this.estimaciones.put(testItemNames.get(i), num);
        }
    }

    public List<String> recommend(String nameLikedItem, int numRecommendations){

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
