package ex05;

import java.io.*;
import java.util.*;

public class Student {
    private List <Course> courses;
    public Student() {
        courses = new ArrayList<>();
    }

    private class Course {
        private String name;
        private String category;
        private double grade;
        public Course(String name, String category, double grade) {
            this.name = name;
            this.category = category;
            this.grade = -1.0;
        }

        public Course(String name, String category) {
            this.name = name;
            this.category = category;
        }

        public String getName() {
            return name;
        }
        public String getCategory() {
            return category;
        }
        public double getGrade() {
            return grade;
        }
        public void setGrade(Double grade) {
            this.grade = grade;
        }
    }

    public void loadCourse() throws IOException {
        try(Scanner sc = new Scanner(new File("C:/Users/정유진/Downloads/멋사 JAVA 과제/LikeLion/src/ex05/input.txt"))) {
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] fields = line.split(" ");
                if(fields[3].equals("전선")) {
                    courses.add(new Course(fields[1], fields[4]));
                }
            }
            System.out.println("<  전공 강의 목록  >\n");
            for(Course c : courses) {
                System.out.println(c.getName());
            }
            System.out.println("\n==============================\n");
        }
    }

    public void inputGrade() throws Exception {
        if(courses.size() < 3) {
            throw new Exception("수강 중인 강의 수가 3개 미만입니다.");
        }
        Scanner sc = new Scanner(System.in);
        for(Course c : courses) {
            System.out.print(c.getName() + "의 학점을 입력하세요 : ");
            String grade = sc.nextLine().toUpperCase();
            switch(grade) {
                case "A" :
                    c.setGrade(4.5);
                    break;
                case "B" :
                    c.setGrade(4.0);
                    break;
                case "C" :
                    c.setGrade(3.5);
                    break;
                case "D" :
                    c.setGrade(3.0);
                    break;
                case "F" :
                    c.setGrade(0.0);
                    break;
                default :
                    throw new Exception("잘못된 입력입니다.");
            }
        }
        System.out.println("");
    }

    public void calculateGradeAverage () throws Exception {
        double sum = 0.0;
        int numF = 0;
        for(Course c : courses) {
            if(c.getGrade() == -1.0) {
                throw new Exception(c.getName() + "에 대한 학점이 입력되지 않았습니다.");
            }
            sum += c.getGrade();
            if(c.getGrade() == 0.0) numF++;
        }
        double average = sum / courses.size();
        String result = "\n학점 평균 : " + String.format("%.1f", average);
        System.out.println(result);
        File file = new File("C:/Users/정유진/Downloads/멋사 JAVA 과제/LikeLion/src/ex05/output.txt");
        if(numF >= 3) {
            throw new Exception("F 학점이 3개 이상이므로 학사 경고에 해당합니다.");
        }
        try(Writer writer = new FileWriter(file)) {
            writer.write(result);
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.loadCourse();
            student.inputGrade();
            student.calculateGradeAverage();
        }
        catch (IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }
}
