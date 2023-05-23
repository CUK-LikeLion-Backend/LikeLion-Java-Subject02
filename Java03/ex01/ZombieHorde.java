package ex01;

import java.util.ArrayList;

public class ZombieHorde {
    Zombie zombie = new Zombie();
    Zombie newZombie = new Zombie();
    private ArrayList<Zombie> zombieHorde;

    public ZombieHorde(int number) {
        zombieHorde = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            zombieHorde.add(zombie);
        }
    }

    public void addZombie() {
        zombieHorde.add(newZombie);
    }

    public void attack () {
        int originalSize = zombieHorde.size();
        for (int i = 0; i < originalSize; i++) {
            zombieHorde.get(i).bite();
            addZombie();
            newZombie.beZombie();
        }
    }

    public void numberOfZombie() {
        System.out.println("총 좀비 수: " + zombieHorde.size() + "명");
    }

    public static void main(String[] args) {
        Zombie zombie = new Zombie();
        ZombieHorde zombieHorde = new ZombieHorde(5);
        zombieHorde.numberOfZombie();
        zombieHorde.attack();
        zombieHorde.numberOfZombie();
        zombieHorde.attack();
        zombieHorde.numberOfZombie();
    }
}