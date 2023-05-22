package ex02;
public class IntWithInteger {
    int change = 0;

    private void mul42(int num){
        System.out.println(num *= 42);
    }

    //Integer는 불변객체이므로 값 직접 변경 불가
    void change42(Integer num){
        num = 42;
    }

    private void div42(MyInteger myInteger){
        myInteger.divide(42);
    }

    static class MyInteger {
        private int num;
        public MyInteger(int num){
            this.num = num;
        }

        private void divide(int divide) {
            System.out.println(this.num / divide);
        }
    }

    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(420);
        IntWithInteger intWithInteger = new IntWithInteger();

        //int, 곱하기 42
        intWithInteger.mul42(10); //420

        //Integer, 바꾸기 42
        intWithInteger.change42(10); //무슨수가 들어가도 42로 바뀜

        //myInteger, 나누기 42
        intWithInteger.div42(myInteger); //10
    }
}
