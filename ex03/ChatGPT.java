package ex03;

// 구현을 통해서만 가능 즉 인터페이스를 사용해라
// 상수 : 인터페이스에서 값을 정해줄테니 함부로 바꾸지 말고 제공해주는 값만 참조해라 (절대적)
// 추상메소드 : 가이드만 줄테니 추상메소드를 오버라이팅해서 재구현해라. (강제적)
// 디폴트메소드 : 인터페이스에서 기본적으로 제공해주지만, 맘에 안들면 각자 구현해서 써라. (선택적)
// 정적메소드 : 인터페이스에서 제공해주는 것으로 무조건 사용 (절대적)
public class  ChatGPT { // 인터페이스를 상속받는 클래스
    private GameGPT gameGPT;
    private CodingGPT codingGPT;

    public ChatGPT() {
        gameGPT = new GameGPT();
        codingGPT = new CodingGPT();
    }

    public void rockScissorsPaper(String input) {
        gameGPT.rockScissorsPaper(input);
    }

    public String algorithm(String input) {
        return codingGPT.algorithm(input);
    }
    public static void main(String[] args) {
        ChatGPT chatGPT = new ChatGPT();

        System.out.print("가위,바위,보 중 하나를 입력하시오 : ");
        chatGPT.rockScissorsPaper("rock");
        String algorithmResult = chatGPT.algorithm("input");
        System.out.println(algorithmResult);
    }
}


