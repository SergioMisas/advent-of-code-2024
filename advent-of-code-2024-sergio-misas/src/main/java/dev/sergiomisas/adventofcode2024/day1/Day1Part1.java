package dev.sergiomisas.adventofcode2024.day1;

import dev.sergiomisas.adventofcode2024.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static dev.sergiomisas.adventofcode2024.day1.Commons.classifyNumbers;
import static dev.sergiomisas.adventofcode2024.day1.Commons.orderNumbers;

public class Day1Part1 {
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

        List<Integer> distances = calculateDistances(leftNums, rightNums);

        return distances.stream().reduce(0, Integer::sum);
    }

    private static List<Integer> calculateDistances(List<Integer> leftNums, List<Integer> rightNums) {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < leftNums.size(); i++) {
            distances.add(Math.abs(leftNums.get(i) - rightNums.get(i)));
        }
        return distances;
    }

}


