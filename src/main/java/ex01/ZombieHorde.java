package main.java.ex01;
import main.java.ex01.Zombie;
import java.util.ArrayList;


public class ZombieHorde {

   private ArrayList<Zombie> horde ;

   public ZombieHorde() {
       horde = new ArrayList<>();
   }

   public int zombieNum(){
       return horde.size();
   }
    public void addZombie(Zombie zombie){
        horde.add(zombie);
    }

   public void attack(){
       ZombieHorde newHorde = new ZombieHorde(); // 좀비 군단 생성
       for(Zombie zombie : horde){
           //newHorde 에 속한 각각의 좀비는 bite 함수를 실행
           Zombie newZombie = zombie.bite();
           //각각의 좀비는 add 해서 좀비 군단에 좀비 추가
           newHorde.addZombie(newZombie);
       }
       horde.addAll(newHorde.horde);
   }


    public static void main(String[] args) {
        ZombieHorde newHorde = new ZombieHorde();
        Zombie zombie = new Zombie();
        newHorde.addZombie(zombie);
        System.out.println("현재 좀비 군단의 size: "+newHorde.zombieNum());
        System.out.println("좀비 군단 공격!");
        newHorde.attack();
        System.out.println("현재 좀비 군단의 size: "+newHorde.zombieNum());
        System.out.println("좀비 군단 공격!");
        newHorde.attack();
        System.out.println("현재 좀비 군단의 size: "+newHorde.zombieNum());



    }
}

