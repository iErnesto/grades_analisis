package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String name = "";
        int grade = 0;
        int totalGrades = 0;
        double average = 0;
        int minGrade = Integer.MAX_VALUE;
        int maxGrade = 0;


        //  Read names and grades from txt File

        File gradesFile = new File("src/grades.txt");
        Scanner sc = new Scanner(gradesFile);

        //ArrayList with Student object
        ArrayList<Student> list = new ArrayList<Student>();

        while (sc.hasNext()) {

            name = sc.next();
            grade = sc.nextInt();

            //record is an object from Student class to gather the info of grades and names
            Student record = new Student(name, grade);
            list.add(record);
        }
        //Iterating list to get Statics: average, max, min and total.
        for (Student record : list) {
            System.out.println(record);
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

//Class Student which has a constructor with 2 parameters for each value

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
