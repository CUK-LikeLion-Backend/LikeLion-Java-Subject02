package main.java.ex05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Student {
    public static class student{
        public String student() throws IOException {
            String str= Files.readString(Paths.get("C:/Users/82105/Desktop/2023-1/멋사/LikeLion02/src/main/java/ex05/input.txt"));
            return str;
        }
    }
    public static void main(String[] args)throws IOException {
        student stu=new student();
        System.out.println(stu.student());
        String[] lines=stu.student().split("\n?\r|\r");
        String[][] wordMatrix=new String[lines.length][];
        int i=0;
        for(String line:lines){
            wordMatrix[i++]=line.split(" "); //\\s로 하니까 하나씩 밀림ㅜㅜ왜지...?
        }
        System.out.println(Arrays.deepToString(wordMatrix));
        System.out.println(wordMatrix[2][1]);
        //전공강의만 수강신정(수강하는 강의가 3개 이하인 경우 예외처리)
        String imp="전선";
        String[] MyClass;
        for(int p=0;p<lines.length;p++){
            if(wordMatrix[p][3]==imp){

            }
        }
        //학점 부여받기(A,B,C,D,F만 나머지는 예외처리)
        Random random=new Random();
        random.setSeed(System.currentTimeMillis());
        int score=random.nextInt()%5;
        String[] grade=null;
        double[] gradeNum=null;
        for(int p=0;p< lines.length;p++){
            if(score==0){grade[p]="A"; gradeNum[p]=4.5;}
            else if(score==1){grade[p]="B"; gradeNum[p]=4.0;}
            else if(score==2){grade[p]="C"; gradeNum[p]=3.5;}
            else if(score==3){grade[p]="D"; gradeNum[p]=3.0;}
            else if(score==4){grade[p]="F"; gradeNum[p]=0.0;}
        } //nullpointerexception
        //전체 정석중 F가 3개이상시 학사경고
        int count=0;
        for(int p=0;p< lines.length;p++){
            if(grade[p].equals("F")){
                count++;
            }
        }
        if(count>=3){
            try{
                throw new Exception(("예외를 강제로 발생시킴"));
            }catch (Exception e){
                System.out.println("학사경고! 예외발생!: "+e.getMessage());
                e.printStackTrace();;
            }
            System.out.println("프로그램이 정상 종료되었음.");
        }
        //모등강의..?평균...?
        double total=0;
        for(int p=0;p< lines.length;p++){
                total=total+gradeNum[p];

        }
        total=total/ lines.length;
        //출력(학점 평균을 output에 저장)
        try{
            OutputStream output=new FileOutputStream("C:/Users/82105/Desktop/2023-1/멋사/LikeLion02/src/main/java/ex05/output.txt");
            String str=String.valueOf(total);
            byte[] by=str.getBytes();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

