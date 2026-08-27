package stream.ex01;                                          // stream.ex01 패키지에 속한 클래스

public class Student {                                         // 학생 정보를 담는 VO(값 객체) 클래스
	private String name;                                       // 이름 필드 (private -> 외부에서 직접 접근 불가, getter로만 조회)
    private int age;                                           // 나이 필드
    private double score;                                      // 점수 필드 (필터/정렬 기준으로 자주 사용됨)
    private String major;                                      // 전공 필드

    public Student(String name, int age, double score, String major) { // 생성자: new Student(...) 호출 시 값 초기화
        this.name = name;                                      // 매개변수 name -> 필드 name 대입 (this로 구분)
        this.age = age;                                        // 매개변수 age -> 필드 age 대입
        this.score = score;                                    // 매개변수 score -> 필드 score 대입
        this.major = major;                                    // 매개변수 major -> 필드 major 대입
    }

    public String getName() { return name; }                  // 이름 반환 getter -> Stream에서 Student::getName 형태로 자주 사용
    public int getAge() { return age; }                        // 나이 반환 getter
    public double getScore() { return score; }                 // 점수 반환 getter -> Stream에서 Student::getScore로 정렬/필터 기준에 사용
    public String getMajor() { return major; }                 // 전공 반환 getter

    @Override                                                  // Object 클래스의 toString()을 재정의한다는 표시
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", score=" + score + ", major='" + major + "'}";
        // 객체를 println()으로 출력할 때 필드 값이 보기 좋게 문자열로 나오도록 구성
    }
}
