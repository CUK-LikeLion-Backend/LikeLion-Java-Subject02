package ex02;

public class IntWithInteger {
    private int num = 1; // 초깃값은 1로 설정
    //1. int 변수를 매개변수로 받아서 기존 int 값에 42를 곱하는 메소드 작성
    public void multiplyNum(int num){
        this.num = num * 42 ;
    }
    // 2.Integer 변수를 매개변수로 받아서 기존 int 값을 42로 바꾸는 메소드 작성
    public void IntegNum(Integer num){
        this.num = Integer.valueOf(42);
    }
    public class MyInteger {
        private int value;

        public MyInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void div(MyInteger myInteger) {
            myInteger.setValue(myInteger.getValue() / 42);
        }
    }

    public static void main(String[] args){
        IntWithInteger obj = new IntWithInteger();
        IntWithInteger.MyInteger obj2 = obj.new MyInteger(84);
        // 1번
        obj.multiplyNum(2);
        System.out.println(obj.num);

        // 2번
        obj.IntegNum(1);
        System.out.println(obj.num);

        // 3번
        obj2.div(obj2);
        System.out.println(obj2.getValue());
    }

}
