package ex02;

public class IntWithInteger {

    int exist = 90;

    private void multi(Integer num) {
        System.out.println(num * 42);
    }

    private void change() {
        System.out.println(this.exist = 42);
    }

    private void divide(MyInteger myInteger) {
        myInteger.divide(42);
    }

    static class MyInteger{
        private int num;

        public MyInteger(int num) {
            this.num = num;
        }

        private int getNum() {
            return num;
        }

        private void setNum(int num) {
            this.num = num;
        }

        private void divide(int divide){
            int i = this.num / divide;
            System.out.println(i);
        }

    }



    public static void main(String[] args) {
        IntWithInteger intWithInteger=new IntWithInteger();
        MyInteger myInteger=new MyInteger(84);

        intWithInteger.multi(5);
        intWithInteger.change();
        intWithInteger.divide(myInteger);

    }
}
