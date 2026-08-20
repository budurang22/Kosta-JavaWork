package ex0813.list;

/*
* 사원정보 DTO
* */

public class Emp implements Comparable<Emp>{
    private int empNo;
    private String ename;
    private int age;
    private String addr;

    public Emp () {}

    public Emp(int empNo, String ename, int age, String addr) {
        this.empNo = empNo;
        this.ename = ename;
        this.age = age;
        this.addr = addr;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("empNo=").append(empNo);
        sb.append(", ename=").append(ename);
        sb.append(", age=").append(age);
        sb.append(", addr=").append(addr);
        return sb.toString();
    }

    @Override
    public int compareTo(Emp o) {
        System.out.println("111 => " + o);

        /*if (empNo == o.getEmpNo()) return 0;
        else if (empNo > o.getEmpNo()) return 1;
        else return -1;*/

        return o.getEmpNo() - empNo ; // 내림차순
    }
}
