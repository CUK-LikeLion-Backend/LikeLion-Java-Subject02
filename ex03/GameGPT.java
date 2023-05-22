package ex03;

import java.util.Scanner;

public class GameGPT extends GPT {
    private String name;

    public GameGPT(){}
    public GameGPT(String name) {
        this.name = name;
    }
    public void rockScissorsPaper(String input) {
        // 이걸 input으로 받아온다.
        Scanner sc = new Scanner(System.in);
        String computer = sc.next();

        if (input == computer) {
            System.out.println("비김");
        } else if ((input == "가위" && computer == "바위") || (input == "바위" && computer == "보") || (input == "보" && computer == "가위")) {
            System.out.println("짐.");
        }
        else {
        System.out.println("이김.");}
}
    @Override
    public String hello(String name) {
        return "Hello" + this.name; // GameGPT
    }
}
