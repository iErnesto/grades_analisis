package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        String name = "";
        int grade = 0;
        int totalGrades = 0;
        double average = 0;
        int minGrade = Integer.MAX_VALUE;
        int maxGrade = 0;


        //Creating Maps
        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();

        // 1) Read names and grades
        File gradesFile = new File("src/grades.txt");
        Scanner sc = new Scanner(gradesFile);

        ArrayList<Student> list = new ArrayList<Student>(); //ArrayList with Student class

        while (sc.hasNext()) {
            name = sc.next();
            grade = sc.nextInt();

            Student record = new Student(name, grade);
            list.add(record);


        }
        //System.out.printf(String.valueOf(list));

        for (Student record : list) {
            System.out.println(record);
            //System.out.println(record.getName());
            totalGrades = totalGrades + record.getGrade();
            if (record.getGrade() > maxGrade) {
                maxGrade = record.getGrade();
            }
            if (record.getGrade() < minGrade) {
                minGrade = record.getGrade();
            }


        }

        average = totalGrades / list.size();
        System.out.println("Total: " + totalGrades);
        System.out.println("Average: " + average);
        System.out.println("MaxGrade: " + maxGrade);
        System.out.println("MinGrade: " + minGrade);

        sc.close();
    }
}


class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Output of the results
    public String toString() {
        return "Name: " + name + " Grade: " + grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
