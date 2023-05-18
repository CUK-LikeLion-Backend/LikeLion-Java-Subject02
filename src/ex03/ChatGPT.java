package ex03;

import java.util.Random;
import java.util.Scanner;

public class ChatGPT implements CodingGPT,GameGPT,GPT {
    public String hello(String name){
        System.out.println(name+"님 안녕하세요");
        return name;
    }

    public void rockScissorsPaper(String input){
        Random random=new Random();
        int gpt=random.nextInt(3);
        int n=-1;
        if (input.equals("가위")){
            n=0;
        } else if (input.equals("바위")) {
            n=1;
        } else if (input.equals("보")) {
            n=2;
        }
        System.out.println(n);
        System.out.println(gpt);
        //가위0,보2 / 바위1, 가위0 / 보2, 바위1 => 이기는 경우
        //가위0, 바위1 / 바위1 보2/보2, 가위0 => 지는 경우

        if(gpt==n){
            System.out.println("비겼습니다!");
        }
        else if(n-gpt==-1 || n-gpt==2){
            System.out.println("졌습니다.");

        } else{
            System.out.println("이겼습니다.");
        }
    }

    public void algorithm(String input){
        System.out.println(input+"님, 이건 가위바위보 알고리즘입니다");
    }

    public static void main(String[] args) {
        ChatGPT c1 =new ChatGPT();
        c1.hello("아기사자");
        c1.algorithm("아기사자");
        Scanner scanner=new Scanner(System.in);
        System.out.println("가위, 바위, 보 중에 입력하시오: ");
        String input= scanner.nextLine();
        c1.rockScissorsPaper(input);
    }

}
