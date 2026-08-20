package sample02;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
        employees[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
        employees[2] = new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);
        employees[3] = new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
        employees[4] = new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);

        //출력화면을 보고 코딩...
        System.out.println("**************** EMP 정보 ****************");
        for(int i = 0; i < employees.length; i++) { // 반복문으로 배열 조회
            System.out.println(employees[i]); // 객체 배열 주소값 반환
        }
        System.out.println();
        System.out.println("**************** EMP Message 정보 ****************");
        for(int i = 0; i < employees.length; i++) {
            employees[i].message();
        }
    }
}





