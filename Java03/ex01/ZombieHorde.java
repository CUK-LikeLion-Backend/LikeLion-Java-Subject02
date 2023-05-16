package ex01;

import java.util.ArrayList;

public class ZombieHorde {
    private ArrayList<Zombie> zombiehorde;

    public ZombieHorde() {
        zombiehorde = new ArrayList<>();
    }

    // 좀비가 좀비 군단에 속하게 됨
    public void addZombie(Zombie zombie) {
        this.zombiehorde.add(zombie);
    }

    // 좀비 군단이 공격하면 좀비로 변함
    public void attack() {
        for (Zombie zombie : zombiehorde) {
            zombie.turnIntoZombie();
        }
    }

    // 좀비로 감염
    public void infect(Zombie zombie) {
        this.zombiehorde.add(zombie);
        zombie.setIsZombie(true);
    }

    public ArrayList<Zombie> getHorde() {
        return zombiehorde;
    }
}