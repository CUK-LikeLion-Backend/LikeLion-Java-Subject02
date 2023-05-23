package ex03;

import java.util.Scanner;

public class ChatGPT implements GameGPT, CodingGPT, GPT{

    private String name;

    // 생성자
    public ChatGPT(String name) {
        this.name = name;
    }

    // 이름 반환
    public String getName() {
        return this.name;
    }

    public void rockScissorsPaper(String input) {
        String[] tmp = {"가위", "바위", "보"};
        int computer = (int) (Math.random() * 3);

        // 사용자가 선택한 값과 비교해 이긴 경우와 진 경우에 대한 결과 출력
        // equals 메소드 사용
        if (input.equals(tmp[computer])) {
            System.out.println("무승부");
        } else if ((input.equals("가위") && tmp[computer].equals("보")) || // 사용자: 가위, 컴퓨터: 보
                (input.equals("바위") && tmp[computer].equals("가위")) || // 사용자: 바위, 컴퓨터: 가위
                (input.equals("보") && tmp[computer].equals("바위"))) { // 사용자: 보, 컴퓨터: 바위
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }

    public String algorithm(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }


    public String hello(String name) {
        return "안녕, 내 이름은 " + name + "이야";
    }

    public static void main(String[] args) {
        ChatGPT G = new ChatGPT("jinsoo");
        G.rockScissorsPaper("가위");
        System.out.println(G.hello(G.getName()));
        System.out.println(G.algorithm("LikeLion"));
    }
}
