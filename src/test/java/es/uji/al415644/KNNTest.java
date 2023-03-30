package es.uji.al415644;

import jdk.internal.icu.text.UnicodeSet;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class KNNTest {

    @Test
    Object estimate(UnicodeSet sample) {
        KNNTest prueba = null;
        sample = null;
        sample.add (8);
        sample.add (0);
        sample.add (4);
        sample.add (5);
        assertEquals(1, prueba.estimate(sample));
        return null;
    }

    @Test
    void distancia() {
        KNNTest prueba = null;
        UnicodeSet sample = null;
        sample.add (3);
        sample.add (5);
        sample.add (8);
        sample.add (0);
        assertEquals (4, prueba.estimate (sample));
    }
}