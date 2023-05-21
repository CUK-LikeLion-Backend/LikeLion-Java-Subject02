package ex03;


public class ChatGPT implements GameGPT, CodingGPT {

    @Override
    public String hello(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public void rockScissorsPaper(String input) {
        System.out.println("Playing rock-scissors-paper with " + input);
    }


    @Override
    public String algorithm(String input) {
        System.out.println("Applying algorithm to " + input);
        return "Result of algorithm";
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();

        // GPT의 hello 메소드 실행
        String greeting = chatGPT.hello("Sihoo");
        System.out.println(greeting);

        // GameGPT의 rockScissorsPaper 메소드 실행
        chatGPT.rockScissorsPaper("rock");

        // CodingGPT의 algorithm 메소드 실행
        String result = chatGPT.algorithm("input");
        System.out.println(result);
    }
}