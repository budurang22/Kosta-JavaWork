package ex0807.sample01;

public class FullTime {
    private int empNo;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private String deepName;
    private int salary;
    private int bonus;

    // 값을 초기화할 생성자 생성
    public FullTime() {}

    public FullTime(int empNo, String ename, String job, int mgr, String hiredate, String deepName, int salary, int bonus) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.deepName = deepName;
        this.salary = salary;
        this.bonus = bonus;
    }

    // 변경과 수정이 가능하도록 get, set 구성
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getDeepName() {
        return deepName;
    }

    public void setDeepName(String deepName) {
        this.deepName = deepName;
    }

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

    public void message() { // 메인 메소드에서 출력 될 값
        System.out.println(ename + "사원은 정규직입니다.");
    }

    @Override
    public String toString() {
        // StringBuilder 메소드로 주소값 String 형태로 변경
        final StringBuilder sb = new StringBuilder();
        sb.append(empNo);
        sb.append(" | ").append(ename).append('\'');
        sb.append(" | ").append(job).append('\'');
        sb.append(" | ").append(mgr);
        sb.append(" | ").append(hiredate).append('\'');
        sb.append(" | ").append(deepName).append('\'');
        sb.append(" | ").append(salary);
        sb.append(" | ").append(bonus);
        return sb.toString();
    }
}
