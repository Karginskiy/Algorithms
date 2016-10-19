package jmhtests;

import collections.ArrayCollection;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Collection;

@State(value = Scope.Benchmark)
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
