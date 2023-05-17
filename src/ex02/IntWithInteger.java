package ex02;

class MyInteger {
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
}

public class IntWithInteger {

        public void int42(int num) {

            num = num * 42;     //변경된 값이 메소드 외부에는 영향 x
            System.out.println("int42 실행 후: "+num);
        }

        public void Integer42(Integer num) {

            num = 42;
            System.out.println("Integer42 실행 후: "+num);
        }

        public void MyInteger42(MyInteger num) {
            int data = num.getValue() / 42;
            num.setValue(data);
        }

        public static void main(String[] args) {
            int num = 10;

            IntWithInteger i = new IntWithInteger();

            System.out.println("int42 실행 전: "+num);
            i.int42(num);
//            System.out.println("int42 실행 후: "+num);

//            Integer integer = new Integer(10);
            Integer integer = Integer.valueOf(10);  //int 값을 Integer 객체로 변환
            System.out.println("Integer42 실행 전: "+integer);
            i.Integer42(integer);
//            System.out.println("Integer42 실행 후: "+integer);

            MyInteger myInteger = new MyInteger(20 * 42);
            System.out.println("MyInteger42 실행 전: "+myInteger.getValue());
            i.MyInteger42(myInteger);
            System.out.println("MyInteger42 실행 후: "+myInteger.getValue());

        }
    }
