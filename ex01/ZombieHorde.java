package ex01;

import ZombieTest.Zombie;

import java.util.ArrayList;
import java.util.List;

public class ZombieHorde {
    private List<ZombieTest.Zombie> zombies;

    public ZombieHorde(int size) {
        zombies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            zombies.add(new Zombie());
        }
    }

    public void attack() {
        int numZombies = zombies.size();
        System.out.println("좀비 군단이 공격하고 있습니다!");
        for (int i = 0; i < numZombies; i++) {
            zombies.add(new Zombie());
        }
    }

    public int getTotalZombies() {
        return Zombie.getZombieCnt();
    }

    public static void main(String[] args) {
        ZombieHorde horde = new ZombieHorde(5);
        System.out.println("총 좀비의 수 : " + horde.getTotalZombies());
        System.out.println("\n====================\n");
        horde.attack();
        System.out.println("총 좀비의 수 : " + horde.getTotalZombies());
    }
}

