package ex03;
import java.util.Random;
import java.util.Scanner;
public class ChatGPT implements CodingGPT, GameGPT {
    public ChatGPT() {
        Scanner sc = new Scanner(System.in);
        System.out.print("사용자 이름 입력 : ");
        String name = sc.nextLine();
        System.out.println(hello(name));

    }

    @Override
    public String algorithm(String input) {
        return "알고리즘이다!";
    }
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
    @Override
    public  void rockScissorPaper(String input) {
        // 컴퓨터가 낼 수 있는 가위, 바위, 보 중에서 랜덤으로 선택
        String[] options = {"가위", "바위", "보"};
        Random random = new Random();
        String computerChoice = options[random.nextInt(options.length)];

        // 사용자의 입력과 컴퓨터의 선택을 비교하여 승패 결정
        String result;
        if (input.equals(computerChoice)) {
            result = "비겼습니다!";
        } else if ((input.equals("가위") && computerChoice.equals("보")) ||
                (input.equals("바위") && computerChoice.equals("가위")) ||
                (input.equals("보") && computerChoice.equals("바위"))) {
            result = "이겼습니다!";
        } else {
            result = "졌습니다!";
        }

        // 결과 출력
        System.out.println("사용자 선택: " + input);
        System.out.println("컴퓨터 선택: " + computerChoice);
        System.out.println("결과: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChatGPT gpt = new ChatGPT();
        while (true) {
            System.out.print("Command Game/Algorithm or Exit : ");
            String command = sc.nextLine();

            if (command.equals("Game")) {
                System.out.print("가위 바위 보! :");
                String input = sc.nextLine();
                gpt.rockScissorPaper(input);
            }else if(command.equals("Algorithm")){
                System.out.print("어떤 알고리즘? : ");
                String input = sc.nextLine();
                System.out.println(gpt.algorithm(input));
            }else {
                System.out.println("GPT 종료");
                return;
            }
        }
    }
}
