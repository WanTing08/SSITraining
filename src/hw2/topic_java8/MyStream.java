package hw2.topic_java8;

import java.util.ArrayList;
import java.util.List;

public class MyStream {
    @FunctionalInterface
    interface MyFunction<I, O>{
        O apply(I i);
    }

    static <I, O> List<O> myMap(List<I> list, MyFunction<I, O> myFunction){
        List<O> result = new ArrayList<>();
        for(I i : list){
            O mapped = myFunction.apply(i);
            result.add(mapped);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> mapped = myMap(list, o -> o * 3);
        System.out.println(mapped);
    }
}
