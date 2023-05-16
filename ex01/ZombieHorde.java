package ex01;

import java.util.Scanner;

public class ZombieHorde {
    private int size;
    private Zombie[] zombies;


    public ZombieHorde(int size) {
        this.size = size;
        this.zombies = new Zombie[size];


        for (int i = 0; i < size; i++) {
            this.zombies[i] = new Zombie();
        }
        System.out.println("현재 좀비의 수는" + this.size);
    }

    private void Attack(boolean attack, int num) {

        if (attack) {
            this.size = num * 2;
            this.zombies = new Zombie[num * 2];
            for (int i = 0; i < num; i++) {
                System.out.println("Grraaaaaa…");
            }

            for (int i = 0; i < size; i++) {
                this.zombies[i] = new Zombie();
            }

            System.out.println("현재 좀비의 수는" + this.size);
        }
    }

    public Zombie[] getZombies() {
        return zombies;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //원하는 좀비의 수 입력
        System.out.println("원하는 좀비의 수 입력해주세요 : ");
        int num = scan.nextInt();
        ZombieHorde zombieHorde = new ZombieHorde(num);

        //공격
        System.out.println("좀비들이 공격을 한다면 true를 입력하세요 :");
        boolean attack = scan.hasNextBoolean();
        zombieHorde.Attack(attack, num);

    }
}
