package ex0813.set;

import java.util.*;

public class SetExam {
    // Set<String> set = new HashSet<>();
    Set<String> set = new TreeSet<>(Collections.reverseOrder());

    public SetExam(String[] data) {
        for(String s : data) {
            // 데이터 추가
            boolean re = set.add(s); // 중복 안된다
            System.out.println(s + " add 후 결과 = " + re);
        }
        System.out.println("최종결과 = " + set); // set.toString()
        System.out.println("저장된 개수 = " + set.size()); // set.toString()

        // 요소를 하나씩 꺼내기
        System.out.println("-- 저장된 요소 하나씩 꺼내기 --");

        // Iterator는 자료구조안에 있는 데이터를 꺼낼 수 있는 기능을 제공
        Iterator<String> it = set.iterator();

        while(it.hasNext()) { // hasNext()는 다음요소가 있다면 return
            String s = it.next();
            System.out.println(s);
        }
        /// /////////////////////////////////
        System.out.println("-- 개선된 for문 --");
        for(String s : set) System.out.println(s);

        System.out.println("-- 저장된 요소 제거하기 --");
        boolean re = set.remove("미미");
        System.out.println("re = " + re);

        System.out.println("제거 후 = " + set);
        
        re = set.contains("금배1");
        System.out.println("re = " + re);
    }

    public static void main(String[] args) {
        new SetExam(args);

    }
}
