package dev.sergiomisas.adventofcode2024.day2;

import dev.sergiomisas.adventofcode2024.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Day2Part1 {
    public static void main(String[] args) {
        String input = Utils.readFile("src/main/java/dev/sergiomisas/adventofcode2024/day2/input.txt");

        System.out.println(solve(input));
    }

    private static int solve(String input) {
        List<List<Integer>> reports = Arrays.stream(input.split("\n"))
                .map(report -> report.split(" "))
                .map(report -> Arrays.stream(report).mapToInt(Integer::valueOf).boxed().toList())
                .toList();

        return calculateSafeReports(reports);


    }

    private static int calculateSafeReports(List<List<Integer>> reports) {
        int safeReports = 0;

        for (List<Integer> report : reports) {
            if (isOrderIncremental(report)) {
                safeReports += calculateSafeIncrement(report);
            } else safeReports += calculateSafeDecrement(report);
        }

        return safeReports;
    }

    private static boolean isOrderIncremental(List<Integer> report) {
        return report.get(0) < report.get(1);
    }

    private static int calculateSafeIncrement(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) >= report.get(i + 1)
            || report.get(i) + 3 < report.get(i + 1)
            ) return 0;
        }
        return 1;
    }

    private static int calculateSafeDecrement(List<Integer> report) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (report.get(i) <= report.get(i + 1)
                    || report.get(i) - 3 > report.get(i + 1)
            ) return 0;
        }
        return 1;
    }

}
