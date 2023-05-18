package ex03;

public class ChatGPT implements CodingGPT, GameGPT{     //인터페이스를 구현하는 클래스

    @Override
    public String algorithm(String input) {     //CodingGPT
        return "알고리즘이 "+input+" 값으로 실행";
    }

    @Override
    public String hello(String name) {      //GameGPT
        return "Hello, "+ name;
    }

    @Override
    public void rockScissorsPaper(String input) {

        String[] inputs = {"rock","scissors", "paper"};

        if(input.equals("rock") || input.equals("scissors") || input.equals("paper")){
            String opponent = inputs[(int) (Math.random() * 3)];    //0,1,2의 값을 가져 opponenet변수가 inputs요소 중 임의의 한 값을 갖도록

            System.out.println("나: "+input+" 상대: "+opponent);

            if(input == opponent){
                System.out.println("무승부\n");
            }
            else if((input.equals("rock") && opponent.equals("scissors")) ||
                    (input.equals("scissors") && opponent.equals("paper"))||
                    (input.equals("paper") && opponent.equals("rock"))){
                System.out.println("나의 승리\n");
            }else{
                System.out.println("나의 패배\n");
            }

        }
        else{
            System.out.println("잘못된 입력/ rock, scissors, paper 중에서 입력하시오!\n");
        }
    }

    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();    //챗gpt 생성

        String id = chatGPT.hello("sungwon");
        System.out.println(id+"\n");

        String ex1 = chatGPT.algorithm("rock");
        System.out.println(ex1);
        chatGPT.rockScissorsPaper("rock");

        String ex2 = chatGPT.algorithm("scissors");
        System.out.println(ex2);
        chatGPT.rockScissorsPaper("scissors");

        String ex3 = chatGPT.algorithm("paper");
        System.out.println(ex3);
        chatGPT.rockScissorsPaper("paper");


    }
}
