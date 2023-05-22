package ex01;

import java.util.ArrayList;

public class ZombieHorde {
    private ArrayList<Zombie> zombies;
    public ZombieHorde(int size){
        zombies = new ArrayList<Zombie>(size);

        //size만큼 zombies라는 좀비군단 만들기
        for (int i = 0; i<size; i++){
            zombies.add(new Zombie());
        }
    }

    public void bite(){
        System.out.println("좀비군단이 사람을 물었다!");

        for (Zombie zombie: zombies){ //좀비군단의 수만큼 사람 물기
            zombie.bite();
        }
    }

    public static void main(String[] args) {
        //좀비생성
        Zombie zombie = new Zombie();
        System.out.println("좀비가 나타났다!\n");

        //좀비가 사람 물기
        zombie.bite();
        System.out.println(" ");

        //좀비군단이 생성(크기가 10)
        System.out.println("좀비군단이 생겼다!");
        ZombieHorde zombieHorde = new ZombieHorde(10);
        System.out.println(" ");

        //좀비군단이 사람물기 (군단의 모든 좀비가 한번씩 사람을 물게됨)
        zombieHorde.bite();
    }
}
