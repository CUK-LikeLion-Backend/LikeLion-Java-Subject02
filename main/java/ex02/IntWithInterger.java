package main.java.ex02;

public class IntWithInterger {
    public static int mul42(int mul){
        return mul*=42;
    }
    public static int change42(Integer mid2){
        Integer ig=new Integer(mid2);
        int ig2=ig.intValue();
        int ret=42;
        int temp=ig;
        ig=ret;
        ret=temp;
        return ig;
    }
    private static class MyInteger{
        private int min;

        private MyInteger(int min){
            this.min=min/42;
        }
    }
    public static void main(String[] args) {
        //테스트 코드
        int mid=42;
        MyInteger mI=new MyInteger(mid);
        Integer mid2= Integer.valueOf("10");
        //1. 자료형을 사용해 메소드 만듦.
        System.out.println(mul42(mid));
        //2.Interger로 받고 42와 스왑
        System.out.println(change42(mid2));
        //3.MyInterger이용.
        System.out.println(mI.min);
    }
}
