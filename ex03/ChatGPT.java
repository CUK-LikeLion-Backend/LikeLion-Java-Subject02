package ex03;

public class ChatGPT {
    private GameGPT gameGPT;
    private  CodingGPT codingGPT;

    public ChatGPT(){
       gameGPT=new GameGPT();
       codingGPT=new CodingGPT();
    }

    public void rockScissorsPaper(String input){
        gameGPT.rockScissorsPaper(input);
    }

    public String algorithm(String input){
        return codingGPT.algorithm(input);
    }

    public void hello(String name){
        System.out.println(gameGPT.hello(name));
    }
    public static void main(String[] args){
        ChatGPT chatGPT=new ChatGPT();
        chatGPT.rockScissorsPaper("가위");
        chatGPT.hello("조이");
        System.out.println(chatGPT.algorithm("알고리즘"));
    }
}
