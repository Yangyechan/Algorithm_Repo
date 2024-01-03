package week5.day3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack1 {
    private int[] arr = new int[10];
    private int pointer = 0;

    public void push(int value) {
        this.arr[pointer++] = value; // value값을 push메소드로 받아서 arr에 저장하고 pointer를 1 증가시킴
        //System.out.println(pointer);
        //System.out.println(Arrays.toString(arr));
    }
    public int pop() {
        if (!isEmpty()){
            return arr[--pointer]; // pop 메소드를 호출하면 pointer변수를 감소시키고 arr 반환
        }else {
            throw new EmptyStackException();
        }
    }
    public boolean isEmpty(){
        return pointer == 0;
    } // pointer가 0이면 true 반환
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException();
        }else return arr[pointer-1]; // 현재 pointer 값 -1 결과 즉 제일 늦게 pop된 결과 반환
    }

    public static void main(String[] args) {
        Stack1 st = new Stack1();
        st.push(10);
        System.out.println(st.pop()); // 10
        st.push(20);
        System.out.println(st.peek()); // 20
    }
}
