package ex0804.서인석.report;

public class StudentTest {
	public static void main(String[] args) {

        String[][] data  = {
                {"개나리", "27", "서울"},
                {"미미", "25", "오리역"},
                {"멍청이", "30", "광주"},
        };

		System.out.println("****** 학생 관리 프로그램 시작 ******");
        //StudentService의 전역변수들이 초기화
		StudentService service = new StudentService();
		service.init(data); // 초기 데이터 세팅

		// 전체 학생정보 출력
		Student[] students = service.selectAll();

        EndView.printSelectAll(students);

		// 등록하기
		System.out.println("-------- 1.등록하기 -------");
		Student student = new Student();
		student.setName("재석");
		student.setAge(25);
		student.setAddr("오리역");

		int re = service.insert(student);
        if (re == -1) EndView.printMessage("더 이상 등록할 수 없습니다.");
        else if (re == 0) EndView.printMessage("이름이 중복입니다.");
        else EndView.printMessage("등록되었습니다.");

		System.out.println("-------- 2.전체검색 --------");
		EndView.printSelectAll(service.selectAll());

		// 이름으로 검색하기
		System.out.println("-------- 2.이름검색 --------");
		Student st = service.selectByName("재석");
        if (st == null) EndView.printMessage("이름에 해당하는 정보가 없습니다.");
        else EndView.printSelectByName(st);

		System.out.println("-------- 이름없음 --------");
        st = service.selectByName("멍멍");
        if (st == null) EndView.printMessage("이름에 해당하는 정보가 없습니다.");
        else EndView.printSelectByName(st);

        //수정하기
		System.out.println("-------- 4.수정하기 --------");
		Student st2 =new Student();
		st2.setName("나영"); //조건
		st2.setAge(23);
		st2.setAddr("대전");

		if (service.update(st2) ) {
            EndView.printMessage("수정되었습니다.");
        } else {
            EndView.printMessage("수정되지 않았습니다.");
        };

		System.out.println("-------- 변경 후 --------");
		students = service.selectAll();
        EndView.printSelectAll(students);
	}
}








