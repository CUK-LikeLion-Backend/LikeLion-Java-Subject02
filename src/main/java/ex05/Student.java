package ex05;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Student {

    private Map<String, Double> lectureMap = new HashMap<>();

    private BufferedReader br;
    private BufferedWriter bw;
    private static int CountF;

    Student(){}

    void readFile() throws TooLessLectureException, IOException {
        String s;
        br = new BufferedReader(new FileReader(new File("src/main/java/lion5/ex05/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while((s = br.readLine())!=null){
            String[] lecture = s.split(" ");
            if(lecture[3].equals("전선")){
                lectureMap.put(lecture[1],null);
                bw.write(s+"\n");
            }
        }

        if(lectureMap.size()<3){
            throw new TooLessLectureException();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    void getGrade(String lectureName, char gradeInput) throws OutOfLetGradeException, TooManyFGradeException{
        double grade=0;
        switch(gradeInput){
            case 'A' :{
                grade = 4.5;
                break;
            }
            case 'B' :{
                grade = 4.0;
                break;
            }
            case 'C' :{
                grade = 3.5;
                break;
            }
            case 'D' :{
                grade = 3.0;
                break;
            }
            case 'F' :{
                grade = 0.0;
                CountF++;
                break;
            }
            default:{
                throw new OutOfLetGradeException();
            }
        }
        lectureMap.put(lectureName,grade);

        if(CountF > 2){
            throw new TooManyFGradeException();
        }
    }

    void writeEverage() throws IOException, NullGradeException {
        bw = new BufferedWriter(new FileWriter(new File("src/main/java/lion5/ex05/output.txt")));

        double result=0;
        double average;
        for (Double value : lectureMap.values()) {
            if(value == null){
                throw new NullGradeException();
            }
            result += value;
        }

        average = result / lectureMap.size();

        bw.write(String.format("%.1f",average));
        bw.flush();
        bw.close();

    }

    public class TooLessLectureException extends Exception{}
    public class OutOfLetGradeException extends Exception{}
    public class TooManyFGradeException extends Exception{}
    public class NullGradeException extends Exception{}


    public static void main(String[] args) {
        Student s = new Student();

        try {
            s.readFile();
        } catch (IOException e) {
            System.err.println("파일 입력 시 오류 발생");
            e.printStackTrace();
        } catch (TooLessLectureException e) {
            System.err.println("수강하는 강의가 3개 미만");
        }

        try {
            s.getGrade("자료구조", 'C');
            s.getGrade("파일처리", 'A');
            s.getGrade("운영체제", 'A');
            s.getGrade("자료구조기초", 'F');
        }
        catch (OutOfLetGradeException e){
            System.err.println("A B C D E F 만 입력");
            return;
        }
        catch (TooManyFGradeException e){
            System.err.println("3개 이상 F. 학사경고");
        }

        try {
            s.writeEverage();
        } catch (IOException e) {
            System.err.println("파일 출력 시 오류 발생" + e.getMessage());
            e.printStackTrace();
        } catch (NullGradeException e) {
            System.err.println("학점을 부여하지 않은 강의 존재");
        }

    }
}
