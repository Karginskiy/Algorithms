package jmhtests;

import collections.ArrayCollection;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Collection;

public class ArrayCollectionTest {

    @Benchmark
    public void addTest() {
        Collection<Integer> collection = new ArrayCollection<>();

        int iterations = 10000;

        for(int i = 0; i < iterations; i++) {
            collection.add(i);
        }

    }

}
