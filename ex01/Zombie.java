package ex01;

import java.util.List;

// Zombie가 될때
public class Zombie {
    private int HumanCount = 4; // 초기 사람 수는 4명
    private int num = 5; // 좀비에 숫자를 매김
    public Zombie() {} // 기본 생성자
    public Zombie(int num) { // 1~4 까지는 군단에 존재 물릴떄 마다 5,6,7,8 좀비가 생성이 될거임
        this.num = num;

    }
    public int getHumanCount(){
        return HumanCount;
    }
    public void setHumanCount(int HumanCount) {
        this.HumanCount = HumanCount;
    }
    public static void main(String[] args){

        ZombieHorde zombieHorde = new ZombieHorde(); // 좀비 군단 객체 생성
        List<Zombie> zombies = zombieHorde.getZombies(); // 좀비 리스트 가져오기

        // 좀비가 사람을 물어 좀비 수 증가
        for(int i=0;i<4;i++) {
            zombieHorde.biteHuman(zombies.get(i));
            System.out.println("현재 좀비 수: " + zombies.size());
        }
    }

}
