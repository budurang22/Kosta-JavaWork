package ex0803.서인석.report;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int [] arr = { 5, 7, 1, 2, 4, 3, 8, 9, 6, 10 };
        /* Arrays는 클래스, .sort는 메서드
        * 오름차순 정렬 : Arrays.sort(배열)
        * 내림차순 정렬 : Arrays.sort(arr, Collection.reversOrder())
        * println을 사용해야할 때는 arr <- 객체라서 주소값으로 나옴
        * 따라서 Arrays.toStirng(arr)로 변환해서 출력해준다
        * */
        Arrays.sort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
