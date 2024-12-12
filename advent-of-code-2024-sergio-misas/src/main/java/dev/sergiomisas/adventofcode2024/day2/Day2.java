package dev.sergiomisas.adventofcode2024.day2;

import dev.sergiomisas.adventofcode2024.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
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

        // False for day 1 True for day 2
        boolean isDampenerActive = false;

        for (List<Integer> report : reports) {
            if (isOrderIncremental(report)) {
                safeReports += calculateSafeIncrement(report, isDampenerActive);
            } else safeReports += calculateSafeDecrement(report, isDampenerActive);
        }

        return safeReports;
    }

    private static boolean isOrderIncremental(List<Integer> report) {
        int sumOfDifferences = 0;

        for (int i = 0; i < report.size() - 1; i++) {
            sumOfDifferences += report.get(i + 1) - report.get(i);
        }

        if (sumOfDifferences > 0) return true;
        return false;
    }

    private static int calculateSafeIncrement(List<Integer> report, boolean isDampenerActive) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (isIncrementError(report, i)
            ) {
                if (!isDampenerActive) return 0;

                List<Integer> copy = new ArrayList<>(report);
                copy.remove(i + 1);

                return calculateSafeIncrement(copy, false);
            }
        }
        return 1;
    }

    private static boolean isIncrementError(List<Integer> report, int i) {
        return report.get(i) >= report.get(i + 1)
                || report.get(i) + 3 < report.get(i + 1);
    }

    private static int calculateSafeDecrement(List<Integer> report, boolean isDampenerActive) {
        for (int i = 0; i < report.size() - 1; i++) {
            if (isDecrementError(report, i)
            ) {
                if (!isDampenerActive) return 0;

                List<Integer> copy = new ArrayList<>(report);
                copy.remove(i + 1);

                return calculateSafeDecrement(copy, false);
            }
        }
        return 1;
    }

    private static boolean isDecrementError(List<Integer> report, int i) {
        return report.get(i) <= report.get(i + 1)
                || report.get(i) - 3 > report.get(i + 1);
    }

}
