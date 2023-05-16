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

class MyClass {
    public static void multiplyBy42(int number) {
        number *= 42;
    }

    public static void changeToInt42(Integer number) {
        number = 42;
    }

    public static void divideBy42(MyInteger number) {
        int value = number.getValue();
        value /= 42;
        number.setValue(value);
    }

    public static void main(String[] args) {
        int myNumber1 = 5;
        multiplyBy42(myNumber1);
        System.out.println(myNumber1);

        Integer myNumber2 = new Integer(5);
        changeToInt42(myNumber2);
        System.out.println(myNumber2);

        MyInteger myNumber3 = new MyInteger(84);
        divideBy42(myNumber3);
        System.out.println(myNumber3.getValue());
    }
}
