package ex03;
import java.util.Random;

class ChatGPT implements GPT, GameGPT, CodingGPT {
    @Override
    public String hello(String name) {
        return "Hello, " + name + "! I am ChatGPT.";
    }

    @Override
    public void rockScissorsPaper(String input) {
        Random random = new Random();

        int com = random.nextInt(3);
        if(com == 0){ // rock
            if(input == "scissors"){
                System.out.println("Lose");
            }
            else if(input == "rock"){
                System.out.println("Drew");
            }
            else{
                System.out.println("Win");
            }
        }
        else if(com == 1){ // scissors
            if(input == "scissors"){
                System.out.println("Drew");
            }
            else if(input == "rock"){
                System.out.println("Win");
            }
            else{
                System.out.println("Lose");
            }
        }
        else{ // paper
            if(input == "scissors"){
                System.out.println("Win");
            }
            else if(input == "rock"){
                System.out.println("Lose");
            }
            else{
                System.out.println("Drew");
            }
        }
    }

    @Override
    public String algorithm(String input) {
        return "ChatGPT algorithm result";
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();

        String greeting = chatGPT.hello("Hyunjin");
        System.out.println(greeting);

        chatGPT.rockScissorsPaper("scissors");

        String algorithmResult = chatGPT.algorithm("input");
        System.out.println(algorithmResult);
    }
}
