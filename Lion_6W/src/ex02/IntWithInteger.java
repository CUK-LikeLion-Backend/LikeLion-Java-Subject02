package ex02;

class MyInteger {
    int value;
    public MyInteger(int value) {
        this.value = value;
    }
}


public class IntWithInteger {
    public static void multiplyBy42(int num) {
        num *= 42;
    }

    public static void changeToInt42(Integer num) {
        num = 42;
    }

    public static void divideBy42(MyInteger num) {
        num.value /= 42;
    }

    public static void main(String[] args) {
        int primitiveInt = 10;
        multiplyBy42(primitiveInt);
        System.out.println("multiplyBy42 : " + primitiveInt);

        Integer boxedInt = new Integer(10);
        changeToInt42(boxedInt);
        System.out.println("changeToInt42 : " + boxedInt);

        MyInteger myInt = new MyInteger(42);
        divideBy42(myInt);
        System.out.println("divideBy42 : " + myInt.value);
    }
}
