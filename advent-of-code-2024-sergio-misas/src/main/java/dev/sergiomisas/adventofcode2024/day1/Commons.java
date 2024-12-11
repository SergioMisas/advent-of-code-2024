package dev.sergiomisas.adventofcode2024.day1;

import java.util.Collections;
import java.util.List;

class Commons {
    private Commons() {
    }

    static void classifyNumbers(List<Integer> leftNums, List<Integer> rightNums, String input) {
        input.lines().forEach(line -> {
            String[] split = line.split(" {3}");
            leftNums.add(Integer.valueOf(split[0]));
            rightNums.add(Integer.valueOf(split[1]));
        });
    }

    static void orderNumbers(List<Integer> leftNums, List<Integer> rightNums) {
        Collections.sort(leftNums);
        Collections.sort(rightNums);
    }
}
