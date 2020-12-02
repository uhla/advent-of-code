package adventofcode.v2020;


import adventofcode.DailyTask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 implements DailyTask {


    public void execute() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("C:\\uhl-tmp\\git\\advent-of-code\\src\\main\\resources\\aoc-inputs\\day1.input"), StandardCharsets.UTF_8);
        List<Integer> numbers = lines.stream().map(Integer::parseInt).sorted(Integer::compareTo).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {
                        System.out.println(numbers.get(k) + " " + numbers.get(j) + " " + numbers.get(i));
                        System.out.println(numbers.get(i) * numbers.get(j) * numbers.get(k));
                        return;
                    }
                }
            }
        }
    }
}
