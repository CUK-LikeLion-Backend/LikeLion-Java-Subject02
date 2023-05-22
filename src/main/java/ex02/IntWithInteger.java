package main.java.ex02;

//        1. int 변수를 매개변수로 받아서 기존 int 값에 42를 곱하는 메소드 작성
//        2. Integer 변수를 매개변수로 받아서 기존 int 값을 42로 바꾸는 메소드 작성
//        3. MyInteger 변수를 매개변수로 받아서 기존 int 값을 42로 나누는 메소드 작성
//        4. 메소드들의 반환형은 void 입니다.
//        5. 메소드 실행 후 main함수에서 각 변수들의 값을 출력하세요.
public class IntWithInteger {
    private int num = 10;

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }
    private void func1 (int num) {
        setNum(num *42);
    }

    private void func2(Integer num){
        setNum(num);
    }


    private void func3(MyInteger num){
        num.setValue(num.getValue()/42);
    }
    public static  void main(String[] args) {
        IntWithInteger test = new IntWithInteger();
        test.func1(test.getNum());
        System.out.println("func1 >>> " + test.getNum());

        Integer num = new Integer(42);
        test.func2(num);
        System.out.println("func2 >>> " +test.getNum());

        MyInteger myNum = new MyInteger(42);
        test.func3(myNum);
        System.out.println("func3 >>> " +myNum.getValue());
    }
}

class MyInteger{
    private int value;

    public MyInteger(int value){
        this.value= value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
