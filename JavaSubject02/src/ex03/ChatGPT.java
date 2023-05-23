package ex03;
import java.util.Random;

public class ChatGPT implements CodingGPT, GameGPT {
    Random random = new Random();
    @Override
    public String algorithm(String input) {
        return "입력한 알고리즘은"+ input;
    }

    @Override
    public String hello(String name) {
        return "이름은 " + name;
    }

    @Override
    public void rockScissorsPaper(String input) {
        int gpt = random.nextInt(3);
        switch(gpt){
            case 0:
                System.out.println("GPT : 가위");
                System.out.println("당신 : "+input);
                break;
            case 1:
                System.out.println("GPT : 바위");
                System.out.println("당신 : "+input);
                break;

            case 2:
                System.out.println("GPT : 보");
                System.out.println("당신 : "+input);
                break;
            default:
                System.out.println("error");
        }

    }

    public static void main(String[] args) {
        ChatGPT gpt = new ChatGPT();
        System.out.println(gpt.hello("gpt name"));
        System.out.println(gpt.algorithm("gpt algorithm"));
        gpt.rockScissorsPaper("가위");

    }
}
