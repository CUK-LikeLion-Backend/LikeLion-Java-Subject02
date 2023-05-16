package ex01;
import java.util.ArrayList;
import java.util.List;

public class ZombieHorde {
    private List<Zombie> horde;

    public ZombieHorde() {
        horde = new ArrayList<>();
    }

    public void addZombie(Zombie zombie) {
        horde.add(zombie);
    }

    public void attack() {
        List<Zombie> newZombies = new ArrayList<>();
        for (Zombie zombie : horde) {
            Zombie newZombie = zombie.bite();
            newZombies.add(newZombie);
        }
        horde.addAll(newZombies);
    }

    public int getZombieCount() {
        return horde.size();
    }

    public static void main(String[] args) {
        // 좀비 생성
        Zombie zombie1 = new Zombie();
        Zombie zombie2 = new Zombie();

        // 좀비 군단 생성
        ZombieHorde horde = new ZombieHorde();

        // 좀비 군단에 기존의 좀비들 추가
        horde.addZombie(zombie1);
        horde.addZombie(zombie2);

        // 사람 공격
        horde.attack();
        System.out.println(horde.getZombieCount());

        horde.attack();
        System.out.println(horde.getZombieCount());
    }
}

