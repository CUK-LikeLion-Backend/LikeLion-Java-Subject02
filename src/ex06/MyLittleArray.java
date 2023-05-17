package ex06;
//ArrayList 만들어보기
public class MyLittleArray {
    private Object[] elements;
    private int size;

    public MyLittleArray(){
        this.elements = new Object[10];
        this.size = 0;
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return elements[index];
    }

    public void add(Object element){
        ensureCapacity(size + 1);   //배열 크기(용량) 확인 /최소 size+1만큼의 크기는 되어야함
        elements[size] = element;
        size++;
    }

    public void add(int index, Object element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        //elemets[index] 에서 size-index만큼 elements[index+1]에 복사됨 /-> 한칸씩 뒤로
        elements[index] = element;  //인덱스에 요소 추가
        size++;
    }

    public void set(int index, Object element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        elements[index] = element;
    }

    public void remove(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of range");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        //elemets[index + 1] 에서 size-index-1만큼 elements[index]에 복사됨
        //기존의 index 사라짐
        elements[size - 1] = null;  //마지막 원소 제거
        size--;
    }

    public boolean contains(Object object){ //지정된 요소가 ArrayList에 포함되어 있는지 확인

        return indexOf(object) != -1;
    }

    public int indexOf(Object object){  // 지정된 요소의 첫 번째 등장 인덱스를 반환
        for(int i = 0; i < size; i++){
            if(object == null){     //찾으려는 객체가 null인지 확인
                if(elements[i] == null) {
                    return i;   //null인 인덱스 반환
                }
            }else{
                if(object.equals(elements[i])){ //찾으려는 객체와 일치하는 요소가 있으면
                    return i;   //해당 요소 인덱스 반환
                }
            }
        }
        return -1;  //일치하는 요소 없으면
    }

    public int size(){
        return size;
    }

    private void ensureCapacity(int minCapacity) {  //배열의 크기를 동적으로 조절하는 메소드
        if (minCapacity > elements.length) {    //요청된 최소 용량이 현재 배열 길이보다 크다면
            int newCapacity = Math.max(elements.length * 2, minCapacity);   
            //새로운 용량 결정 위해 현재 배열 길이 2배와 최소 용량 중 큰 값 선택

            Object[] newElements = new Object[newCapacity];     //새로운 용량 갖는 배열생성
            System.arraycopy(elements, 0, newElements, 0, size);
            //현재 배열의 처음부터 끝까지 새로운 배열로 요소 복사
            elements = newElements;  //기존 배열을 새로운 배열로 대체
        }
    }

    public static void main(String[] args) {
        MyLittleArray myArray = new MyLittleArray();

        // 요소 추가
        myArray.add("Apple");
        myArray.add("Banana");
        myArray.add("Cherry");

        // 요소 가져오기
        System.out.println("Element at index 1: " + myArray.get(1));

        // 요소 수정
        myArray.set(2, "Durian");

        // 요소 제거
        myArray.remove(0);

        // 요소 포함 여부 확인
        System.out.println("Contains Apple?: " + myArray.contains("Apple"));

        // 요소의 인덱스 찾기
        System.out.println("Index of Durian: " + myArray.indexOf("Durian"));

        // 배열 크기 확인
        System.out.println("Array size: " + myArray.size());
    }

}
