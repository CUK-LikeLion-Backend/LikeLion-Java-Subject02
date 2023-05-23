package ex06;

public class MyLittleArray<E> {
    private E[] arr;
    private int length;

    // 기본 생성자
    public MyLittleArray() {
        arr = (E[]) new Object[20];
        length = 0;
    }

    // index번째 요소 반환
    public E get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    // 배열에 원소 삽입
    public void add(E element) {
        add(length, element);
    }

    // index번째 위치에 원소 삽입
    public void add(int index, E element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        if (length == arr.length) {
            E[] tempArr = (E[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, tempArr, 0, length);
            arr = tempArr;
        }
        System.arraycopy(arr, index, arr, index + 1, length - index);
        arr[index] = element;
        length++;
    }

    // 주어진 인덱스 위치에 있는 배열의 값을 변경
    public void set(int index, E element) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }

    // index의 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arr, index + 1, arr, index, length - index - 1);
        length--;
    }

    // 주어진 요소가 있는지 여부
    public boolean contains(E element) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // 처음으로 나타나는 인덱스 반환
    public int indexOf(E element) {
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
        MyLittleArray<String> A = new MyLittleArray<>();

        System.out.println("<원소 삽입>");
        A.add("A");
        A.add("B");
        A.add("C");
        String element0 = A.get(0); // get(int index)
        String element1 = A.get(1);
        String element2 = A.get(2);
        System.out.println(element0);
        System.out.println(element1);
        System.out.println(element2);
        System.out.println("-----------------------");

        System.out.println("<index번째 위치에 원소 삽입>");
        A.add(1, "D");
        System.out.println(A.get(0));
        System.out.println(A.get(1));
        System.out.println(A.get(2));
        System.out.println(A.get(3));

        System.out.println("-----------------------");

        System.out.println("<set: 인덱스의 값 변경>");
        A.set(1, "d");
        System.out.println(A.get(0));
        System.out.println(A.get(1));
        System.out.println(A.get(2));
        System.out.println(A.get(3));
        System.out.println("-----------------------");

        System.out.println("<인덱스에서 값 삭제>");
        A.remove(1); // remove(int index)
        for (int i = 0; i < A.size(); i++) {
            System.out.println(A.get(i));
        }
        System.out.println("-----------------------");

        System.out.println("<특정 원소를 포함하는지에 대한 여부>");
        boolean B = A.contains("B");
        System.out.println(B);
        System.out.println("-----------------------");

        System.out.println("<특정 원소가 나타내는 인덱스 반환>");
        int C = A.indexOf("C");
        System.out.println(C);
        System.out.println("-----------------------");

        System.out.println("<인덱스의 크기 반환>");
        System.out.println("Size: " + A.size());
    }
}
