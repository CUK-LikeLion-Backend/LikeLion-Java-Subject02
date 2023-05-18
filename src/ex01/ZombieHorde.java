package ex01;

import java.util.ArrayList;

public class ZombieHorde {
    ArrayList<Zombie> zombies;

    public ZombieHorde(int size){
        zombies = new ArrayList<>();

        for(int i = 0; i < size; i++){
            zombies.add(new Zombie());
            //좀비군단의 크기만큼 좀비 객체 생성해서 좀비군단에 추가
        }
    }

    public void attack(){
        System.out.println("좀비군단의 공격!");

        ArrayList<Zombie> temporary = new ArrayList<>();    //새로 생성되는 좀비를 임시 저장할 배열 생성

        for(Zombie z : zombies){    //생성되어있던 좀비군단의 좀비 수 만큼
            Zombie newZ = z.attack();   //좀비의 공격
            temporary.add(newZ);    //공격 후 새로 생성되는 좀비를 임시배열에 추가 
        }

        zombies.addAll(temporary);
        //좀비군단의 공격으로 생성된 좀비들(임시 배열)을 기존의 좀비군단으로 추가
    }

    public static void main(String[] args) {
        System.out.println("좀비 군단 생성");
        ZombieHorde Horde = new ZombieHorde(3);  //좀비 군단 생성

        System.out.println("\n좀비 군단 공격1");
        Horde.attack();
        System.out.println("\n좀비 군단 공격2");
        Horde.attack();
    }

}
