package ex05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    private String filepath;        //파일 경로
    private List<String> courses;       //수강 과목

    public Student(String filepath){
        this.filepath = filepath;
        this.courses = new ArrayList<>();
    }

    public void openTimetable() throws IOException{     //입출력 예외
        try(Scanner sc = new Scanner(new File(filepath))){  //파일 경로에 있는 파일 입력받아 내용 가져옴 //sc객체 종료시 자동반납
            while(sc.hasNextLine()){    //다음 줄에 읽을 값이 있는 동안
                String line = sc.nextLine();    //읽은 한 줄의 문자열을 line에 저장
                String[] courseInfo = line.split(" ");  //line에 저장된 값을 공백을 기준으로 분리하여 courseInfo배열에 저장
                String courseNumber = courseInfo[0];    //과목번호
                String courseName = courseInfo[1];      //과목이름
                String courseMajor = courseInfo[3];     //과목종류(전기,전선)

                if(courseMajor.equals("전선")){   //전공이면
                    courses.add(courseName);    //courses에 추가
                }
            }
        }catch(FileNotFoundException e){    //파일이 존재하지 않을 때 발생오류
            throw new IOException("강의 시간표 파일을 찾을 수 없음. ");
        }
    }

    public void assignGrades() throws Exception{    //강의에 학점 부여
        double score = 0;
        double sum = 0;

        if(courses.isEmpty()){  //배열에 값이 없을떄(수강 강의가 없을때)
            throw new Exception("수강하는 강의가 없음. ");
        }

        int numCourses = courses.size();    //수강하는 강의 개수

        if(courses.size() < 3){
            throw new Exception("수강 강의가 3개 미만입니다. ");
        }

        Scanner sc = new Scanner(System.in);

        for(String course : courses){
            System.out.println(course+" 의 학점을 부여하시오 (A, B, C, D, F): ");
            String grade = sc.nextLine();

            if(!grade.equals("A") && !grade.equals("B")     //A B C D F가 아닐떄
                    && !grade.equals("C") && !grade.equals("D") && !grade.equals("F")){
                throw new Exception("유효하지 않은 학점입니다. ");
            }

            if (grade.equals("A"))
                score = 4.5;
            else if (grade.equals("B"))
                score = 4.0;
            else if (grade.equals("C"))
                score = 3.5;
            else if (grade.equals("D"))
                score = 3.0;
            else if (grade.equals("F"))
                score = 0.0;

            sum += score;
        }
        double average = sum / numCourses;  //총합 / 강의 개수 = 평균
        saveAverageToFile(average);     //계산된 평균을 파일에 저장
    }

//    public void calculateAverage() throws Exception{    //강의 성적의 평균 계산 후 파일에 저장
//        if(courses.isEmpty()){  //수강 강의가 없을때
//            throw new Exception("수강하는 강의가 없음. ");
//        }
//
//        double sum = 0;
//        int numCourses = courses.size();    //수강하는 강의 개수
//
//        for(String course : courses){
//            System.out.println(course+ "의 성적을 입력하시오: ");
//            Scanner sc = new Scanner(System.in);
//            double grade = Double.parseDouble(sc.nextLine());   //문자열로 입력받고, 문자열을 실수형으로 변환
//
//            if(grade < 0 || grade > 4.5){
//                throw new Exception("유효하지 않은 성적. ");
//            }
//
//            sum += grade;   //강의 성적을 총합에 더함
//        }
//
//        double average = sum / numCourses;  //총합 / 강의 개수 = 평균
//        saveAverageToFile(average);     //계산된 평균을 파일에 저장
//    }

    public void saveAverageToFile(double average) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\82102\\eclipse-workspace\\untitled\\src\\java-hw-02\\src\\ex05\\output.txt"))) {
            //printwriter: 편리한 출력 위한 클래스
            writer.printf("평균 성적: %.1f", average);  //average값을 파일에 저장 / 문자열을 지정된 형식을 출력
        }
    }

    public static void main(String[] args) {
        String file_path = "C:\\Users\\82102\\eclipse-workspace\\untitled\\src\\java-hw-02\\src\\ex05\\input.txt";
        Student student = new Student(file_path);

        try{
            student.openTimetable();
            student.assignGrades();

        }catch(Exception e){
            System.out.println("오류발생: "+e.getMessage());
        }
    }


}
