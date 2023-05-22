package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZombieHorde {
    private List<Zombie> zombieList = new ArrayList<>();
    private Zombie newZombie;

    ZombieHorde(){

    }
    ZombieHorde(int n){
        System.out.println("초기 좀비군단 생성중");
        for(int i=0; i<n; i++){
            Zombie z = new Zombie();
            zombieList.add(z);
        }
        System.out.println("초기 좀비군단 생성 완료\n");
    }


    public void biteAll(){
        List<Zombie> tempList = zombieList.stream().collect(Collectors.toList());
        System.out.println(zombieList.size() + "마리의 좀비가 공격");
        for (Zombie zombie : tempList) {
            newZombie = zombie.bite();
            zombieList.add(newZombie);
        }
        System.out.println("현재 좀비 " + zombieList.size() + "마리\n");
    }

    public static void main(String[] args) {
        ZombieHorde horde = new ZombieHorde(5);
        horde.biteAll();
        horde.biteAll();
        horde.biteAll();
        horde.biteAll();
        horde.biteAll();
    }
}
