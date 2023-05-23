//> **Requirements**
//        >
//        >
//        > 좀비와 좀비 군단을 둘 다 만들어보세요.
//        >
//        > 좀비가 될 때 `“Grraaaaaa…”`를 출력합니다.
//        >
//        > 좀비는 사람을 물어서 좀비를 만들 수 있습니다.
//        >
//        > 좀비 군단은 여러 좀비 객체를 갖고 있습니다.
//        >
//        > 좀비 군단이 공격하면 군단의 모든 좀비가 한번 씩 사람을 물게 됩니다.
//        >
//        > 군단이 감염시킨 좀비는 군단에 속하게 됩니다.
//        >
package ex01;

import java.util.ArrayList;
import java.util.Scanner;

class Zombie{

    public Zombie(){
        this.growl();
    }
    public void growl(){
        System.out.println("Graaaaaaa...");
    }

}

class ZombieHorde{

    private ArrayList<Zombie> zombies;

    public ZombieHorde(){
        this.zombies = new ArrayList<>();
    }

    public void attack(int human){
        for(int i = 0; i < human; i++){
            zombies.add(new Zombie());
        }
    }

    public static void main(String[] args) {
        ZombieHorde zombieHorde = new ZombieHorde();
        Scanner sc = new Scanner(System.in);
        System.out.println("사람이 몇 명인가요?");
        int num = sc.nextInt();

        zombieHorde.attack(num);
    }
}
