package ex06;
public class MyLittleArray<T> {
    private Object[] array;
    private int size;

    public MyLittleArray() {
        array = new Object[10]; // 초기 크기를 10으로 설정
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        array[size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        T removedValue = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null; // 마지막 요소를 null로 설정하여 참조 해제
        size--;
        return removedValue;
    }

    public boolean contains(T object) {
        return indexOf(object) >= 0;
    }

    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (array[i] == null)
                    return i;
            } else {
                if (object.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1); // 현재 용량의 1.5배
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public static void main(String[] args) {
        MyLittleArray<Integer> intArray = new MyLittleArray<>();
        intArray.add(10);
        intArray.add(20);
        intArray.add(30);

        System.out.println("intArray.get(0): " + intArray.get(0)); // 출력: 10
        System.out.println("intArray.get(1): " + intArray.get(1)); // 출력: 20
        System.out.println("intArray.get(2): " + intArray.get(2)); // 출력: 30
        System.out.println("intArray.size(): " + intArray.size()); // 출력: 3

        intArray.add(1, 15);
        System.out.println("intArray.get(1): " + intArray.get(1)); // 출력: 15
        System.out.println("intArray.size(): " + intArray.size()); // 출력: 4

        intArray.set(2, 25);
        System.out.println("intArray.get(2): " + intArray.get(2)); // 출력: 25

        intArray.remove(0);
        System.out.println("intArray.get(0): " + intArray.get(0)); // 출력: 15
        System.out.println("intArray.size(): " + intArray.size()); // 출력: 3

        System.out.println("intArray.contains(25): " + intArray.contains(25)); // 출력: true
        System.out.println("intArray.contains(40): " + intArray.contains(40)); // 출력: false
        System.out.println("intArray.indexOf(15): " + intArray.indexOf(15)); // 출력: 0
        System.out.println("intArray.indexOf(25): " + intArray.indexOf(25)); // 출력: 1
    }
}


