package stream.ex01;                                          // stream.ex01 패키지

import java.util.ArrayList;                                    // 가변 리스트 구현체
import java.util.Arrays;                                       // 배열 -> List 변환용 (Arrays.asList)
import java.util.Collections;                                  // 컬렉션 정렬 등 유틸 (Collections.sort)
import java.util.Comparator;                                   // 정렬 기준을 정의하는 함수형 인터페이스
import java.util.List;                                         // 리스트 타입
import java.util.function.Predicate;                           // boolean을 리턴하는 함수형 인터페이스(필터 조건에 사용)

public class Test00 {

	public static void main(String[] args) {
        List<Student> students = Arrays.asList(                // 학생 4명을 담은 불변 리스트 생성 (테스트용 샘플 데이터)
                new Student("희정", 22, 88.5, "Computer Science"),
                new Student("가현", 24, 76.2, "Mathematics"),
                new Student("찬범", 23, 92.3, "Computer Science"),
                new Student("현솔", 25, 81.7, "Physics")
        );


		/* 문제
		 *  : 점수가 80이상인 학생 -> 점수를 기준으로 오름차순 -> 이름 모아서 List로 만들자.
		 */

		// ===================== 1. 기존(전통적) 방식 =====================
		List<Student> scoreList = new ArrayList<Student>();     // 조건(80점 이상)을 통과한 학생을 담을 빈 리스트

		//1.기존방식
		for(Student st : students) {                            // students를 처음부터 끝까지 한 명씩 순회
			if(st.getScore() >= 80) scoreList.add(st);          // 점수가 80 이상이면 scoreList에 추가
		}

		Collections.sort(scoreList, (s1, s2)->{ // scoreList를 람다로 정의한 비교 규칙에 따라 정렬
            double re = s1.getScore() - s2.getScore();          // 두 학생의 점수 차이 계산

			if(re == 0.0) return 0;                             // 점수가 같으면 0(순서 그대로)
			else if (re > 0.0) return 1;                        // s1 점수가 더 크면 1(s1을 뒤로 -> 오름차순)
			else return -1;                                     // s1 점수가 더 작으면 -1(s1을 앞으로)

		});

		List<String> names = new ArrayList<String>();                // 이름만 담을 빈 리스트
		for(Student st : scoreList) {                           // 정렬된 scoreList를 순회하며
			names.add(st.getName());                            // 학생 이름만 뽑아서 names에 추가
		}

		//출력
		for(String name : names) {                              // names 리스트를 순회하며
			System.out.println(name);                           // 이름 한 줄씩 출력
		}
		System.out.println("------------------");               // 구분선 출력
		////////////////////////////////////////////////////////
		/* 문제
		 *  : 점수가 80이상인 학생 -> 점수를 기준으로 오름차순 -> 이름 모아서 List로 만들자.
		 */
	   //2.Stream이용방식으로 해보자(stream얻기 -> 중간과정 반복-> 최종연산)
		/*students
		.stream()                                                // Stream 생성: List<Student> -> Stream<Student>
		.filter(new Predicate<Student>() {                       // filter()에 Predicate 익명 클래스를 직접 구현해서 전달(람다의 원형)
			 @Override
			public boolean test(Student t) {                    // Predicate 인터페이스의 추상 메서드 test() 구현

				return t.getScore() >=80;                        // 점수가 80 이상이면 true(통과)
			}
		});*/

        List<String> namesList = students
                .stream()                          // 1) 중간과정 시작: List -> Stream<Student> 변환(파이프라인 생성)
                .filter((s) -> s.getScore() > 80)      // 2) 중간연산: 점수가 80 초과인 학생만 통과 (Predicate<Student>를 람다로 축약)
                //.sorted(Comparator.comparingDouble((s)->s.getScore()));
                .sorted(Comparator.comparingDouble(Student::getScore)) // 3) 중간연산: 점수를 기준으로 오름차순 정렬 (메서드 참조로 정렬 키 지정)
                //.map((s)->s.getName());
                .map(Student::getName)             // 4) 중간연산: Stream<Student> -> Stream<String>으로 변환(학생 객체를 이름으로 매핑)
                .toList();                          // 5) 최종연산: 지금까지의 파이프라인을 실행시키고 결과를 List<String>으로 수집

        System.out.println("개수 = " + namesList.size());            // 최종 리스트의 크기(개수) 출력
        System.out.println(namesList);                              // 최종 리스트 내용 출력


	}

}
