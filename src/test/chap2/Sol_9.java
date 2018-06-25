package test.chap2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Sol_9 {
    @Test
    public void testListMerge() {

    }

    private <T> ArrayList<T> mergeOne(Stream<ArrayList<T>> arrStream) {
        return arrStream.flatMap(Arrays::)
    }
}
