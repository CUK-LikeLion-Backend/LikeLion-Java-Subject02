package ex01;

import java.util.ArrayList;

public class ZombieHorde extends Zombie{
    private ArrayList<Zombie> zombies = new ArrayList<>();
    void Bite(int a){
        for(int i=0;i<a;i++) {
            Zombie zombie = new Zombie();
            zombies.add(zombie);// 물은 횟수만큼 Zombie 객체 배열인 zombies의 길이가 늘어난다.
        }
        System.out.println(zombies.size()+"마리의 좀비가 있습니다.");
    }
    public static void main(String[] args) {
        ZombieHorde horde = new ZombieHorde();
        horde.zombies = new ArrayList<Zombie>();
        System.out.println("태초에 "+FIRST+"마리의 좀비가 있었습니다.");
        horde.Bite(FIRST);
        System.out.println();
        System.out.println(horde.zombies.size()+"마리의 좀비가 사람을 뭅니다.");
        horde.Bite(horde.zombies.size());

    }
}
