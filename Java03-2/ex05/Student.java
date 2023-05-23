package ex05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class Student {
    private Set<String> courses;
    private List<Double> scores;

    public Student() {
        courses = new HashSet<>();
        scores = new ArrayList<>();
    }

    public void readCourseSchedule(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                String courseName = data[1];
                String courseType = data[3];
                if (courseType.equals("전선") || courseType.equals("전기")) {
                    courses.add(courseName);
                }
            }
        }
    }

    public void assignGrades() throws Exception {
        if (courses.size() < 3) {
            throw new Exception("수강 강의가 3개 미만입니다.");
        }

        for (String course : courses) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(course + " 학점 입력: ");
            String grade = scanner.next();
            double score = assignGrade(grade);
            scores.add(score);
        }
    }

    private double assignGrade(String grade) throws Exception {
        double score;
        switch (grade) {
            case "A":
                score = 4.5;
                break;
            case "B":
                score = 4.0;
                break;
            case "C":
                score =3.5;
                break;
            case "D":
                score = 3.0;
                break;
            case "F":
                score = 0.0;
                break;
            default:
                throw new Exception("잘못된 학점이 부여되었습니다.");
        }

        return score;
    }

    public void calculateAverageGrade(String fileName) throws IOException, Exception {
        if (scores.size() == 0) {
            throw new Exception("학점을 부여받지 않은 강의가 존재합니다.");
        }

        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }

        double average = sum / scores.size();
        double roundedAverage = Math.round(average * 10) / 10.0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("평균 학점: " + roundedAverage);
        }
    }

    public void checkAcademicWarning() throws Exception {
        int count = 0;
        for (double score : scores) {
            if (score == 0.0) {
                count++;
            }
        }

        if (count >= 3) {
            throw new Exception("학사 경고를 받았습니다.");
        }
    }

    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.readCourseSchedule("\\\\wsl$\\Ubuntu\\root\\LikeLion-Java-Subject00\\Java03\\src\\ex05\\input.txt");
            student.assignGrades();
            student.checkAcademicWarning();
            student.calculateAverageGrade("\\\\wsl$\\Ubuntu\\root\\LikeLion-Java-Subject00\\Java03\\src\\ex05\\output.txt");
            System.out.println("작업이 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 입출력 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
}

