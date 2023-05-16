package ex02;

public class IntWithInteger {
    private int myInt;
    private Integer myInteger;

    public IntWithInteger(int myInt, Integer myInteger) {
        this.myInt = myInt;
        this.myInteger = myInteger;
    }

    public void multiply42(int x) {
        myInt *= 42;
    }

    public void replaceInt(Integer x) {
        myInteger = 42;
    }

    public void divide42(MyInteger x) {
        myInteger /= 42;
    }

    public int getMyInt() {
        return myInt;
    }

    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    public Integer getMyInteger() {
        return myInteger;
    }

    public void setMyInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }

     static class MyInteger {
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

    public static void main(String[] args) {
        IntWithInteger myObj = new IntWithInteger(10, 20);
        myObj.multiply42(myObj.getMyInt());
        myObj.replaceInt(myObj.getMyInteger());
        MyInteger myIntObj = new MyInteger(42);
        myObj.divide42(myIntObj);

        System.out.println("myInt: " + myObj.getMyInt());
        System.out.println("myInteger: " + myObj.getMyInteger());
    }
}