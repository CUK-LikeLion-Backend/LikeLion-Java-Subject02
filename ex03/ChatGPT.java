package ex03;

import java.util.Scanner;
import java.util.Random;

public class ChatGPT implements GameGPT, CodingGPT{
    //GPT
    public String hello(String name){
        return name + "님 안녕하세요!";
    }

    //CodingGPT
    public String algorithm(String input){ //소문자를 대문자로 바꾸는 알고리즘
        char[] ch = input.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];

            if (Character.isLowerCase(c)) {
                // 소문자인 경우 대문자로 변환
                ch[i] = Character.toUpperCase(c);
            }
        }
        return new String(ch);
    }

    //GameGPT
    public void rockScissorsPaper(String input){
        Random random = new Random();
        int rand = random.nextInt(3);
        String res = "";

        switch (rand){
            case 0: //바위
                if (input.equals("가위"))
                    res = "GPT는 바위를 냈어요. GPT가 이겼어요!";
                else if (input.equals("바위"))
                    res = "GPT는 바위를 냈어요. 비겼습니다";
                else if (input.equals("보"))
                    res = "GPT는 바위를 냈어요. 당신이 이겼어요!";
                break;

            case 1: //가위
                if (input.equals("가위"))
                    res = "GPT는 가위를 냈어요. 비겼습니다";
                else if (input.equals("바위"))
                    res = "GPT는 가위를 냈어요. 당신이 이겼습니다!";
                else if (input.equals("보"))
                    res = "GPT는 가위를 냈어요. GPT가 이겼어요!";
                break;

            case 2: //보
                if (input.equals("가위"))
                    res = "GPT는 보를 냈어요. 당신이 이겼습니다!";
                else if (input.equals("바위"))
                    res = "GPT는 보를 냈어요. GPT가 이겼어요!";
                else if (input.equals("보"))
                    res = "GPT는 보를 냈어요. 비겼습니다";
                break;
            default:
                break;
        }
        System.out.printf("%s\n", res);
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();

        //GPT
        System.out.println(chatGPT.hello("민주"));
        System.out.println(" ");

        //GameGPT
        System.out.println("가위, 바위, 보! (입력해주세요)");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        chatGPT.rockScissorsPaper(input);
        System.out.println(" ");

        //CodingGPT (대문자로 바꾸는 알고리즘 ~)
        System.out.println(chatGPT.algorithm("This is upper algorithm~"));

    }
}
