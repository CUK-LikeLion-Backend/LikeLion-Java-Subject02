package ex03;

import java.util.Scanner;

public class ChatGPT extends GPT{
    private GameGPT gameGPT;
    private CodingGPT codingGPT;

    public ChatGPT(GameGPT gameGPT, CodingGPT codingGPT) {
        this.gameGPT = gameGPT;
        this.codingGPT = codingGPT;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("user name : ");
        String name = sc.nextLine();
        System.out.println(hello(name));

        while (true) {
            System.out.print("game or coding : ");
            String input = sc.nextLine();

            if (input.equals("game")) {
                System.out.print("rock, scissors, paper? ");
                String choice = sc.nextLine();
                gameGPT.rockScissorsPaper(choice);
            } else if (input.equals("coding")) {
                System.out.print("Enter a keyword: ");
                String keyword = sc.nextLine();
                String result = codingGPT.algorithm(keyword);
                System.out.println(result);
            } else {
                break;
            }
        }
    }
    public static void main(String[] args) {
        GameGPT gameGPT = new GameGPT();
        CodingGPT codingGPT = new CodingGPT();
        ChatGPT chatGPT = new ChatGPT(gameGPT, codingGPT);

        chatGPT.start();
    }
}
