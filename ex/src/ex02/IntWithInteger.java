package ex02;

public class IntWithInteger {
    public static void multiple(int num){
        num *= 42;
    }

    public static void set(int num){
        num = 42;
    }

    public static void divide(MyInteger num){
        num.setValue(num.getValue() / 42);
    }

    public static void main(String [] args){
        int intNum = 8;
        Integer integerNum = 88;
        MyInteger myInteger = new MyInteger(336);

        multiple(intNum);
        System.out.println(intNum);

        set(integerNum);
        System.out.println(integerNum);

        divide(myInteger);
        System.out.println(myInteger.getValue());
    }
}

class MyInteger{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyInteger(int value){
        this.value = value;
    }
}