package ex02;
class MyInteger {
    private int value;  // int 값을 저장할 변수

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void multiple() {
        value = value * 42;  // value에 42를 곱하여 업데이트
    }

    public void change(Integer value) {
        value = 42;  // value를 42로 변경
    }

    public void divide(MyInteger myInteger) {
        value = myInteger.getValue() / 42;  // myInteger의 값을 42로 나누어 업데이트
    }
}

public class IntWithInteger {
        public static void main(String[] args) {
            int num1 = 7;
            MyInteger num2 = new MyInteger(10);
            MyInteger num3 = new MyInteger(84);

            multiple(num1);
            num2.change(num2.getValue());
            num3.divide(num3);

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2.getValue());
            System.out.println("num3: " + num3.getValue());
        }

        public static void multiple(int num) {
            num *= 42;  // 매개변수 num에 42를 곱하여 업데이트
        }
    }

