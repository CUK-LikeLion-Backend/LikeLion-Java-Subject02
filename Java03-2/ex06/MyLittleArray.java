package ex06;

public class MyLittleArray<T> {
    Object[] array;
    int size;
    public MyLittleArray(int num) {
        array = new Object[num];
        size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("올바른 인덱스 값을 입력하세요.");
        }
        else {
            return (T) array[index];
        }
    }

    public void add(T element) {
        int newSize = size + 1;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < newSize - 1; i++) {
            newArray[i] = array[i];
        }
        newArray[newSize - 1] = element;
        array = newArray;
        size = newSize;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("올바른 인덱스 값을 입력하세요.");
        }
        else {
            int newSize = size + 1;
            Object[] newArray = new Object[newSize];
            if (index == 0) {
                newArray[0] = element;
                for (int i = 1; i < newSize; i++) {
                    newArray[i] = array[i - 1];
                }
            }
            else if (index == size) {
                for (int i = 0; i < size; i++) {
                    newArray[i] = array[i];
                }
                newArray[size] = element;
            }
            else {
                for (int i = 0; i < index; i++) {
                    newArray[i] = array[i];
                }
                newArray[index] = element;
                for (int j = index + 1; j < newSize; j++) {
                    newArray[j] = array[j - 1];
                }
            }
            array = newArray;
            size = newSize;
        }
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("올바른 인덱스 값을 입력하세요.");
        }
        else {
            array[index] = element;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("올바른 인덱스 값을 입력하세요.");
        }
        else {
            int newSize = size - 1;
            Object[] newArray = new Object[newSize];
            if (index == 0) {
                for (int i = 0; i < newSize; i++) {
                    newArray[i] = array[i + 1];
                }
            }
            else if (index == newSize) {
                for (int i = 0; i < newSize; i++) {
                    newArray[i] = array[i];
                }
            }
            else {
                for (int i = 0; i < index; i++) {
                    newArray[i] = array[i];
                }
                for (int j = index; j < newSize; j++) {
                    newArray[j] = array[j + 1];
                }
            }
            array = newArray;
            size = newSize;
        }
    }

    public boolean contains(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i] == object) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T object) {
        for(int i = 0; i < size; i++) {
            if (array[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        MyLittleArray<String> array = new MyLittleArray<String>(5);
        array.add("apple");
        array.add("banana");
        array.add("orange");
        array.add("melon");
        array.add("mango");
        array.add(0, "grape");
        array.add(2, "strawberry");
        array.add(7, "kiwi");

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        // array.set(10, "cherry");
        array.set(3, "cherry");

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        array.remove(0);
        array.remove(3);
        array.remove(5);

        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        System.out.println(array.contains("apple"));
        System.out.println(array.contains("pear"));

        System.out.println(array.indexOf("melon"));
        System.out.println(array.indexOf("banana"));

        System.out.println(array.size());
    }
}