package ex03;

import ex03.GPT;
import java.util.Random;
public class ChatGPT implements GameGPT, CodingGPT {
    public String hello(String name) {
        return "Hello, " + name;
    }

    public void rockScissorsPaper(String input) {
        if (input != "가위" && input != "바위" && input != "보") {
            System.out.println("다시 입력하세요.");
        }
        else {
            System.out.println("사용자: " + input);
            Random random = new Random();
            int com = random.nextInt(3);
            if (com == 0) {
                System.out.println("컴퓨터: 가위");
            }
            else if (com == 1) {
                System.out.println("컴퓨터: 바위");
            }
            else {
                System.out.println("컴퓨터: 보");
            }
            if ((com == 0 && input == "바위") || (com == 1 && input == "보") || (com == 2 && input == "가위")) {
                System.out.println("이겼습니다.");
            }
            else if ((com == 0 && input == "가위") || (com == 1 && input == "바위") || (com == 2 && input == "보")) {
                System.out.println("비겼습니다.");
            }
            else {
                System.out.println("졌습니다.");
            }
        }
    }

    public String algorithm(String input) {
        return "알고리즘";
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        String helloMessage = chatGPT.hello("나민");
        System.out.println(helloMessage);
        chatGPT.rockScissorsPaper("만두");
        chatGPT.rockScissorsPaper("가위");
        String algorithmMessage = chatGPT.algorithm("알고리즘 문제 풀이");
        System.out.println(algorithmMessage);
    }
}