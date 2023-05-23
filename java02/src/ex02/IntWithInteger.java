package ex02;
class MyInteger{
    private int n ;
    public MyInteger(int n) {
        this.n = n;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
}
public class IntWithInteger {
    public static void intMul42(int n){
        n *= 42;
    };
    public static void integerTo42(Integer integer){
        integer = 42;
    };
    public static void myIntegerDiv42(MyInteger myInteger){
        myInteger.setN(myInteger.getN() / 42) ;
    };

    public static void main(String[] args) {
        int num = 1; // primitive
        Integer integer = new Integer(1); // wrapper(객체), but 불변
        MyInteger myInteger = new MyInteger(42*42); // 객체, 모든 객체는 주소 값을 가짐. 포인터처럼 사용 가능.
        intMul42(num);
        integerTo42(integer);
        myIntegerDiv42(myInteger);
        System.out.println("int 변수를 매개변수로 받아서 처리 : " + num );
        System.out.println("Intger 변수를 매개변수로 받아서 처리 :" + integer);
        System.out.println("MyInteger 변수를 매개변수로 받아서 처리: " + myInteger.getN());
    }


}
