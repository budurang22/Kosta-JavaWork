package stream.ex01;                                          // stream.ex01 패키지

import java.util.Arrays;                                       // 배열 -> List 변환용 (Arrays.asList)
import java.util.List;                                         // 리스트 타입

public class ParalleStramExam01 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie",  // 이름 문자열 7개를 담은 불변 리스트 생성
				"David","Charlie","Charlie", "Charlie");

		//기존방식
		for (String name : names) {                             // names를 처음부터 끝까지 순서대로 순회 (단일 스레드)
		    if (name.startsWith("C")) {                          // 이름이 "C"로 시작하는지 검사
		        System.out.println(Thread.currentThread().getName() + " - " + name); // 현재 실행 스레드 이름 + 매칭된 이름 출력 (항상 main)
		    }
		}


		System.out.println("--Stream을 이용한 처리 -----------");   // 구분 출력
		//names.stream()                                          // (참고) 순차 스트림이면 for문처럼 항상 main 스레드에서 순서대로 처리됨
		names.parallelStream()                                    // 병렬 스트림 생성: 내부적으로 데이터를 나눠 여러 스레드(Fork/Join)에 분배
	     .filter(name -> name.startsWith("C"))             // 중간연산: "C"로 시작하는 이름만 필터링 (각 스레드가 자기 몫을 병렬로 처리)
	     .forEach(name ->                                  // 최종연산: 요소마다 실행, 병렬이라 스레드/순서가 매번 달라질 수 있음
	         System.out.println(Thread.currentThread().getName() + " - " + name)
                 // 실행한 스레드 이름 + 이름 출력 (main 외에 worker 스레드도 섞여 나옴)
	     );

	}

}
