package ex01;
import java.util.ArrayList ;

import static ex01.ZombieHorde.getZombies;

public class Zombie {
    public static void bite(){
        getZombies().add(new Zombie());
    }
    public Zombie() {
        System.out.println("Grraaa...");
    }
}
