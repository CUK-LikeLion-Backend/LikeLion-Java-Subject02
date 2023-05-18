package ex05;

import java.io.*;
import java.util.*;

public class Student {
    private List<String> courseList;
    private List<String> gradeList;

    public void readCourseSchedule(String filename) throws IOException {
        courseList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] courseData = line.split(" ");
                String courseName = courseData[1];
                String courseType = courseData[3];

                if (courseType.equals("전기")||courseType.equals("전선")||courseType.equals("교양")) {
                    if (!courseList.contains(courseName)) {
                        courseList.add(courseName);
                        System.out.println(courseList);
                    } else {
                        throw new IllegalArgumentException("Duplicate course name found: " + courseName);
                    }
                }
            }
        }
    }

    public void assignGrades() {
        gradeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (String course : courseList) {
            System.out.print("Enter grade for course " + course + ": ");
            String grade = scanner.nextLine().toUpperCase();

            if (grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
                gradeList.add(grade);
            } else {
                throw new IllegalArgumentException("Invalid grade received: " + grade);
            }
        }
    }

    public void calculateAverageGrade(String filename) throws IOException {
        if (gradeList == null || gradeList.isEmpty()) {
            throw new IllegalStateException("No grades assigned");
        }

        double sum = 0;
        for (String grade : gradeList) {
            switch (grade) {
                case "A":
                    sum += 4.5;
                    break;
                case "B":
                    sum += 4.0;
                    break;
                case "C":
                    sum += 3.5;
                    break;
                case "D":
                    sum += 3.0;
                    break;
                case "F":
                    sum += 0.0;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid grade received: " + grade);
            }
        }

        double average = sum / gradeList.size();
        double roundedAverage = Math.round(average * 10.0) / 10.0;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.printf("Average Grade: %.1f", roundedAverage);
        }
    }

    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.readCourseSchedule(System.getProperty("user.dir") + "/ex/src/ex05/input.txt");
            System.out.println(student.courseList.size());
            if (student.courseList.size() < 3) {
                throw new IllegalArgumentException("Less than 3 courses enrolled");
            }
            student.assignGrades();
            int countF = Collections.frequency(student.gradeList, "F");
            if (countF >= 3) {
                throw new IllegalArgumentException("Academic warning: 3 or more 'F' grades received");
            }
            student.calculateAverageGrade(System.getProperty("user.dir") + "/ex/src/ex05/output.txt");
            System.out.println("Process completed successfully.");
        } catch (IOException e) {
            System.out.println("Error: File I/O exception occurred.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
