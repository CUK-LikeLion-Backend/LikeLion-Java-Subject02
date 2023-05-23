package main.java.ex06;

public class MyLittleArray<G>{
    private G element;
    private G index;
    private G object;
    void setElement(){
        this.element=element;
    }
    G getElement(){
        return element;
    }
    void setIndex(){
        this.index=index;
    }
    G getIndex(){
        return index;
    }
    void setObject(){
        this.object=object;
    }
    G getObject(){
        return object;
    }

}
class Main{
    public static void main(String[] args) {
        MyLittleArray<Integer> mla=new MyLittleArray<Integer>();
    }
}
