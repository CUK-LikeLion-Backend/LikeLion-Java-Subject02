package ex03;

import ex03.GPT;
public class ChatGPT extends GPT implements GameGPT, CodingGPT {
    public String hello(String name) {
        return "Hello, " + name;
    }

    public void rockScissorsPaper(String input) {
        System.out.println("가위바위보");
    }

    public String algorithm(String input) {
        return "알고리즘";
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        String helloMessage = chatGPT.hello("namin");
        System.out.println(helloMessage);
        chatGPT.rockScissorsPaper("가위");
        String algorithmMessage = chatGPT.algorithm("알고리즘 문제 풀이");
        System.out.println(algorithmMessage);
    }
}