package ex02;
class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }
    public void MyIntegerDiv(MyInteger myinteger){
        this.value /=42;
    }

    public int getValue() {
        return value;
    }
}
    public class IntWithInteger {
        public static void IntegerMul(Integer integer){
            integer = integer*42;
        }

        static void IntMul(int a) {
            a*=42;
        }

        public static void main(String[] args) {
            int a =10;
            Integer b = 20;

            IntMul(a);
            System.out.println(a);

            IntegerMul(a);
            System.out.println(b);

            MyInteger c = new MyInteger(1260);
            c.MyIntegerDiv(c);
            System.out.println(c.getValue());
        }
    }

