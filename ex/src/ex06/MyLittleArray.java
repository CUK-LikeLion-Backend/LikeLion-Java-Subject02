package ex06;

class MyLittleArray {
    private Object[] elements;
    private int size;

    public MyLittleArray() {
        elements = new Object[10];
        size = 0;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void add(Object element) {
        if (size == elements.length) { // 배열 만땅
            int newlength = elements.length * 2;
            Object[] newElements = new Object[newlength];
            System.arraycopy(elements, 0, newElements, 0, size); // 기존 배열을 새로운 배열로 복사
            elements = newElements;
        }
        elements[size++] = element;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) { // 배열 만땅
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1; // 객체의 인덱스 반환
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                if (object == null) {
                    return i;
                }
            } else {
                if (elements[i].equals(object)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        MyLittleArray array = new MyLittleArray();

        // add elements
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");

        System.out.println("get: "+array.get(2));
        array.set(1, "좀비");
        System.out.println("get: "+array.get(1));
        array.add(0, "좀비2");
        System.out.println("get: "+ array.get(0));
        array.remove(3);
        System.out.println("get: " + array.get(3));
        System.out.println("contains: " + array.contains("좀비"));
        System.out.println("index: " + array.indexOf("좀비2"));
        System.out.println("size: " + array.size());
    }
}

