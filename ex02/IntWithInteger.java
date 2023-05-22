package ex02;

public class IntWithInteger {
    private int value;
    public static void multiplyValue(int value) {
        value *= 42;
    }

    public static void changeValue(Integer value) {
        value = 42;
    }

    public static void divideValue(MyInteger value) {
        value.setValue(value.getValue() / 42);
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
        int intValue = 2;

        multiplyValue(intValue);   // 값에 의한 전달
        System.out.println(intValue);

        Integer integerValue = new Integer(5);
        Integer value = integerValue.intValue();
        changeValue(value);
        System.out.println(value);

        MyInteger myInteger = new MyInteger(84);
        divideValue(myInteger);
        System.out.println(myInteger.getValue());
    }
}


