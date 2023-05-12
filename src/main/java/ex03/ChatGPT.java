package ex03;

import java.util.Random;

public class ChatGPT implements CodingGPT, GameGPT {
    Random random = new Random();
    @Override
    public String algorithm(String input) {
        System.out.println(input + " algorithm...");
        if (random.nextInt(2) == 0)
            return "success!";
        else
            return "fail....";
    }

    @Override
    public String hello(String name) {
        System.out.println("hello!");
        return "Hello? my name is " + name;
    }

    @Override
    public void rockScissorsPaper(String input) {
        System.out.println("let's play the game");
        int ret = random.nextInt(3);

        if (input.equals("rock")) {
            if (ret == 0) {
                System.out.println("GPT: rock\nYou: rock");
                System.out.println("Draw");
            } else if (ret == 1) {
                System.out.println("GPT: scissors\nYou: rock");
                System.out.println("You Win!");
            } else {
                System.out.println("GPT: paper\nYou: rock");
                System.out.println("You Lose...");
            }
        } else if (input.equals("scissors")) {
            if (ret == 0) {
                System.out.println("GPT: rock\nYou: scissors");
                System.out.println("You Lose...");
            } else if (ret == 1) {
                System.out.println("GPT: scissors\nYou: scissors");
                System.out.println("Draw");
            } else {
                System.out.println("GPT: paper\nYou: scissors");
                System.out.println("You Win!");
            }
        } else if (input.equals("paper")) {
            if (ret == 0) {
                System.out.println("GPT: rock\nYou: paper");
                System.out.println("You Win!");
            } else if (ret == 1) {
                System.out.println("GPT: scissors\nYou: paper");
                System.out.println("You Lose...");
            } else {
                System.out.println("GPT: paper\nYou: paper");
                System.out.println("Draw");
            }
        } else {
            System.out.println("wrong input!");
        }
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        System.out.println(chatGPT.hello("minseok"));
        System.out.println(chatGPT.algorithm("Greedy"));
        chatGPT.rockScissorsPaper("wrong input");
        chatGPT.rockScissorsPaper("rock");
        chatGPT.rockScissorsPaper("scissors");
        chatGPT.rockScissorsPaper("paper");
    }
}
