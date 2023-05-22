package ex03;

public class ChatGPT implements GameGPT, CodingGPT{

    ChatGPT(){}

    @Override
    public String algorithm(String input) {
        StringBuilder sb = new StringBuilder();
        return sb.append(input).reverse().toString();
    }

    @Override
    public String hello(String name) {
        return name + " 안녕";
    }

    @Override
    public void rockScissorsPaper(String input) {
        System.out.println("무조건 이겨볼께");
        if(input == "rock"){
            System.out.println("paper");
        }
        else if(input == "scissors"){
            System.out.println("rock");
        }
        else {
            System.out.println("scissors");
        }
    }

    public static void main(String[] args) {
        ChatGPT gpt = new ChatGPT();

        System.out.println(gpt.algorithm("LikeLion"));
        System.out.println(gpt.hello("카피바라"));
        gpt.rockScissorsPaper("rock");
    }
}
