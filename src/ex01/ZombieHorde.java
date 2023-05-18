package ex01;

import java.util.ArrayList;
import java.util.List;

// 좀비 군단 클래스
public class ZombieHorde {
    private List<Zombie> horde;  // 좀비 군단을 저장하는 리스트
    public ZombieHorde() {
        this.horde = new ArrayList<>();
    }

    // 좀비 군단에 좀비 추가
    public void addZombie(Zombie zombie) {
        horde.add(zombie);
    }

    // 좀비 군단 공격
    public void attack() {
        List<Zombie> newZombies = new ArrayList<>();  // 새로운 좀비들을 저장할 리스트

        for (Zombie zombie : horde) {
            System.out.println(zombie.getName() + "(이)가 사람을 물었다.");  // 좀비가 사람을 물게 될 때 출력
            newZombies.add(Zombie.biteHuman(zombie.getName()));  // 좀비가 물면 새로운 좀비를 생성하여 리스트에 추가
        }

        horde.addAll(newZombies);  // 새로운 좀비들을 기존 좀비 군단에 추가
    }

    public static void main(String[] args) {
        ZombieHorde horde = new ZombieHorde(); // 좀비 군단 객체 생성
        // 좀비 군단에 좀비 추가
        horde.addZombie(new Zombie("좀비1"));
        horde.addZombie(new Zombie("좀비2"));
        horde.addZombie(new Zombie("좀비3"));

        System.out.println("좀비군단의 첫번째 공격!");
        horde.attack();  // 초기 좀비 군단 공격

        System.out.println("\n좀비군단의 두번째 공격!");
        horde.attack();  // 추가된 좀비 군단 공격
    }

}
