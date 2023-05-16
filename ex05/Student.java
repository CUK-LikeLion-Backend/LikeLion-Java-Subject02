package ex05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {


    private String name;
    private List<String> majorCourses = new ArrayList<>();
    private List<String> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void takeMajorCourses(String filePath) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] course = line.split(" ");
                if (course[3].equals("전공")) {
                    majorCourses.add(course[1]);
                }
            }
        }
        if (majorCourses.size() < 3) {
            throw new IOException("수강해야 할 전공 강의 개수는 3개 이상이어야 합니다.");
        }
    }

    public void assignGrades() throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (String course : majorCourses) {
            System.out.println(course + "의 학점을 부여하세요. (A, B, C, D, F)");
            String grade = scanner.nextLine().toUpperCase();
            if (!grade.equals("A") && !grade.equals("B") && !grade.equals("C") && !grade.equals("D") && !grade.equals("F")) {
                throw new IOException("잘못된 학점이 입력되었습니다. A, B, C, D, F 중에서 입력해주세요.");
            }
            grades.add(grade);
        }
        int numFs = 0;
        for (String grade : grades) {
            if (grade.equals("F")) {
                numFs++;
            }
        }
        if (numFs >= 3) {
            throw new IOException("수강한 전공 강의 중 3개 이상이 F학점입니다.");
        }
    }

    public void saveGradeAverage(String filePath) throws IOException {
        double sum = 0;
        for (String grade : grades) {
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
                    break;
            }
        }
        double average = sum / grades.size();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("학점: " + String.format("%.1f", average));
        }
    }

        public static void main(String[] args) {
            String fileName = "/Users/seunghee/input.txt";
            String outputFileName = "/Users/seunghee/output.txt";

            Student student = new Student("조이");

            try {
                student.takeMajorCourses(fileName);
                student.assignGrades();
                student.saveGradeAverage(outputFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

