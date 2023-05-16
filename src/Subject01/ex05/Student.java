package Subject01.ex05;

import java.io.*;
import java.util.Scanner;
public class Student {

    // 수강 과목 배열
    private static String[] signUp = new String[10];
    // 성적 배열
    private static String[] grade = new String[10];
    // 배열 크기
    private static int size = 0;
    // 평균
    private static float avg = 0;
    private static void openFile() {
        File file = new File("C:\\Users\\likes\\IdeaProjects\\likelionJava1\\src\\main\\java\\Subject01\\ex05\\input.txt");
        try(BufferedReader bufReader = new BufferedReader(new FileReader(file))) {

            String line = "";

            while ((line = bufReader.readLine()) != null) {

                String subjectCategory = line.split(" ")[3];
                String subjectName = line.split(" ")[1];
                if (subjectCategory.equals("전기") || subjectCategory.equals("전선")) {
                    signUp[size++] = subjectName;
                }
            }

            for (int i = 0; i < size; i++) {
                System.out.println(signUp[i]);
            }

        } catch(IOException e){
            System.out.println("input 파일을 읽을 수 없습니다.");
        }
    }

    private static void setGrade() {
        try(Scanner sc = new Scanner(System.in)) {
            int fCnt = 0;
            for (int i = 0; i < size; i++) {
                String inputGrade = sc.next();
                if(inputGrade.equals("F")){
                    fCnt++;
                }

                if (!inputGrade.equals("A") && !inputGrade.equals("B") && !inputGrade.equals("C")
                        && !inputGrade.equals("D") && !inputGrade.equals("F")) {
                    throw new IllegalArgumentException("A, B, C, D, F 중에서만 입력하세요.");
                } else if(fCnt == 3) throw new IllegalArgumentException("학사 경고로 퇴학입니다.");
                grade[i] = inputGrade;
            }
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void getAvg(){
        int gCnt = 0;
        for(int i = 0; i < size; i++) {
            switch (grade[i]){
                case "A":
                    avg += 4.5;
                    gCnt++;
                    break;
                case "B":
                    avg += 4.0;
                    gCnt++;
                    break;
                case "C":
                    avg += 3.5;
                    gCnt++;
                    break;
                case "D":
                    avg += 3.0;
                    gCnt++;
                    break;
                case "F":
                    gCnt++;
                    break;
            }
        }
        try {
            if(gCnt < size) {
                throw new Exception("모든 강의에 학점을 부여하여야 합니다.");
            }
            avg /= size;
            avg = (float) (Math.round(avg * 10) / 10.0);

            String avgString = "학점 : " + Float.toString(avg);
            try (FileOutputStream output = new FileOutputStream("C:\\Users\\likes\\IdeaProjects\\likelionJava1\\src\\main\\java\\Subject01\\ex05\\output.txt")) {
                output.write(avgString.getBytes());
            } catch (Exception e) {
                System.out.println("output 파일을 열 수 없습니다.");
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException{

        openFile();
        setGrade();
        getAvg();
    }
}
