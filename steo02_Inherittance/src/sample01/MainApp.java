package sample01;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FullTime [] full = new FullTime[3];
		PartTime [] part = new PartTime[2];


        full[0] = new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200);
		full[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
        full[2] = new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0);

        part[0] = new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000);
        part[1] = new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000);

		//출력화면을 보고 코딩...
        System.out.println("**************** FullTime 정보 ****************");
        for(int i = 0; i < full.length; i++) { // 반복문으로 fulltime full 배열 조회
            System.out.println(full[i]); // 객체 배열 주소값 반환
        }
        System.out.println();

        System.out.println("**************** PartTime 정보 ****************");
        for(int i = 0; i < part.length; i++) { // 반복문으로 parttime part 배열 조회
            System.out.println(part[i]); // 객체 배열 주소값 반환
        }
        System.out.println();

        System.out.println("**************** Message ****************");
        for(int i = 0; i < full.length; i++) {
            full[i].message(); // 반환된 full 배열 주소값을 FullTime의 toString 메소드에서 builder메소드 사용하여 String으로 변경
        }
        for(int i = 0; i < part.length; i++) {
            part[i].message(); // 반환된 full 배열 주소값을 PartTime의 toString 메소드에서 builder메소드 사용하여 String으로 변경
        }
    }

}






