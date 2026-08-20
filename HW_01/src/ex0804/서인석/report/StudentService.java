package ex0804.서인석.report;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
    private Student[] students = new Student[5];

    // count의 정보의 값을 EndView에서 사용하기 위에 public를 붙혀서 접근 가능하게 함
    // static를 사용해서 객체생성 없이 사용할 수 있다.
    public static int count = 0;

    /**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
    public void init(String[][] data) {
        for(int i=0; i<data.length; i++) {
            students[count++] = create(data[i]);
        }
    }
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */
    private Student create(String[] row) { // {"개나리", "27", "서울"}
        Student st = new Student();

        st.setName(row[0]);
        st.setAge(Integer.parseInt(row[1]));
        st.setAddr(row[2]);

        return st;
    }

	 /**
        학생의 정보 등록하기
        : 학생의 이름이 중복이면 등록할 수 없다.
        : 배열의 경계를 벗어나면 더이상 추가할 수 없다.
        : 이외에는 추가를 한다.

        @return : int type ( 0 = 중복, -1 = 더 이상 등록불가, 1 = 성공)
    **/
    public int insert(Student student) {
        // 배열의 경계를 벗어나면 더이상 추가 할 수 없다.
        if (count == students.length) return -1;

        // 학생의 이름이 중복이면 등록할 수 없다.
        Student searchedStudent = this.selectByName(student.getName());
        if (searchedStudent != null) return 0;
        students[count++] = student;

        return 1; // 성공
    }
	
	/**
	 * 전체 학생의 정보 조회하기
	 * */
    public Student[] selectAll() {
        return students;
    }
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를 리턴하고
	 *  : 없으면 null 리턴한다.
	 *  문자열 비교시에는 .equals() 메서드 사용
     * */
    public Student selectByName(String name) {
        // 기능작성
        for(int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];
            }
        }
        // 못 찾을 경우
        return null;
    }

    /**
     * 이름에 해당하는 학생의 나이와 주소 변경하기
     *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다" = false
     *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
     *   "수정되었습니다" = true
     *   @param : Student
     *   @return : boolean type
     *   true = 수정 성공, false 수정 실패
     * */
    public boolean update(Student student) {
        Student searchSt = this.selectByName(student.getName());
        if (searchSt == null) return false;

        // 수정하기
        searchSt.setAge(student.getAge());
        searchSt.setAddr(student.getAddr());

        return true;
    }

}

