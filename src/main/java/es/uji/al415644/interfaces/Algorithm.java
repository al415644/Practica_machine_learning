package es.uji.al415644.interfaces;

import es.uji.al415644.estructuras.Table;

public interface Algorithm <T extends Table,U,W>{
        void train(T tabla) throws Exception;
        W estimate(U obj);
}
