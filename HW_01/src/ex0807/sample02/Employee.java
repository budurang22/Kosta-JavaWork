package ex0807.sample02;

public class Employee {
    private int empNo;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private String deepName;

    public Employee() {}

    public Employee(int empNo, String ename, String job, int mgr, String hiredate, String deepName) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.deepName = deepName;
    }

    public String getDeepName() {
        return deepName;
    }

    public void setDeepName(String deepName) {
        this.deepName = deepName;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    // 상속받은 자식 클래스에서 오버라이딩 구현
    public void message() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" | ").append(empNo);
        sb.append(" | ").append(ename);
        sb.append(" | ").append(job);
        sb.append(" | ").append(mgr);
        sb.append(" | ").append(hiredate);
        sb.append(" | ").append(deepName);
        return sb.toString();
    }
}
