package ex03;

public class CodingGPT extends GPT{
    public String algorithm(String input) {

        if (input.equals("sout")) {
            return "System.out.println();";
        } else if (input.equals("main")) {
            return "public static void main(String[] args)";
        } else {
            return " ";
        } // return은 모든 상황을 cover 할 수 있어야 함
    }
}
