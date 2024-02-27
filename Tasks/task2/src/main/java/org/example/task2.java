package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
   //Прошу прощения, задача выполняется корректно, но я поздно понял, что это означает "Параметры передаются в качестве аргументов командной строки!"
    // До этого не использовал такие методы передачи данных в класс для будущей реализации

    String pathFile1 = "";
    String pathFile2 = "";
    double circleX = 0;
    double circleY = 0;
    double radius = 0;
    double pointX = 0;
    double pointY = 0;

    public task2(String pathFile1, String pathFile2) {
        this.pathFile1 = pathFile1;
        setFile1(pathFile1);
        this.pathFile2 = pathFile2;
        setFile2(pathFile2);
    }

    public void setFile1(String pathFile1) {
        try {
            Scanner scanner = new Scanner(new File(pathFile1));
            circleX = scanner.nextInt();
            circleY = scanner.nextInt();
            radius = scanner.nextInt();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        }
    }

    public void setFile2(String pathFile2) {
        try {
            Scanner scanner = new Scanner(new File(pathFile2));
            pointX = scanner.nextInt();
            pointY = scanner.nextInt();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        }
    }

    public int getPointPosition() {
        double distanceSquare = Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2);
        double radiusSquare = Math.pow(radius, 2);

        if (distanceSquare > radiusSquare) {
            return 2;
        } else if (distanceSquare < radiusSquare) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        task2 taskClass = new task2("C:\\Users\\user\\Desktop\\File1.txt", "C:\\Users\\user\\Desktop\\File2.txt");
        System.out.println(taskClass.getPointPosition());

    }
}
