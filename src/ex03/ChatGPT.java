package ex03;
interface GameGPT extends GPT{
    void rockScissorsPaper(String name);

}

interface CodingGPT extends GPT{
    public String algorithm(String input);
}
//인스턴스를 생성할 수 없음
interface GPT {
    public String hello(String name);
}

public class ChatGPT implements GameGPT, CodingGPT {

    @Override
    public void rockScissorsPaper(String name) {
        System.out.println(name);
    }

    @Override
    public String algorithm(String input) {
        return input;
    }

    @Override
    public String hello(String name) {
        return "Hello!! " + name;
    }
}


