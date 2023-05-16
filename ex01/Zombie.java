package ex01;

import java.util.ArrayList;
import java.util.List;

class Zombie {
    public Zombie() {
        System.out.println("Grraaaaaa...");
    }

    public Zombie bite() {
        System.out.println("Zombie bites a person.");
        return new Zombie();
    }

    public static void main(String[] args) {
        Zombie zombie1 = new Zombie();
        Zombie zombie2 = new Zombie();

        System.out.println("Zombie objects created.");

        ZombieHorde horde = new ZombieHorde();
        horde.addZombie(zombie1);
        horde.addZombie(zombie2);

        System.out.println("Zombies added to the horde.");

        System.out.println("Zombie horde attacks!");
        horde.attack();
    }
}


