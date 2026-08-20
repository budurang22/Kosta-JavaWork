package ex0807.sample02;

public class PartTime extends Employee {
    private int timePay;

    // 값을 초기화할 생성자 생성
    public PartTime() {}

    public PartTime(int empNo, String ename, String job, int mgr, String hiredate, String deepName, int timePay) {
        super(empNo, ename, job, mgr, hiredate, deepName);
        this.timePay = timePay;
    }

    // 변경과 수정이 가능하도록 get, set 구성
    public int getTimePay() {
        return timePay;
    }

    public void setTimePay(int timePay) {
        this.timePay = timePay;
    }

    public void message() { // 메인 메소드에서 출력 될 값
        System.out.println(getEname() + "사원은 비정규직입니다");
    }

    @Override
    public String toString() {
        // StringBuilder 메소드로 주소값 String 형태로 변경
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | ").append(timePay);
        return sb.toString();
    }
}
