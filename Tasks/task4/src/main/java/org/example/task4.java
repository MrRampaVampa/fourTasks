package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }

        String inputFilePath = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int sum = 0;
            int max = Integer.MIN_VALUE;

            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                sum += num;
                if (num > max) {
                    max = num;
                }
            }

            int n = sum / 2;
            int result = n * 2 - sum + max;

            System.out.println("Minimum number of moves: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
