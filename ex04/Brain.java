package ex04;

class Brain{
    private String name;
    Brain(String name){
        this.name = name;
        getName();
    }

    public String getName(){
        return name;
    }
}