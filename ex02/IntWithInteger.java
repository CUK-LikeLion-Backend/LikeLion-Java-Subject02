package ex02;

public class IntWithInteger {
    void multi42(int num){
        num *= 42;
        //System.out.println(num);
    }
    void change42(Integer num){
        num = 42;
        //System.out.println(num);
    }
    void division42(MyInteger num){
       num.setNumber(num.getNumber() / 42);
       // System.out.println(i);
    }
}
class MyInteger{
    private int number;

    public MyInteger(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
class Test{
    public static void main(String[] args) {
        int num = 2;
        //객체 생성
        IntWithInteger intWithInteger = new IntWithInteger();
        MyInteger myInteger = new MyInteger(num);

        intWithInteger.multi42(num);
        System.out.println(num);

        intWithInteger.change42(num);
        System.out.println(num);

        intWithInteger.division42(myInteger);
        System.out.println(myInteger.getNumber());
    }
}
