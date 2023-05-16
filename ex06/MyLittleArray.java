package ex06;

public class MyLittleArray {
    private Object[] arr;
    private int length;
    // 기본 생성자
    public MyLittleArray() {
        arr = new Object[20];
        length = 0;
    }

    // index번째 요소 반환
    public Object get(int index) {
        if (index < 0 || index >=length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    // 배열에 원소 삽입
    public void add(Object element) {
        add(length,element);
    }


    // index번째 위치에 원소 삽입
    public void add(int index, Object element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == arr.length) {
            Object[] tempArr = new Object[arr.length*2];
            for (int i = 0; i < length; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
        for (int i = length - 1; i >= index; i--) {
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        length++;
    }
    // 주어진 인덱스 위치에 있는 배열의 값을 변경
    public void set(int index,Object element) {
        if(index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }
    // index의 값 삭제
    public static String[] remove(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        String[] result = new String[arr.length-1];
        int copyIndex = 0;
        for (int i=0; i < result.length; i++) {
            if (i == index) {
                continue;
            }
            result[copyIndex++] = arr[i];
        }
        return result;
    }

    // 주어진 요소가 있는지 여부
    public boolean contains(Object element) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // 처음으로 나타나는 인덱스 반환
    public int indexOf(Object element) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return length;
    }


    public static void main(String[] args) {
        MyLittleArray A = new MyLittleArray();

        // add(Object element)
        A.add("A");
        A.add("B");
        A.add("C");
        Object element = A.get(1); // get(int index)
        System.out.println(element);
        System.out.println("-----------------------");

        // index번째 위치에 원소 삽입
        A.add(1, "D");
        System.out.println(A.get(0));
        System.out.println(A.get(1));
        System.out.println(A.get(2));
        System.out.println(A.get(3));

        System.out.println("-----------------------");

        // set: 인덱스의 값 변경
        A.set(1, "a");
        System.out.println(A.get(0));
        System.out.println(A.get(1));
        System.out.println(A.get(2));
        System.out.println(A.get(3));
        System.out.println("-----------------------");

        String[] alph = {"A", "D", "B", "C"};
        alph = MyLittleArray.remove(alph, 1);
        for (String alphabet: alph) {
            System.out.println(alphabet);
        }
        System.out.println("-----------------------");

        // contains(Object element)
        boolean B = A.contains("B");
        System.out.println(B);
        System.out.println("-----------------------");

        // indexOf(Object element)
        int C = A.indexOf("C");
        System.out.println(C);
        System.out.println("-----------------------");

        System.out.println("Size: " + A.size());


    }

}
