package ex03;

public class CodingGPT extends GPT{
    private String name;
    public CodingGPT(){}
    public CodingGPT(String name) {
        this.name = name;
    }

    public String algorithm(String input){
        return input;
    }
    @Override
    public String hello(String name) {
        return "Hello" + this.name; // CodingGPT
    }
}
