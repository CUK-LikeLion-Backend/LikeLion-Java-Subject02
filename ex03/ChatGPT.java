package ex03;

import java.util.Random;
import java.util.Scanner;

public class ChatGPT implements CodingGPT, GameGPT, GPT {
    @Override
    public String algorithm(String input) {
        int size = 5;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i * 2 + 1; k++) {
                System.out.print(input);
            }
            System.out.println("");
        }
        for (int i = size - 1; i > 0; i--) {
            for(int j = size - i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int k = i * 2 - 1; k > 0; k--) {
                System.out.print(input);
            }
            System.out.println("");
        }
        return input;
    }

    @Override
    public String hello(String name) {
        return name + "님, 안녕하세요!";
    }

    @Override
    public void rockScissorsPaper(String input) {
        Random random = new Random();
        int rspNum = random.nextInt(3) + 1;
        int userNum = 0;
        int cnt = 0;

        if(input.equals("가위")) {
            userNum = 1;
        }
        else if(input.equals("바위")) {
            userNum = 2;
        }
        else if(input.equals("보")) {
            userNum = 3;
        }
        else {
            System.out.println("잘못된 입력입니다.");
        }

        cnt = userNum - rspNum;

        System.out.println("\n<  가위바위보 결과  >\n");
        System.out.println("유저의 선택 : " + userNum + ", 컴퓨터의 선택 : " + rspNum);

        if(cnt == 0) {
            System.out.println("비겼습니다!");
        }
        else if (cnt == -1 || cnt == 2) {
            System.out.println("졌습니다. GPT의 승리입니다!");
        }
        else {
            System.out.println("이겼습니다. 유저의 승리입니다!");
        }
    }

    public static void main(String[] args) {
        ChatGPT gpt = new ChatGPT();
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.println(gpt.hello(name));
        System.out.println("\n<  메뉴  >");
        System.out.println("1. 가위바위보 게임");
        System.out.println("2. 다이아몬드 출력");
        System.out.print("\n메뉴를 선택하세요 : ");
        int choice = sc.nextInt();
        System.out.println("\n====================\n");

        if(choice == 1) {
            System.out.print("가위(1), 바위(2), 보(3)를 입력하세요 : ");
            String user = sc.next();
            gpt.rockScissorsPaper(user);
        }
        else if (choice == 2) {
            System.out.print("다이아몬드를 출력할 문자를 입력하세요 : ");
            String str = sc.next();
            gpt.algorithm(str);
        }
        else {
            System.out.println("존재하지 않는 번호입니다.");
        }
    }
}

