package ex04;

public class Dog extends Animal{
    private Brain brain;

    Dog(Brain brain){
        this.brain = brain;
    }
    @Override
    public void makeSound(){
        System.out.println(brain.getName() + " : bark!!!!");
    }
}
