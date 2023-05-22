package ex05;

import java.io.*;
import java.util.*;

public class Student {
    private List<String> subjects;
    private List<String> grades;

    public Student() {
        subjects = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    public void printSubjects() throws IOException {
        Set<String> majorSubjects = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\이진수\\IdeaProjects\\LikeLion_6th\\src\\ex05\\input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] subject = line.split(" ");
                String subName = subject[1];
                String courseCategory = subject[3];
                if (courseCategory.equals("전공") && majorSubjects.add(subName)) {
                    System.out.println(subName);
                }
            }
        }
    }

    public void assignGrades() throws Exception {
        for (int i = 0; i < subjects.size(); i++) {
            String subject = subjects.get(i);
            String grade = "";

            if (subject.equals("운영체제")) {
                grade = "A";
            } else if (subject.equals("직무교육개론")) {
                grade = "A";
            } else if (subject.equals("자료구조")) {
                grade = "F";
            } else if (subject.equals("데이터통신")) {
                grade = "F";
            } else if (subject.equals("다변량데이터분석")) {
                grade = "F";
            } else {
                throw new Exception("학점 부여 불가능");
            }

            grades.add(grade);
        }
    }

    public void saveGradeAverage() throws IOException, Exception {
        if (subjects.size() != grades.size()) {
            throw new Exception("모든 강의에 학점을 부여하지 않았습니다.");
        }

        double average = 0.0;
        for (String grade : grades) {
            switch (grade) {
                case "A":
                    average += 4.5;
                    break;
                case "B":
                    average += 4.0;
                    break;
                case "C":
                    average += 3.5;
                    break;
                case "D":
                    average += 3.0;
                    break;
                case "F":
                    average += 0.0;
                    break;
                default:
                    throw new Exception("올바른 학점을 입력하세요.");
            }
        }

        average /= grades.size();
        average = Math.round(average * 10) / 10.0; // 소수점 첫째 자리까지 반올림

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\이진수\\IdeaProjects\\LikeLion_6th\\src\\ex05\\output.txt"))) {
            bw.write(String.valueOf(average));
            System.out.println("학점: " + average);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("error output");
        }
    }
    // F가 3개 이상이면 학사경고로 예외발생
    public void warnings() throws Exception {
        int F = 0;
        for (String grade : grades) {
            if (grade.equals("F")){
                F++;
            }
        }
        if (F >= 3) {
            throw new Exception("학사경고");
        }
    }

    public static void main(String[] args) {
        Student student = new Student();

        // 과목 설정
        List<String> subjects = new ArrayList<>();
        subjects.add("운영체제");
        subjects.add("직무교육개론");
        subjects.add("자료구조");
        subjects.add("데이터통신");
        subjects.add("다변량데이터분석");
        student.setSubjects(subjects);

        try {
            // 학점 부여
            student.assignGrades();

            // 학사 경고 확인
            student.warnings();

            // 수강 과목 출력
            System.out.println("<수강 과목>");
            student.printSubjects();

            // 평균 학점 저장
            student.saveGradeAverage();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
