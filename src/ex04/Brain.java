package ex04;

public class Brain {
    private String name;

    public Brain(String name){  //이름을 매개변수로 입력 받을 때만 생성

        this.name = name;
    }

    public String getName(){

        return this.name;
    }
}
