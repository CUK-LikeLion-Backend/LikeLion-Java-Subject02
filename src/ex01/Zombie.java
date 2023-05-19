package ex01;

// 좀비 클래스
public class Zombie {
    private String name;  // 좀비의 이름

    public Zombie(String name) {
        this.name = name;
        System.out.println(name+" 생성!");
        System.out.println("Grraaaaaa...");  // 좀비가 만들어질 때 출력
    }

    public String getName() {
        return name;
    }

    // 사람을 물어서 좀비를 만드는 메소드
    public static Zombie biteHuman(String humanName) {
        String zombieName = humanName+"_좀비";
        return new Zombie(zombieName);
    }
}
