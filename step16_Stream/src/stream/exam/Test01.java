package stream.exam;

import java.util.*;
import java.util.stream.*;

/**
 * 평균 점수 구하기 (filter + mapToDouble + average)
 *  List<Student>에서 전공이 "Computer Science"인 학생들의 평균 점수를 구하시오.
 * */

public class Test01 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("희정", 22, 88.5, "Computer Science"),
            new Student("가현", 24, 76.2, "Mathematics"),
            new Student("찬범", 23, 92.3, "Computer Science"),
            new Student("현솔", 25, 81.7, "Physics")
        );

        double avg = students.stream() // 변수 students를 stream으로 흘려보내기
                .filter(s -> s.getMajor().equals("Computer Science")) // 필터로 major를 가져와서 문자열로 비교
                .mapToDouble(Student:: getScore) // 가져온 문자열을 double형 변환 (점수)
                .average() // 걸러온 내용이 있을수도 있고 없을 수도 있어서 임의로 넣어둿다고 생각
                .getAsDouble(); // 있으면 더블로 값 꺼내고 없으면 NoSuchElementException error표기

        System.out.println("Computer Science 전공 평균 점수: " + avg);
    }
}
