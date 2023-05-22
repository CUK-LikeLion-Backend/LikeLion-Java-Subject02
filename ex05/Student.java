package ex05;
//예외처리
//1. 강의명 중복 x
//2. 수강하는 강의가 3개 미만
//3. 학점 A B C D F 이외는 예외
//4. 전체성적에서 F가 3개 이상이면 학사경고

import java.io.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String filepath = "C:\\Users\\MJSeo\\Desktop\\자바과제3\\JAVA3\\src\\ex05\\input.txt";
        public Student(String filepath){
            this.filepath = filepath;
        }

    public void mytimetable() throws IOException {
        String line;
        Set<String> majorCourses = new HashSet<>();
        boolean duplicateFound = false;
        int cnt = 0;

        File file = new File(filepath);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] lec = sc.nextLine().split(" ");
                String num = lec[0];
                String name = lec[1];
                String grade = lec[2];
                String major = lec[3];
                String processor = lec[4];
                cnt ++;

                //전공강의인 경우 출력
                if (major.equals("전기") || major.equals("전선") || major.equals("전필")) {
                    if (majorCourses.contains(name)) {
                        duplicateFound = true;
                        break;
                    }
                    System.out.printf("%s %s %s %s %s\n", num, name, grade, major, processor);
                    majorCourses.add(name);
                }
            }
            if (duplicateFound) {
                throw new IOException("전공 강의가 중복되었습니다.");
            }

            if (cnt < 3){
                throw new IOException("수강하는 강의가 3개 미만입니다");
            }
        }
    }

    public double score() throws IOException {
        File file = new File(filepath);
        Scanner fileScanner = new Scanner(file);
        Scanner sc = new Scanner(System.in);

        double totalGrade = 0.0;
        int numCourses = 0;
        int fGrade = 0;

        String line;
        while (fileScanner.hasNextLine()) {
            String[] lec = fileScanner.nextLine().split(" ");
            String num = lec[0];
            String name = lec[1];
            String grade = lec[2];
            String major = lec[3];
            String processor = lec[4];

            System.out.println("학점을 입력해주세요");
            System.out.printf("%s: ", name);
            grade = sc.next();
            double score;

            switch (grade) {
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
            totalGrade += score;
            numCourses++;

            if (grade.equals("F")) {
                fGrade++; }

            if (fGrade >= 3){
                throw new IOException("***학사경고!!!***"); }
        }
            return totalGrade / numCourses;
    }

    private void writeScore(double avgGrade) {
        try (FileWriter fw = new FileWriter("C:\\Users\\MJSeo\\Desktop\\자바과제3\\JAVA3\\src\\ex05\\output.txt")) {
            fw.write(String.format("학점: %.1f", avgGrade));
        } catch (IOException e) {
            throw new RuntimeException("오류!!!");
        }
    }

    public static void main(String[] args) throws IOException {
            String filePath = "C:\\Users\\MJSeo\\Desktop\\자바과제3\\JAVA3\\src\\ex05\\input.txt";
            Student student = new Student(filePath);

            try{
                student.mytimetable();
                System.out.println("-----------------");
                student.writeScore(student.score());
            }catch (Exception e){
                System.out.println("오류발생: " +e.getMessage());
            }
    }
}