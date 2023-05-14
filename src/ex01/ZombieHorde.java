package ex01;
import java.util.ArrayList;
import java.util.Scanner;


public class ZombieHorde {

    //좀비 군단
    private ArrayList<Zombie> zombielist = new ArrayList<Zombie>();

    //일정 수 만큼 좀비 객체 생성
    public ZombieHorde(int size){
        for(int i=0; i<size; i++){
            zombielist.add(new Zombie());
        }
    }

    //좀비가 공격하는 함수 = grr 소리 내게함
    public void attack(){
        for(Zombie zombie: zombielist){
            zombie.MakeSound();
        }
    }

    public static void main(String[] args) {
        ZombieHorde zombieHorde = new ZombieHorde(5);
        zombieHorde.attack();
    }


}
