package ex03;

public class ChatGPT implements CodingGPT,GameGPT{

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        chatGPT.algorithm("재귀함수");
        chatGPT.rockScissorsPaper("가위");
        chatGPT.hello("이해송");
    }

    @Override
    public String algorithm(String input) {
        System.out.println(input);
        return input;
    }

    @Override
    public String hello(String name) {
        System.out.println(name);
        return name;
    }

    @Override
    public void rockScissorsPaper(String input) {
        System.out.println("입력하신값은"+input+"입니다.");
    }
    //GameGPT, Coding GPT 를 구현
    //틀만있고 구현하는건 인터페이스였나



}
