package ex03;

import java.util.Random;

abstract class GPT {
    public abstract String hello(String name);
}


class GameGPT extends GPT {
    Random random=new Random();
    @Override
    public String hello(String name) {
        return "반갑다 " + name + "~ 난 GameGPT야.";
    }

    public void rockScissorsPaper(String input) {
        int inputResult;
        if(input.equals("가위")){
            inputResult=0;
        }else if(input.equals("바위")){
            inputResult=1;
        }else{
            inputResult=2;
        }
        int randomResult=random.nextInt(3);
        if (inputResult==randomResult){
            System.out.println("비겼어요");
        }else if((inputResult == 0 && randomResult == 2) || (inputResult == 1 && randomResult == 0) || (inputResult == 2 && randomResult == 1)){
            System.out.println("이겼어요");
        }else{
            System.out.println("졌어요");
        }
    }
}


class CodingGPT extends GPT {
    @Override
    public String hello(String name) {
        return "반갑다 " + name + "~ 난 CodingGPT야.";
    }

    public String algorithm(String input) {
        return input.toUpperCase();
    }
}


class ChatGPT extends GPT {
private GameGPT gameGpt;
private CodingGPT codingGpt;

    public ChatGPT() {
        gameGpt = new GameGPT();
        codingGpt = new CodingGPT();
        }

    @Override
    public String hello(String name) {
        return "반갑다 " + name + "~ 난 ChatGPT야.";
        }

    public void rockScissorsPaper(String input) {
        gameGpt.rockScissorsPaper(input);
        }

    public String algorithm(String input) {
        return codingGpt.algorithm(input);
        }

    public static void main(String[] args) {
        ChatGPT chatGpt = new ChatGPT();

        String greeting = chatGpt.hello("User");
        System.out.println(greeting);

        System.out.println("가위 바위 보 시작~!");
        chatGpt.rockScissorsPaper("rock");

        System.out.println("입력 값을 대문자로 바꿔줄게");
        String result = chatGpt.algorithm("input");
        System.out.println(result);
        }
    }