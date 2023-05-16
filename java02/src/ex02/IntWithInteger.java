package ex02;
class MyInteger{
    private int n;
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

    public static void varInt(int num){
        num *= 42 ;
    }
    public static void varInteger(Integer num){
        num = 42 ;
    }
    public static void div42(MyInteger num){
        int n = num.getN();
        num.setN(n / 42);
    }
    public static void main(String[] args) {
        Integer num2 = new Integer(20);
        MyInteger myInteger = new MyInteger(420);
         int num1 = 10;
        varInt(num1);
        System.out.println(num1);
        varInteger(num2);
        System.out.println(num2);
        div42(myInteger);
        System.out.println(myInteger.getN());
    }
}
