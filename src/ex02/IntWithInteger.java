package ex02;

class MyInteger{

    int num;
    public MyInteger(int num){
        this.num = num;
    }
    public int getValue(){
        return num;
    }
    public void setValue(int num){
        this.num = num;
    }

}

public class IntWithInteger {

    private int num;

    public static void multiplyInt(int num){
        num*=42;
        System.out.println(num);
    }

    public static void multiplyInteger(Integer num){
        num = 42;
        System.out.println(num);
    }

    public static void divideInteger(MyInteger num){
        num.setValue(num.getValue()/42);
        System.out.println(num.getValue());
    }

    public static void main(String[] args) {
        int number = 2;
        multiplyInt(number);
        System.out.println(number);

        Integer integer = new Integer(2);
        multiplyInteger(integer);
        System.out.println(integer);

        MyInteger myInteger = new MyInteger(2);
        divideInteger(myInteger);
        System.out.println(myInteger);

    }


}
