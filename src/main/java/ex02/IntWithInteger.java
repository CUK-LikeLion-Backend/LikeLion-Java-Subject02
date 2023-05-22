package ex02;

public class IntWithInteger {

    IntWithInteger(){

    }

    void func1(int param){
        param *= 42;
    }

    void func2(Integer param){
        param = 42;
    }

    void func3(MyInteger myInteger){
        myInteger.setMemberInt((myInteger.getMemberInt()/42));
    }

    public static void main(String[] args) {
        IntWithInteger withInteger = new IntWithInteger();

        int func1Int = 2;
        Integer func2Int = 2;
        MyInteger myInteger = new MyInteger();


        //출력 결과 int는 기존 값 변경 불가
        withInteger.func1(2);
        System.out.println(func1Int);

        //출력 결과 Integer는 기존 값 변경 불가
        //메서드 내에서 대입 연산자 이용 시 힙 영역 내 기존 객체 값 변경이 아닌,
        //새로운 객체 생성을 하는 것을 확인 가능
        withInteger.func2(func2Int);
        System.out.println(func2Int);

        myInteger.setMemberInt(50);
        withInteger.func3(myInteger);
        System.out.println(myInteger.getMemberInt());

    }

    static class MyInteger{
        MyInteger(){}
        private int memberInt;

        void setMemberInt(int num){
            this.memberInt = num;
        }

        int getMemberInt(){
            return this.memberInt;
        }
    }
}
