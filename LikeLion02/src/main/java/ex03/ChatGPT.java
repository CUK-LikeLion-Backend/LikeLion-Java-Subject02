package main.java.ex03;

import java.util.Scanner;

public class ChatGPT {
    public static void main(String[] args) {
        GameGPT gameGPT=new GameGPT();
        CodingGPT codeGPT=new CodingGPT();
        Scanner sc=new Scanner(System.in);
        //GPT와 인사하기
        System.out.print("사용자의 이름을 입력하세요: \n");
        String name= sc.nextLine();
        System.out.println("안녕하세요 "+codeGPT.hello(name)+"님!");
        //가위바위보 게임
        System.out.print("가위바위보 게임을 해볼까요? rock scissor paper 중 하나를 입력하세요\n");
        String input=sc.nextLine();
        gameGPT.rockScissorsPaper(input);
        //코딩 GPT
        //입력한 문자열을 출력하는 코드를 알려준다.
        System.out.println("문자열을 입력하면 그 문자열을 출력하는 코드를 알려드릴께요");
        String input2=sc.nextLine();
        System.out.println(codeGPT.algotithm(input2));
    }
}
