package ex03;

import org.w3c.dom.Node;

import java.util.Random;

public class ChatGPT implements CodingGPT, GameGPT{
    public ChatGPT(){

    }
    private int randomNumber = 0;
    private String RSP = null;
    private Random random = new Random();
    @Override
    public String hello(String name) {
        return name+"님 안녕하세요. ChatGPT입니다. 무엇을 도와드릴까요?";
    }
    @Override
    public String algorithm(String input) {
        return input+" 알고리즘을 알려드리겠습니다.";
    }

    public void rockScissorPaper(String input) {
        randomNumber = random.nextInt(3) + 1;
        switch (randomNumber) {
            case 1:
                RSP = "가위";
                break;
            case 2:
                RSP = "바위";
                break;
            case 3:
                RSP = "보";
                break;
            default:
                System.out.println("가위, 바위, 보 중 하나를 입력하여주세요.");
                break;
        }

        if (RSP.equals(input)) {
            System.out.println("비겼습니다.");
        } else if (RSP.equals("가위") && input.equals("바위")) {
            System.out.println("YOU Win");
        } else if (RSP.equals("가위") && input.equals("보")) {
            System.out.println("GameGPT Win");
        } else if (RSP.equals("바위") && input.equals("보")) {
            System.out.println("YOU Win");
        } else if (RSP.equals("바위") && input.equals("가위")) {
            System.out.println("GameGPT Win");
        } else if (RSP.equals("보") && input.equals("가위")) {
            System.out.println("YOU Win");
        } else if (RSP.equals("보") && input.equals("바위")) {
            System.out.println("GameGPT Win");
        }
    }

}
