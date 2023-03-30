package es.uji.al415644.datos;

import java.util.List;
import java.util.Map;

public class RecSys {
    private Algorithm algoritm;
    private Map<String,Integer> estimaciones;
    public RecSys(Algorithm algoritmo){
        this.algoritm = algoritmo;
    }
    public void train(Table trainData) throws Exception {
        algoritm.train(trainData);
    }
    public void run(Table testData, List<String> testItemNames){

    }
    public List<String> recommend(String nameLikedItem, int jumRecommendations){
        return null;
    }

}
