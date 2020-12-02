package adventofcode.v2020;


import adventofcode.DailyTask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 implements DailyTask {


    public void execute() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\uhl-tmp\\git\\advent-of-code\\src\\main\\resources\\aoc-inputs\\day2.input"), StandardCharsets.UTF_8);

        int validCount = 0;
        for (String line : lines) {
            String[] lineDefinition = line.split(" ");
            char character = lineDefinition[1].substring(0, 1).charAt(0);
            String[] range = lineDefinition[0].split("-");
            String password = lineDefinition[2];

//            validCount = countTask1(validCount, character, range, password);
            validCount = countTask2(validCount, character, range, password);

        }
        System.out.println(validCount);
    }

    private int countTask2(int validCount, char character, String[] range, String password) {
        if ((password.charAt(Integer.parseInt(range[0]) - 1) == character && password.charAt(Integer.parseInt(range[1]) - 1) != character) || (password.charAt(Integer.parseInt(range[0]) - 1) != character && password.charAt(Integer.parseInt(range[1]) - 1) == character)) {
            validCount++;
        }
        return validCount;
    }

    private int countTask1(int validCount, char character, String[] range, String password) {
        long count = password.chars().filter(c -> c == character).count();
        if (count >= Long.parseLong(range[0]) && count <= Long.parseLong(range[1])) {
            validCount++;
        }
        return validCount;
    }
}
