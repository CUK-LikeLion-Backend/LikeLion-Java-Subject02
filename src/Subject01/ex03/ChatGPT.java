package Subject01.ex03;

import java.util.Scanner;
public class ChatGPT implements GameGPT, CodingGPT{
    private ChatGPT(){
        System.out.println("GhatGPT가 켜졌습니다.");
    }
    @Override
    public String algorithm(String input) {
        return "네? " + input + " 에 대한 내용은 잘 몰라요..";
    }

    @Override
    public void rockScissorsPaper(String input) {

        int computerInput = (int)((Math.random()*10000)%3);
        if(input.equals("바위")){
            if(computerInput == 0){
                System.out.println("비겼습니다");
            } else if(computerInput == 1){
                System.out.println("이겼습니다.");
            } else{
                System.out.println("졌습니다.");
            }
        } else if(input.equals("가위")){
            if(computerInput == 1){
                System.out.println("비겼습니다");
            } else if(computerInput == 2){
                System.out.println("이겼습니다.");
            } else{
                System.out.println("졌습니다.");
            }
        } else{
            if(computerInput == 2){
                System.out.println("비겼습니다");
            } else if(computerInput == 0){
                System.out.println("이겼습니다.");
            } else{
                System.out.println("졌습니다.");
            }
        }

    }

    @Override
    public String hello(String name) {
        return name + "님 안녕하세요!";
    }

    public static void main(String[] args) {
        ChatGPT gpt = new ChatGPT();
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String gptName = sc.nextLine();
        System.out.println(gpt.hello(gptName));
        System.out.println();

        System.out.println("무엇을 도와드릴까요??");
        String inputStr = sc.nextLine();
        System.out.println(gpt.algorithm(inputStr));
        System.out.println();

        System.out.println("가위바위보 게임 시작!");
        System.out.println("가위, 바위, 보 중 하나만 입력하세요.");
        String inputGame = sc.nextLine();
        gpt.rockScissorsPaper(inputGame);
    }
}
