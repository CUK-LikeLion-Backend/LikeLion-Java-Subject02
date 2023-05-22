package ex01;

public class Zombie {
    Zombie(){
        System.out.println("Grraaaaaa...");
    }

    public Zombie bite(){
        return new Zombie();
    }
}
