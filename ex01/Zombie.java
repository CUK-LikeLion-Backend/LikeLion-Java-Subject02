package ex01;

public class Zombie {
    private static int zombieCnt = 0;
    Zombie() {
        System.out.println("좀비가 생성되었습니다!");
        System.out.println("Grraaaaaa...");
        zombieCnt++;
    }
    public static int getZombieCnt() {
        return zombieCnt;
    }
}



