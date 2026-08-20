package ex0811.exam;

public class Tv extends Elec implements ElecFunction {
    private int chnnel;

    public Tv() {

    }

    public Tv(int chnnel) {
        this.chnnel = chnnel;
    }

    public Tv(String code, int cost, int chnnel) {
        super(code, cost);
        this.chnnel = chnnel;
    }

    public int getChnnel() {
        return chnnel;
    }

    public void setChnnel(int chnnel) {
        this.chnnel = chnnel;
    }

    @Override
    public void start() {
        System.out.println(getCode() + " 제품 " + getClass().getSimpleName() + "를 " + chnnel + "으로 듣는다");
    }

    @Override
    public void display() {

    }

    @Override
    public void stop() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getCode());
        sb.append(" TV를 ").append(chnnel).append("를 본다");
        return sb.toString();
    }
}