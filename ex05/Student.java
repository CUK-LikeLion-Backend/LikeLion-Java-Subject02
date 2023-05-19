package ex05;
import java.io.*;
import java.util.*;

public class Student {
    private List<String> major;
    private List<String> grades;

    public Student() {
        major = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public void openFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String courseName = parts[1].trim();
                String courseType = parts[3].trim();

                if (courseType.equals("전선")) {
                    if (!major.contains(courseName)) {
                        major.add(courseName);
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException("강의 시간표 파일을 열 수 없습니다.");
        }
    }

    public void enterGrade() throws Exception {
        if (major.size() < 3) {
            throw new Exception("수강하는 강의가 3개 미만입니다.");
        }

        try (Scanner scanner = new Scanner(System.in)) {
            for (String course : major) {
                System.out.print("강의 '" + course + "'의 학점을 입력하세요 : ");
                String grade = scanner.nextLine().toUpperCase();

                if (!grade.matches("[ABCDF]")) {
                    throw new Exception("올바른 학점을 입력하세요.");
                }

                grades.add(grade);
            }
        }
    }

    public void saveFile(String fileName) throws Exception {
        if (grades.isEmpty()) {
            throw new IOException("학점을 부여받지 않았습니다.");
        }

        double average = calAverage();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.printf("평균 학점: %.1f%n", average);
        } catch (IOException e) {
            throw new IOException("파일에 접근할 수 없습니다.");
        }
    }

    private double calAverage() throws Exception{
        int sum = 0;
        int countF = 0;

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
                    countF++;
                    break;
            }
        }

        if (countF >= 3) {
            throw new Exception("학사경고: 'F' 학점이 3개 이상입니다.");
        }

        return (double) sum / grades.size();
    }

    public static void main(String[] args) {
        Student student = new Student();

        try {
            student.openFile("C:\\Users\\hyunjin\\hyunjin's\\대외활동\\멋쟁이사자처럼\\백엔드과제\\자바과제(객체지향)\\java_2\\src\\ex05\\input.txt");
            student.enterGrade();
            student.saveFile("C:\\Users\\hyunjin\\hyunjin's\\대외활동\\멋쟁이사자처럼\\백엔드과제\\자바과제(객체지향)\\java_2\\src\\ex05\\output.txt");
        } catch (IOException e) {
            System.out.println("파일 입출력 예외 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

