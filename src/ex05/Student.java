package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Student {
    private String courseCode;
    private String courseName;
    private String courseNumber;
    private String courseMajor;
    private String professor;

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }


    //강의 시간표 파일을 열어서 데이터를 읽고 전공 강의만 수강하고 마지막에 전부 출력
    public void printCourseList(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String line = null;

        while((line = br.readLine()) != null){
            String[] parts = line.split(" ");
            this.courseCode = parts[0];
            this.courseName = parts[1];
            this.courseNumber = parts[2];
            this.courseMajor = parts[3];
            this.professor = parts[4];
        }
    }
}
