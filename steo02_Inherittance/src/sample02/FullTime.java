package sample02;

public class FullTime extends Employee {
    private int salary;
    private int bonus;

    // 값을 초기화할 생성자 생성
    public FullTime() {}

    public FullTime(int empNo, String ename, String job, int mgr, String hiredate, String deepName, int salary, int bonus) {
        super(empNo, ename, job, mgr, hiredate, deepName);
        this.salary = salary;
        this.bonus = bonus;
    }

    // 변경과 수정이 가능하도록 get, set 구성
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void message() { // 메인 메소드에서 출력 될 값
        System.out.println(getEname() + "사원은 정규직입니다.");
    }

    @Override
    public String toString() {
        // StringBuilder 메소드로 주소값 String 형태로 변경
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | ").append(salary);
        sb.append(" | ").append(bonus);
        return sb.toString();
    }
}
