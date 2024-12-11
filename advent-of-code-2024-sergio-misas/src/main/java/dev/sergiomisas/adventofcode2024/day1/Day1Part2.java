package dev.sergiomisas.adventofcode2024.day1;

import dev.sergiomisas.adventofcode2024.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static dev.sergiomisas.adventofcode2024.day1.Commons.classifyNumbers;
import static dev.sergiomisas.adventofcode2024.day1.Commons.orderNumbers;

public class Day1Part2 {
    public static void main(String[] args) {
        String input = Utils.readFile("src/main/java/dev/sergiomisas/adventofcode2024/day1/input.txt");

        int solution = solve(input);

        System.out.println(solution);
    }

    private static int solve(String input) {
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();

        classifyNumbers(leftNums, rightNums, input);

        orderNumbers(leftNums, rightNums);

        List<Integer> similarities = calculateSimilarities(leftNums, rightNums);

        return similarities.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> calculateSimilarities(List<Integer> leftNums, List<Integer> rightNums) {
        return leftNums.stream().map(num -> {
            if (rightNums.contains(num)) {
                long times = rightNums.stream().filter(rightNum -> Objects.equals(rightNum, num)).count();
                return (int) times * num;
            } else return 0;
        }).toList();
    }
}
