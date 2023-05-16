package Subject01.ex02;

public class InWithInteger {
    private static class MyInteger{
        private int myInt;
        MyInteger (int num){
          this.myInt = num;
        }

        public int getMyInt(){
            return myInt;
        }
    }
    private int num;

    private InWithInteger(int num){
        this.num = num;
    }
    private void toMul(int num){
        num *= 42;
    }

    private void toInt(Integer integerNum){
        integerNum = 42;
    }

    private void toDivide(MyInteger myIntNum){
        myIntNum.myInt /= 42;
    }

    public static void main(String[] args) {
        int num = 1;
        Integer integerNum = new Integer(10);
        MyInteger myIntNum = new MyInteger(42);

        InWithInteger pointer = new InWithInteger(1);
        pointer.toMul(num); // 1 * 42 = 42
        System.out.println(num);

        pointer.toInt(integerNum); // 10 -> 42
        System.out.println(integerNum);

        pointer.toDivide(myIntNum); // 42 / 42 = 1
        System.out.println(myIntNum.myInt);
    }
}
