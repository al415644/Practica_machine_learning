package es.uji.al415644.datos;

import java.util.ArrayList;

public interface Algorithm <T extends Table,U,W>{
        void train(T tabla) throws Exception;
        W estimate(U obj);
}
