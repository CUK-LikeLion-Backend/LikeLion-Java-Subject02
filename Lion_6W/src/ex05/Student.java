package ex05;

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Course> courses;

    public Student() {
        courses = new ArrayList<>();
    }

    public void enrollCoursesFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if (data.length == 5) {
                    String courseNumber = data[0];
                    String courseName = data[1];
                    String courseSection = data[2];
                    String major = data[3];
                    String professor = data[4];

                    if (major.equals("전공")) {
                        Course course = new Course(courseNumber, courseName, courseSection, major, professor);
                        if (!courses.contains(course)) {
                            courses.add(course);
                        }
                    }
                }
            }
        }
    }

    public void assignGrades() {
        for (Course course : courses) {
            double grade = assignGrade(); // 학점 부여 로직 구현 필요
            course.setGrade(grade);
        }
    }

    public void saveGradeAverageToFile(String filename) throws IOException {
        double average = calculateGradeAverage();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("학점: " + String.format("%.1f", average));
        }
    }

    private double calculateGradeAverage() {
        if (courses.isEmpty()) {
            throw new IllegalStateException("수강한 강의가 없습니다.");
        }

        double totalGrade = 0;
        int numberOfGrades = 0;
        int numberOfF = 0;

        for (Course course : courses) {
            double grade = course.getGrade();
            if (grade == 0) {
                numberOfF++;
            }
            totalGrade += grade;
            numberOfGrades++;
        }

        if (numberOfGrades < 3) {
            throw new IllegalStateException("수강한 강의 수가 3개 미만입니다.");
        }

        if (numberOfF >= 3) {
            throw new IllegalStateException("전체 성적 중 F 학점이 3개 이상입니다. 학사 경고입니다.");
        }

        return totalGrade / numberOfGrades;
    }

    // 학점 부여 로직 구현 필요
    private double assignGrade() {
        // 학점 부여 로직 구현
        return 0.0;
    }

    public void printAllCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.enrollCoursesFromFile("input.txt");
            student.assignGrades();
            student.saveGradeAverageToFile("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
*/
