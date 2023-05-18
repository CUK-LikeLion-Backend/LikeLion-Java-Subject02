package ex05;

import java.io.*;
import java.util.*;

public class Student {
    private HashMap<String, Double> courseGrades;
    private String filePath = System.getProperty("user.home") + "/Desktop/23-1 semester/Spring/LikeLionWeek11/src/ex05/input.txt";
    private String filePath1 = System.getProperty("user.home")+"/Desktop/23-1 semester/Spring/LikeLionWeek11/src/ex05/output.txt";


    public Student() {
        courseGrades = new HashMap<>();
    }

    public void timeTable() {
        File file = new File(filePath);
        try (Scanner sc = new Scanner(file)) {
            List<String> courseNames = new ArrayList<>();
            while (sc.hasNextLine()) {
                String lecture[] = sc.nextLine().split(" ");
                String classNum = lecture[0];
                String className = lecture[1];
                String divisonNum = lecture[2];
                String major = lecture[3];
                String professorName = lecture[4];

                if (major.equals("전기") || major.equals("전선")) {
                    if (!courseNames.contains(className)) {
                        System.out.println(className);
                        courseNames.add(className);
                        double grade = Score();  // 학점 부여
                        courseGrades.put(className, grade);  // 과목과 학점 매핑
                    } else {
                        System.out.println(className + "이 중복입니다.");
                    }
                } else {
                    System.out.println(className + "강의가 전공 수업이 아닙니다.");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double averageGrade = calculateAverageGrade();  // 학점 평균 계산
        gradeSave(averageGrade);  // 결과를 파일에 저장
    }

    private double Score() {
        Random random = new Random();
        double score;
        int index = random.nextInt(5);
        String grades[] = {"A", "B", "C", "D", "F"};
        String grade = grades[index];
        switch (grade){
            case "A":
                score = 4.5;
                break;
            case "B":
                score = 4.0;
                break;
            case "C":
                score = 3.5;
                break;
            case "D":
                score = 3.0;
                break;
            case "F":
                score = 0.0;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 학점입니다.");
        }
        return score;
    }

    private double calculateAverageGrade() {
        double sum = 0.0;
        for (double grade : courseGrades.values()) {
            sum += grade;
        }
        return sum / courseGrades.size();
    }

    private void gradeSave(double averageGrade) {
        try (FileWriter fw = new FileWriter(filePath1)) {
            fw.write(String.format("학점: %.1f", averageGrade));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("파일을 저장하는 동안 오류가 발생하였습니다.");
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.timeTable();
    }
}
