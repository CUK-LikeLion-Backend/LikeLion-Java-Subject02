package main.java.ex03;

public class CodingGPT implements GPT{
    @Override
    public String hello(String name) {
        return name;
    }
    @Override
    public String algotithm(String input) {
        return "String code= \""+input+"\";"+"\n"+"System.out.println(code);";
    }

    @Override
    public void rockScissorsPaper(String input) {

    }
}
