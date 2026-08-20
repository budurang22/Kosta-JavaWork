package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam02 {

    // List<Integer> list = new ArrayList<Integer>(5);
    ///List<Integer> list = new Linked LinkedList <Integer>(5);
    // RList<Integer> list = new ArrayList<Integer>(5);
    List<Integer> list = new ArrayList<>(5);

    public ListExam02() {
        list.add(10);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(1);

        //몇개 저장했는지 알기
        System.out.println("저장된 객체의 개수 = " + list.size());

        //요소 꺼내기
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            System.out.println(value);
        }

        System.out.println("-- 개선된 for문 --");
        for(int i : list) {
            System.out.println(i);
        }
        // 제거
        System.out.println("this = " + list); //this.toString() 호출된다;
        list.remove(2);
        System.out.println(list);

        //정렬
        Collections.sort(list);
        System.out.println(list);

        //내림차순 변경
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }

    public static void main(String[] args) {
        new ListExam02();
    }
}
