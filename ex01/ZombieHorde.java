package ex01;

import java.util.ArrayList;

public class ZombieHorde {
        ArrayList<Zombie> zombies;
        public ZombieHorde(){
            zombies = new ArrayList<>();
        }
        private void addZombie(Zombie z){
            zombies.add(z);
        }

        void bite(){
            Zombie newZombie = new Zombie();
            addZombie(newZombie);
            newZombie.bite();
        }

}
