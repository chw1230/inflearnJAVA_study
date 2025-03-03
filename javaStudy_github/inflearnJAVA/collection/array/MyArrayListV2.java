package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5; // 기본 배열 크기 지정하기

    private Object[] elementData; // 다양한 테이터 타입 보관을 위해서 사용
    private int size = 0; // 입력된 데이터의 수를 의미하는 size 만들기!

    public MyArrayListV2(){ // 기본 생성자에서 elementData 배열 크기 정해주기
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) { // 기본 배열크기가 아닌 다른 크기를 사용하고 싶다면
        // elementData 배열 크기 정해주는 이 생성자를 사용하기
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e) {
        // 코드 추가
        if (size == elementData.length) { // 사이즈(입력된 데이터의 수를 의미)가 배열의 길이와 같은 상황이라면
            grow(); // 배열을 키워주기!
        }
        elementData[size] = e;
        size++;
    }

    // 코드 추가
    private void grow(){
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2; // 새로운 배열 길이를 만들기! 이걸 이용하여
        // 배열을 새로 만들고, 기존 배열을 새로운 배열에 복사하기!
        /*
        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < elementData.length; i++) {
            newArr[i] = elementData[i];
        }
         */
        // 우측의 길이 만한 배열을 만들어서 좌측의 배열을 복사 붙여넣기!!!
        // 그러므로 배열의 길이는 newCapacity이고, 내용은 기존의 elementData가 들어있음!
        elementData = Arrays.copyOf(elementData, newCapacity);
        // 참조를 바꿔버리기!!!!
    }

    public Object get(int index) { // 해당 인덱스에 있는 항목 조회
        return elementData[index];
    }

    public Object set(int index, Object element) { // 인덱스에 있는 항목을 변경
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(Object o) { // 검색기능 리스트 순차 탐색 후 인수와 같은 데이터 있는지 인덱스 위치 반환
        for (int i = 0; i < size; i++) { // 데이터 들어온 만큼 만 찾을 거니까 size 까지만
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1; // 없으면 -1 반환
    }

    public String toString(){
        // [ 1,2,3,null,null] , size 3
        // [1,2,3] 뒤의 null 빼고 size 3 만큼만 출력
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size=" + size + ", capacity=" + elementData.length;
        // copyOf(elementData,size) -> 좌측의 배열에서 우측의 사이즈 만큼만 카피하는 것!!
    }

}
