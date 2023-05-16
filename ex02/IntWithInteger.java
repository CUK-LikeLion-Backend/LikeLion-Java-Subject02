package ex02;

public class IntWithInteger {
    private int num;

    public static int method1(int num) {
        return num * 42;
    }

    public static void method2(Integer num) {
        num = 42;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int Num) {
        this.num = num;
    }
    public static class MyInteger {
        private int num;

        public MyInteger(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void method3(MyInteger num) {
        int result = num.getNum() / 42;
        num.setNum(result);
    }

    public static void main(String[] args) {
        // method1
        System.out.println(method1(3));

        // method2
        Integer value = 15;
        method2(value);
        System.out.println(value);

        // method3
        MyInteger myInt = new MyInteger(42);
        method3(myInt);
        System.out.println(myInt.getNum());


    }
}

