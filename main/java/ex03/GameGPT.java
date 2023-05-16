package main.java.ex03;

import java.util.Random;

public class GameGPT {
    public static void rockScissorsPaper(String input){
        String rock="rock";
        String scissor="scissor";
        String paper="paper";
        Random random=new Random();
        random.setSeed(System.currentTimeMillis());
        String gptString=null;
        int score;
        int gpt=random.nextInt()%3;
        //3개의 난수를 생성해 랜덤으로 gpt의 가위 바위 보를 지정
        if(gpt==1) gptString=rock;
        else if(gpt==2) gptString=scissor;
        else if(gpt==3) gptString=paper;
        //가위바위보 처리과정
        //주먹일때
        if(gptString==rock) {
            if(input.equals(rock)) System.out.println("비겼습니다.아쉽군요.^^");
            else if(input.equals(scissor)) System.out.println("이겼습니다.축하합니다.^^");
            else if(input.equals(paper)) System.out.println("졌습니다.분발하세요.^^");
        } //가위일때
        else if (gptString==scissor) {
            if(input.equals(rock)) System.out.println("졌습니다.분발하세요.^^");
            else if(input.equals(scissor)) System.out.println("비겼습니다.아쉽군요.^^");
            else if(input.equals(paper)) System.out.println("이겼습니다.축하합니다.^^");
        }//보 일때
        else if (gptString==paper) {
            if(input.equals(rock)) System.out.println("이겼습니다.축하합니다.^^");
            else if(input.equals(scissor)) System.out.println("졌습니다.분발하세요.^^");
            else if(input.equals(paper)) System.out.println("비겼습니다.아쉽군요.^^");
        }

    }

}
