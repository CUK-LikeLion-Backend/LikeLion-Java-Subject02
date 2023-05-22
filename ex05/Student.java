package ex05;

import java.io.*;
import java.util.*;

public class Student {
    private Set<String> enrollClass; // 중복허용하지 않기 위해 Set으로 !
    private Map<String, Double> classGrades;

    public Student(){ // enrollClass를 HashSet으로 초기화
        enrollClass = new HashSet<>();
        classGrades = new HashMap<>();
    }

    // throws IOException :  메소드나 생성자 선언에서 사용되는 예외 처리 방식
    public void enrollClassFile(String fileName) throws IOException, DuplicateCourseException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] classInfo = line.split(" ");
                String courseName = classInfo[1].trim();
                String major = classInfo[3].trim();
                if (major.equalsIgnoreCase("전기") || major.equalsIgnoreCase("전선")) {
                    if (enrollClass.contains(courseName)) {
                        throw new DuplicateCourseException("강의 이름 중복됨");
                    }
                    enrollClass.add(courseName);
                }
            }
        }
    }

    public void grade() throws InvalidGradeException, ExcessiveFailingGradeException, MissingGradeException, AcademicWarningException, IOException {
        classGrades = new HashMap<>(); // classGrades 맵 초기화

        int gradedCourseCount = 0;
        int fCount = 0;
        double totalGrade = 0.0;

        for (String i : enrollClass) {
            System.out.print(i + "과목 학점 입력(A,B,C,D,E,F):");
            Scanner sc = new Scanner(System.in);
            String grade = sc.next();
            double gradeValue;

            if (grade.equals("A")) {
                gradeValue = 4.5;
                totalGrade+=gradeValue;
                gradedCourseCount++;
            } else if (grade.equals("B")) {
                gradeValue = 4.0;
                totalGrade+=gradeValue;
                gradedCourseCount++;
            } else if (grade.equals("C")) {
                gradeValue = 3.5;
                totalGrade+=gradeValue;
                gradedCourseCount++;
            } else if (grade.equals("D")) {
                gradeValue = 3.0;
                totalGrade+=gradeValue;
                gradedCourseCount++;
            } else if (grade.equals("F")) {
                gradeValue = 0.0;
                totalGrade+=gradeValue;
                fCount++;
                gradedCourseCount++;
            } else {
                throw new InvalidGradeException(grade + "는 존재하지 않는 학점으로 예외발생");
            }

            classGrades.put(i, gradeValue); // 학점을 classGrades 맵에 저장

        }

        if (fCount >= 3) {
            throw new ExcessiveFailingGradeException("F가 3개 이상이므로 학사경고로 예외발생");
        }

        if (enrollClass.size() < 3) {
            throw new MissingGradeException("수강하는 강의가 3개미만으로 예외발생");
        }

        double averageGrade = totalGrade / gradedCourseCount;

        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\likelion\\backend\\java\\JAVA_3\\src\\ex05\\output.txt"))) {
            writer.printf("학점: %.1f%n", averageGrade);
        } catch (IOException e) {
            throw new IOException("파일 출력 예외발생");
        }
    }
    public void printEnrollClass() {
        for (String i : enrollClass) {
            System.out.println(i);
        }
    }
    public class DuplicateCourseException extends Exception {
        public DuplicateCourseException(String message) {
            super(message);
        }
    }
    public class InvalidGradeException extends Exception {
        public InvalidGradeException(String message) {
            super(message);
        }
    }
    public class MissingGradeException extends Exception {
        public MissingGradeException(String message) {
            super(message);
        }
    }
    public class ExcessiveFailingGradeException extends Exception {
        public ExcessiveFailingGradeException(String message) {
            super(message);
        }
    }
    public class AcademicWarningException extends Exception {
        public AcademicWarningException(String message) {
            super(message);
        }
    }
    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.enrollClassFile("C:\\likelion\\backend\\java\\JAVA_3\\src\\ex05\\input.txt");
            student.grade();
            student.printEnrollClass();
        } catch (IOException e) {
            System.out.println("파일 입출력에러: " + e.getMessage());
        }catch (DuplicateCourseException e) {
            System.out.println("에러발생 : " + e);
        } catch (InvalidGradeException | MissingGradeException |
                 ExcessiveFailingGradeException | AcademicWarningException e) {
            System.out.println("에러발생 : " + e);
        }
    }
}