package ex06;

public class Test {
    public static void main(String[] args) {
        MyLittleArray myLittleArray = new MyLittleArray(10);
        //문제: add(int index, Object obj) 실행시 인덱스 크기가 그대로임.
        myLittleArray.add(1);
        myLittleArray.add(2);
        myLittleArray.add(4);
        myLittleArray.add(1, 6);
        for (int i = 0; i <myLittleArray.size() ; i++) {
            System.out.print(myLittleArray.get(i)+" ");
        }
        System.out.println("\n" + myLittleArray.size());
        System.out.println(myLittleArray.get(1));
        System.out.println( myLittleArray.contains(2));
        System.out.println(myLittleArray.indexOf(7));
        myLittleArray.remove(1);
        for (int i = 0; i <myLittleArray.size() ; i++) {
            System.out.print(myLittleArray.get(i)+" ");
        }
    }

}
