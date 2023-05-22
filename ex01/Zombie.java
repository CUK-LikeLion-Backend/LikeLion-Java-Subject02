package ex01;
class Human {

}

public class Zombie extends Human {
    public void setInfected(boolean infected) {
        isInfected = infected;
    }

    private boolean isInfected;
    private static String sound = "Grraaaaaa…";

    public Zombie() {
        System.out.println(sound);
    }


    public Zombie bite() {
        Zombie h = new Zombie();
        h.setInfected(true);
        return h;
    }

    public boolean isInfected() {
        return isInfected;
    }
}
