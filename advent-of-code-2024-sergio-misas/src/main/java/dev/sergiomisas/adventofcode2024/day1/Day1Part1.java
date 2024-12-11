package dev.sergiomisas.adventofcode2024.day1;

import dev.sergiomisas.adventofcode2024.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        return calculteTotalDistance(distances);
    }

    private static void classifyNumbers(List<Integer> leftNums, List<Integer> rightNums, String input) {
        input.lines().forEach(line -> {
            String[] split = line.split(" {3}");
            leftNums.add(Integer.valueOf(split[0]));
            rightNums.add(Integer.valueOf(split[1]));
        });
    }

    private static void orderNumbers(List<Integer> leftNums, List<Integer> rightNums) {
        Collections.sort(leftNums);
        Collections.sort(rightNums);
    }

    private static List<Integer> calculateDistances(List<Integer> leftNums, List<Integer> rightNums) {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < leftNums.size(); i++) {
            distances.add(Math.abs(leftNums.get(i) - rightNums.get(i)));
        }
        return distances;
    }

    private static int calculteTotalDistance(List<Integer> distances) {
        int total = 0;
        for (int i = 0; i < distances.size(); i++) {
            total += distances.get(i);
        }
        return total;
    }
}


