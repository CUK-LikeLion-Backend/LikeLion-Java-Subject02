package ex03;

public class GameGPT extends GPT{
    public void rockScissorsPaper(String input){
        int com = 0;
        com = (int)(Math.random() * 3) + 1;

        switch (input){ // com = 1 : rock / com = 2 : scissors / com = 3 : paper
            case "rock":
                if (com == 1) {
                    System.out.println("비겼습니다.");
                } else if (com == 2){
                    System.out.println("이겼습니다.");
                } else {
                    System.out.println("졌습니다.");
                }
                break;
            case "scissors":
                if (com == 1) {
                    System.out.println("졌습니다.");
                } else if (com == 2){
                    System.out.println("비겼습니다.");
                } else {
                    System.out.println("이겼습니다.");
                }
                break;
            case "paper":
                if (com == 1) {
                    System.out.println("이겼습니다.");
                } else if (com == 2){
                    System.out.println("졌습니다.");
                } else {
                    System.out.println("비겼습니다.");
                }
                break;
        }
    }
}
