package ex0813.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListExam01 extends ArrayList<Integer> {
    public ListExam01() {
        super(5); // 5개 공간을 만든다.

        // 데이터 추가
        super.add(8);
        this.add(10);
        add(3);
        add(2);
        add(5);
        add(6);
        add(1);

        //몇개 저장했는지 알기
        System.out.println("저장된 객체의 개수 = " + super.size());

        //요소 꺼내기
        for (int i = 0; i < super.size(); i++) {
            int value = super.get(i);
            System.out.println(value);
        }

        System.out.println("-- 개선된 for문 --");
        for(int i : this) {
            System.out.println(i);
        }
        // 제거
        System.out.println("this = " + this); //this.toString() 호출된다;
        super.remove(2);
        System.out.println(this);

        //정렬
        Collections.sort(this);
        System.out.println(this);

        //내림차순 변경
        Collections.sort(this, Collections.reverseOrder());
        System.out.println(this);
    }

    public static void main(String[] args) {
        new ListExam01();
    }
}
