package ex01;

public class Zombie {
    private boolean isInfected;
    private static String sound = "Grraaaaaa…";

    public Zombie() {
        System.out.println(sound);
    }

    public class Human {

    }

    public Human bite() {
        isInfected = true;
        return new Human();
    }

    public boolean isInfected() {
        return isInfected;
    }
}
