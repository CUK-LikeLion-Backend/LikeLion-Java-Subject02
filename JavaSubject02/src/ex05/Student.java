package ex05;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class Lecture {
    private String id;
    private String lectureName;
    private String lectureNumber;
    private String major;
    private String professor;
    private double grade = -1;

    private Lecture() {}
    public Lecture(String id, String lectureName, String lectureNumber, String major, String professor) {
        this.id = id;
        this.lectureName = lectureName;
        this.lectureNumber = lectureNumber;
        this.major = major;
        this.professor = professor;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getLectureName() {
        return lectureName;
    }

    @Override
    public String toString() {
        return "강의번호: " + id + " 강의명: " + lectureName + " 강의번호: " + lectureNumber + " 전공: " + major + " 교수명: " + professor;
    }
}

public class Student {
    private ArrayList<Lecture> myLectures = new ArrayList<>();
    private Random random = new Random();

    public Student() {}
    private String readTxt(String filePath) throws Exception {
        StringBuilder sb = new StringBuilder();
        try (
                FileInputStream fileStream = new FileInputStream(filePath)
        ) {
            byte[] readBuffer = new byte[fileStream.available()];
            while (fileStream.read( readBuffer ) != -1) {
                sb.append(new String(readBuffer));
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            e.printStackTrace();
            throw new Exception("파일 읽는 중 에러 발생");
        }
    }

    private String writeTxt(String filePath) throws Exception{
        double grade = 0;
        for (Lecture lecture : myLectures) {
            grade += lecture.getGrade();
        }
        grade = grade / myLectures.size();
        try (
                FileOutputStream fileStream = new FileOutputStream(filePath)
        ) {
            String data = String.format("성적: %.1f", grade);
            fileStream.write(data.getBytes());
            return data;
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            e.printStackTrace();
            throw new Exception("파일 저장 중 에러 발생");
        }
    }

    private void findLecture(String lectureName) throws Exception {
        for (Lecture lecture : myLectures) {
            if (lecture.getLectureName().equals(lectureName)) {
                throw new Exception("이미 수강 중인 강의 입니다.");
            }
        }
    }

    public void 수강하기(String filePath) throws Exception {
        String input = readTxt(filePath);
        String[] lines = input.split("\n");

        for (int i=0; i<lines.length; ++i) {
            String[] lectureStr = lines[i].split(" ");
            if (lectureStr[3].equals("전기") || lectureStr[3].equals("전선")) {
                try {
                    findLecture(lectureStr[1]);
                } catch (Exception e) {
                    continue;
                }
                Lecture newLecture = new Lecture(lectureStr[0], lectureStr[1], lectureStr[2], lectureStr[3], lectureStr[4]);
                myLectures.add(newLecture);
            }
        }

        if (myLectures.size() < 3) {
            throw new Exception("수강하는 강의가 너무 적습니다.");
        }

        for (int i=0; i<myLectures.size(); ++i) {
            System.out.println(myLectures.get(i));
        }
    }

    public void 학점부여받기(String lectureName, String grade) throws Exception {
        for (Lecture lecture : myLectures) {
            if (lecture.getLectureName().equals(lectureName)) {
                if (grade.equals("A")) {
                    lecture.setGrade(4.5);
                } else if (grade.equals("B")) {
                    lecture.setGrade(4.0);
                } else if (grade.equals("C")) {
                    lecture.setGrade(3.5);
                } else if (grade.equals("D")) {
                    lecture.setGrade(3.0);
                } else if (grade.equals("F")) {
                    lecture.setGrade(0);
                } else {
                    throw new Exception("올바르지 않은 학점입니다.");
                }
                return;
            }
        }
        throw new Exception("잘못된 강의명 입니다.");
    }

    private void checkGrade() throws Exception {
        int fCount = 0;
        for (Lecture lecture : myLectures) {
            if (lecture.getGrade() == -1) {
                throw new Exception("아직 성적 처리가 되지 않은 강의가 있습니다.");
            }
            if (lecture.getGrade() == 0) {
                ++fCount;
            }
        }
        if (fCount >= 3) {
            throw new Exception("학사경고 입니다.");
        }
    }

    public void 성적산출(String filePath) throws Exception {
        checkGrade();
        String ret = writeTxt(filePath);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.수강하기("C:\\Users\\gmh82\\OneDrive\\Desktop\\LikeLion\\teamStudy\\LikeLion-Java-Subject02\\JavaSubject02\\src\\ex05\\input.txt");
            student.학점부여받기("자료구조", "A");
            student.학점부여받기("인공지능", "A");
            student.학점부여받기("영화로보는동양문화", "C");
            student.성적산출("C:\\Users\\gmh82\\OneDrive\\Desktop\\LikeLion\\teamStudy\\LikeLion-Java-Subject02\\JavaSubject02\\src\\ex05\\output.txt");
        } catch (Exception e) {
            System.out.println("[Error] " + e.getMessage());
            e.printStackTrace();
        }
    }
}