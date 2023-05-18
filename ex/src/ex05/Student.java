package ex05;

import java.io.BufferedReader; //속도가 무지빠르다
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private static final String INPUT_FILE_PATH = System.getProperty("user.dir") + "/ex/src/ex05/input.txt";
    private static final String OUTPUT_FILE_PATH = System.getProperty("user.dir") + "/ex/src/ex05/output.txt";

    private ArrayList<String> courseList = new ArrayList<>();
    private HashMap<String, Double> gradeMap = new HashMap<>();
    //key, value 값 쌍이 있는 ArrayList
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.readCourseList(); // 강의 시간표 파일 읽기
            student.takeCourses(); // 전공 강의 수강하기
            HashMap<String, String> gradeMap = new HashMap<>(); //배열 생성
            // 각 강의별 학점 부여하기
            // HashMap의 key에는 강의명을, value에는 학점을 입력합니다.
            gradeMap.put("운영체제", "A+");
            gradeMap.put("데이터통신", "B");
            gradeMap.put("자료구조기초", "B");
            gradeMap.put("자료구조", "B+");
            student.assignGrades(gradeMap);
            student.writeGradeAverageToFile(); // 평균 학점 저장하기
            System.out.println("강의 수강 및 성적 부여가 완료되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readCourseList() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(" "); //공백 기준으로 배열에 저장
            String courseName = fields[1];
            String professorName = fields[3];
            if (!professorName.equals("전공")) {
                continue;
            }
            if (courseList.contains(courseName)) {
                throw new Exception("Duplicate course name");
            }
            courseList.add(courseName);
        }
        reader.close();

        if (courseList.size() < 3) {
            throw new Exception("Less than 3 courses");
        }
    }

    public void takeCourses() {
        System.out.println("수강할 강의 목록:");
        for (String course : courseList) {
            System.out.println(course);
        }
    }

    public void assignGrades(HashMap<String, String> gradeMap) throws Exception {
        if (gradeMap.size() != courseList.size()) {
            throw new Exception("Missing grades");
        }

        for (String course : courseList) {
            String gradeStr = gradeMap.get(course);
            if (gradeStr == null) {
                throw new Exception("Missing grade for course: " + course);
            }
            char grade = gradeStr.charAt(0);
            double gpa;
            switch (grade) {
                case 'A':
                    gpa = 4.5;
                    break;
                case 'B':
                    gpa = 4.0;
                    break;
                case 'C':
                    gpa = 3.5;
                    break;
                case 'D':
                    gpa = 3.0;
                    break;
                case 'F':
                    gpa = 0.0;
                    break;
                default:
                    throw new Exception("Invalid grade: " + grade);
            }
            this.gradeMap.put(course, gpa);
        }
    }

    public void writeGradeAverageToFile() throws Exception {
        if (gradeMap.size() != courseList.size()) {
            throw new Exception("Missing grades");
        }

        double totalGpa = 0.0;
        int numCourses = 0;
        int numFailures = 0;
        for (String course : courseList) {
            Double gpa = gradeMap.get(course);
            if (gpa == null) {
                throw new Exception("Missing grade for course: " + course);
            }
            totalGpa += gpa;
            numCourses++;
            if (gpa == 0.0) {
                numFailures++;
            }
        }

        if (numCourses < 3) {
            throw new Exception("Less than 3 courses");
        }

        if (numFailures >= 3) {
            throw new Exception("Academic warning");
        }

        double averageGpa = totalGpa / numCourses;
        String averageGpaStr = String.format("%.1f", averageGpa);

        FileWriter writer = null;
        try {
            writer = new FileWriter(OUTPUT_FILE_PATH);
            writer.write("학점 : " + averageGpaStr);
        } catch (IOException e) {
            throw new Exception("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Ignore the exception
                }
            }
        }
    }
}
