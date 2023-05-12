package ex02;

class MyInteger {
    private int data = 0;

    MyInteger(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

public class IntWithInteger {
    public static void mul42(int num) {
        num = num * 42;
    }
    public static void set42(Integer num) {
        num = 42;
    }
    public static void div42(MyInteger num) {
        int data = num.getData();
        num.setData(data / 42);
    }

    public static void main(String[] args) {
        int anInt = 1;
        Integer integer = new Integer(10);
        MyInteger myInteger = new MyInteger(42 * 42);

        mul42(anInt);
        System.out.println(anInt);

        set42(integer);
        System.out.println(integer);

        div42(myInteger);
        System.out.println(myInteger);
    }
}
