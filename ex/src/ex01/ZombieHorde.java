package ex01;

public class ZombieHorde {
    private int zombieCount;

    public ZombieHorde() {
        this.zombieCount = 0;
    }

    public int getZombieCount() {
        return zombieCount;
    }

    public void addZombie(String zombieName) {
        zombieCount++;
        System.out.println(zombieName + " became a zombie!");
    }

    public int howManyZombie() {
        return zombieCount;
    }
}
