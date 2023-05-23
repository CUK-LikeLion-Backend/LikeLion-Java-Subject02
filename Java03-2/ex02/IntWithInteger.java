package ex02;

class MyInteger {
    private int valueMyInteger;

    public MyInteger(int valueMyInteger) {
        this.valueMyInteger = valueMyInteger;
    }

    public int getValueMyInteger() {
        return valueMyInteger;
    }

    public void setValueMyInteger(int valueMyInteger) {
        this.valueMyInteger = valueMyInteger;
    }
}
public class IntWithInteger {
    private int valueMyInteger;
    private int valueInt;
    private Integer valueInteger;

    public IntWithInteger(int valueInt, Integer valueInteger, int valueMyInteger) {
        this.valueInt = valueInt;
        this.valueInteger = valueInteger;
        this.valueMyInteger = valueMyInteger;
    }

    public int multiply42(int valueInt) {
        return valueInt * 42;
    }

    public Integer replace42(Integer valueInteger) {
        return 42;
    }

    public int divide42(int valueMyInteger) {
        return valueMyInteger / 42;
    }

    public int getValueInt() {
        return valueInt;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public Integer getValueInteger() {
        return valueInteger;
    }

    public void setValueInteger(Integer valueInteger) {
        this.valueInteger = valueInteger;
    }

    public int getValueMyInteger() {
        return valueMyInteger;
    }

    public void setValueMyInteger(int valueMyInteger) {
        this.valueMyInteger = valueMyInteger;
    }

    public static void main(String[] args) {
        IntWithInteger nums = new IntWithInteger(10, 20, 42);
        System.out.println("기존 int 값: " + nums.getValueInt());
        System.out.println("기존 Integer 값: " + nums.getValueInteger());
        System.out.println("기존 MyInteger 값: " + nums.getValueMyInteger());
        System.out.println("메소드 실행 후, int 값: " + nums.multiply42(nums.getValueInt()));
        System.out.println("메소드 실행 후, Integer 값: " + nums.replace42(nums.getValueInteger()));
        System.out.println("메소드 실행 후, MyInteger 값: " + nums.divide42(nums.getValueMyInteger()));
    }
}