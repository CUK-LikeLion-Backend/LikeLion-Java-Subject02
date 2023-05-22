package ex03;

public class ChatGPT implements GameGPT, CodingGPT{

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        chatGPT.algorithm("재귀함수");
        chatGPT.rockScissorsPaper("가위");

    }

    @Override
    public String algorithm(String input) {
        System.out.println(input);
        return input;
    }


    @Override
    public void rockScissorsPaper(String input) {
        System.out.println("입력하신값은"+input+"입니다.");
    }

    @Override
    public String hello(String name) {
        System.out.println(name);
        return name;
    }
    //GameGPT, Coding GPT 를 구현
    //틀만있고 구현하는건 인터페이스였나



}
