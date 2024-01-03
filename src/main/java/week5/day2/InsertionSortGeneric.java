package week5.day2;

import java.util.Arrays;

public class InsertionSortGeneric <T extends Comparable<T>> { // T라는 타입 매개변수가 Comparable<T> 인터페이스를 구현한 클래스나 인터페이스만을 허용한다는 것을 의미
    public T[] sort(T[] arr, boolean isAscending) { // 삽입정렬 제네릭 구현
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if ((isAscending ? arr[j].compareTo(arr[j - 1]) : arr[j - 1].compareTo(arr[j])) > 0) { // arr[j] 보다 arr[j-1]이 크다면 1반환 작으면 -1
                    T temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        return arr;
    }
    public T[] sort(T[] arr) {
        return sort(arr, true);
    }
    public static void main(String[] args) {
        Integer[] arr = {7, 2, 3, 9, 28, 11};
        Character[] cArr = {'h', 'e', 'g', 'a', 'c'};
        InsertionSortGeneric<Character> is = new InsertionSortGeneric();
        InsertionSortGeneric<Integer> isInt = new InsertionSortGeneric();
        System.out.println(Arrays.toString(is.sort(cArr, true)));
        System.out.println(Arrays.toString(isInt.sort(arr, false)));
        int resurt = arr[1].compareTo(arr[0]);
        System.out.println(resurt);
    }
}
