package ex02;

public class IntWithInteger {

    int num=2;

    public int getNum() {
        return num;
    }


    public static void main(String[] args) {

        IntWithInteger intWithInteger=new IntWithInteger();
        intWithInteger.multiply42(intWithInteger.getNum());
        System.out.println(intWithInteger.getNum());

        Integer b = new Integer(5);
        intWithInteger.changeTo42(b);
        System.out.println(b.getValue());

        MyInteger c = new MyInteger(84);
        intWithInteger.divide42(c);
        System.out.println(c.getValue());
    }

    public void multiply42(int num) {
        this.num *= 42;
    }

    public void changeTo42(Integer num) {
        num.setValue(42);
    }

    public void divide42(MyInteger num) {
        num.setValue(num.getValue() / 42);
    }
}

class Integer {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
