package ru.reversor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 5_000_000;
        final int MIN = -500_000_000;
        final int MAX = 500_000_000;
        List<Integer> soMuchIntegers = new Random().ints(SIZE, MIN, MAX).boxed().collect(Collectors.toList());

        Map<Integer, Integer> minimums;
        Map<Integer, Integer> maximums;
        final List<Integer> minValues = new ArrayList<>();
        final List<Integer> maxValues = new ArrayList<>();
        soMuchIntegers.forEach(el -> {
            if (minValues.size() < 5) {
                minValues.add(el);
                maxValues.add(el);
                return;
            }
            for (int i = 0; i < minValues.size(); i++) {
                if (el < minValues.get(i)) {
                    minValues.add(i, el);
                    break;
                }
            }
            for (int i = 0; i < maxValues.size(); i++) {
                if (el > maxValues.get(i)) {
                    maxValues.add(i, el);
                    break;
                }
            }
            if (minValues.size() > 5) {
                minValues.remove(minValues.size() - 1);
            }
            if (maxValues.size() > 5) {
                maxValues.remove(maxValues.size() - 1);

            }
        });
        minimums = minValues.stream().collect(Collectors.toMap(soMuchIntegers::indexOf, el -> el));
        maximums = maxValues.stream().collect(Collectors.toMap(soMuchIntegers::indexOf, el -> el));
        System.out.printf("5 наименьших: %s\n", minimums);
        System.out.printf("5 наибольших: %s\n", maximums);
    }

}
