package ex03;

public class Test {
    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();
        String name = "지헌";

        System.out.println(chatGPT.hello(name));
        chatGPT.rockScissorPaper("바위");
        System.out.println(chatGPT.algorithm("이진탐색"));
    }
}
