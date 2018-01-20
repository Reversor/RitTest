package ru.reversor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 5_000_000;
        final int MIN = -500_000_000;
        final int MAX = 500_000_000;
        List<Integer> soMuchIntegers = new Random().ints(SIZE, MIN, MAX).boxed().collect(Collectors.toList());

        List<Integer> minimumsIndexes;
        List<Integer> maximumsIndexes;
        final List<Integer> minimums = new ArrayList<>();
        final List<Integer> maximums = new ArrayList<>();
        soMuchIntegers.forEach(el -> {
            if (minimums.isEmpty()) {
                minimums.add(el);
                maximums.add(el);
                return;
            }
            for (int i = 0; i < minimums.size(); i++) {
                if (el < minimums.get(i)) {
                    minimums.add(i, el);
                    break;
                }
            }
            for (int i = 0; i < maximums.size(); i++) {
                if (el > maximums.get(i)) {
                    maximums.add(i, el);
                    break;
                }
            }
            if (minimums.size() > 5) {
                minimums.remove(minimums.size() - 1);
            }
            if (maximums.size() > 5) {
                maximums.remove(maximums.size() - 1);

            }
        });
        minimumsIndexes = minimums.stream().map(soMuchIntegers::indexOf).collect(Collectors.toList());
        maximumsIndexes = maximums.stream().map(soMuchIntegers::indexOf).collect(Collectors.toList());
        System.out.printf("Позиции 5 наименьших: %s\n", minimumsIndexes);
        System.out.printf("Позиции 5 наибольших: %s\n", maximumsIndexes);
    }

}
