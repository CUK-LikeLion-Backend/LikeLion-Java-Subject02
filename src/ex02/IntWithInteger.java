package ex02;

import java.util.Scanner;

class MyInteger {
    private int value;

    public MyInteger(){

    }

    public MyInteger(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class IntWithInteger {

    private MyInteger myInteger = new MyInteger();

    public IntWithInteger() {
        this.myInteger = new MyInteger();
    }

    public void multiply(int num) {
        this.myInteger.setValue(num * 42);
    }

    public void change(Integer num) {
        this.myInteger.setValue(42);
    }

    public void divide(MyInteger myInteger) {
        this.myInteger.setValue(myInteger.getValue() / 42);
    }

    public int getMyInteger() {
        return myInteger.getValue();
    }

    public static void main(String[] args) {

        IntWithInteger intWithInteger = new IntWithInteger();
        Scanner sc = new Scanner(System.in);
        System.out.print("int형 변수 값을 입력하시오 : ");
        int num = sc.nextInt();

        intWithInteger.multiply(num);
        System.out.println(intWithInteger.getMyInteger());

        intWithInteger.change(Integer.valueOf(num));
        System.out.println(intWithInteger.getMyInteger());

        MyInteger myInteger = new MyInteger(intWithInteger.getMyInteger());
        intWithInteger.divide(myInteger);
        System.out.println(intWithInteger.getMyInteger());


    }
}