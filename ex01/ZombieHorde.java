package ex01;

import java.util.ArrayList;
import java.util.List;

public class ZombieHorde {
    private List<Zombie> horde= new ArrayList<>();


    public ZombieHorde(int size) {
        for (int i=0; i < size; i++) {
            horde.add(new Zombie());
        }
    }
    // 좀비가 사람을 물게 함
    public void attack() {
        for (Zombie zombie : horde) {
            zombie.bite();
        }
    }

    // 군단에 좀비 추가
    public void addZombie(Zombie zombie) {
        horde.add(zombie);
    }

    // 좀비군단의 크기 반환
    public int getSize() {
        return horde.size();
    }

    public static void main(String[] args) {
        ZombieHorde z = new ZombieHorde((4));
        System.out.println("초기 군단의 크기: " + z.getSize());

        Zombie zombie = new Zombie();
        zombie.bite();
        z.addZombie(zombie);

        System.out.println("감염 후 군단의 크기: " + z.getSize());

        z.attack();

        System.out.println("공격 후 군단의 크기: " + z.getSize());

    }
}
