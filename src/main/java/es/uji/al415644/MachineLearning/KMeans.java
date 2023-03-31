package es.uji.al415644.MachineLearning;

import es.uji.al415644.datos.*;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.lang.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans<T,U,W> implements Algorithm<Table,List<Double>,Integer> {

    private Table datos;
    private List<List<Double>> representantes;
    private List<Grupo> grupos;
    private int numClusters;
    private int numIterations;
    private long  seed;
    public KMeans(int numClusters, int numIterations, long seed){
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
        this.representantes = new ArrayList<>();
        this.grupos = new ArrayList<>();
    }
    public void train(Table datos) throws Exception {
        if(datos.tamano() < numClusters){
            throw new Exception("Mas datos que grupos aweonao");
        }
        this.datos = datos;
        List<Integer> numeros_rep = new ArrayList<>();
        Random random = new Random(seed);
        numeros_rep.add(random.nextInt(datos.tamano()));
        for (int i = 1; i < numClusters; i++) {
            int num =  random.nextInt(datos.tamano());
            while (numeros_rep.contains(num)) {
                num =  random.nextInt(datos.tamano());
            }
            numeros_rep.add(num);
        }
        for (int i = 0; i < numeros_rep.size(); i++) {
            representantes.add(datos.getRowAt(numeros_rep.get(i)));
        }
        for (int i = 0; i < numClusters; i++) {
            grupos.add(new Grupo(i));
        }
        for (int i = 0; i < numIterations; i++) {
            for (int j = 0; j < numClusters; j++) {
                grupos.get(j).addRep(representantes.get(j));
            }
            for (int k = 0; k < datos.tamano(); k++) {
                int num = estimate(datos.getRowAt(k));
                grupos.get(num).add(datos.getRowRow(k));
            }
            for (int l = 0; l < grupos.size(); l++) {
                representantes.set(l,centroide(grupos.get(l)));
            }
            for (int j = 0; j < numClusters; j++) {
                grupos.get(j).addRep(representantes.get(j));
            }
        }

    }
    public Integer estimate(List<Double> dato_comparar){

        int grupo = 0;
        List<Double> distancia = new ArrayList<>();

        for(int i = 0; i < numClusters; i++){
            double sumaEuclidea = 0;
            List<Double> representante = this.datos.getRowAt(i);
            for(int j=0; j<dato_comparar.size(); j++){
                sumaEuclidea += Math. pow ((representante.get(i) - dato_comparar.get(i)), 2);
            }
            sumaEuclidea = Math.sqrt(sumaEuclidea);
            distancia.add(sumaEuclidea);
        }
        for (int i = 0; i < distancia.size(); i++) {
            if(distancia.get(i)<distancia.get(grupo)){
                grupo = i;
            }
        }

        return grupo;
    }
    public List<Double> centroide(Grupo grupo){
        List<Double> resp = new ArrayList<>();
        for (int i = 0; i < grupo.GetListaMiembros().get(0).getData().size(); i++) {
            double total = 0;
            for (int j = 0; j < grupo.GetListaMiembros().size(); j++) {
                total += grupo.GetListaMiembros().get(j).getData().get(i);
            }
            double media = total/grupo.GetListaMiembros().size();
            resp.add(media);

        }
        return resp;
    }

    public List<List<Double>> getRepresentantes(){
        return representantes;
    }
}
