package main.java.ex03;

public class ChatGPT extends GPT implements GameGPT, CodingGPT{


    public String algorithm(String input){
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public void rockScissorsPaper(String input){
        String[] choices = {"가위", "바위", "보"};

        int computerChoiceIndex = (int) (Math.random() * 3);
        String computerChoice = choices[computerChoiceIndex];


        String userChoice = input;


        System.out.println("사용자 " + userChoice);
        System.out.println("컴퓨터 : " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("비겼습니다!");
        } else if (
                (userChoice.equals("가위") && computerChoice.equals("보")) ||
                        (userChoice.equals("바위") && computerChoice.equals("가위")) ||
                        (userChoice.equals("보") && computerChoice.equals("바위"))
        ) {
            System.out.println("사용자가 이겼습니다!");
        } else {
            System.out.println("컴퓨터가 이겼습니다!");
        }

    }
    public static void main(String[] args) {
        ChatGPT chatBot = new ChatGPT();
        String greeting = chatBot.hello("Jiwon");
        System.out.println(greeting);

        chatBot.rockScissorsPaper("가위");
        String algorithmResult = chatBot.algorithm("input");
        System.out.println(algorithmResult);
    }
}




