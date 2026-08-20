package ex0811.exam;

public class Audio extends Elec implements ElecFunction {
    private int volume;

    public Audio() {
    }

    public Audio(int volume) {
        this.volume = volume;
    }

    public Audio(String code, int cost, int volume) {
        super(code, cost);
        this.volume = volume;
    }

    @Override
    public void start() {
        System.out.println(getCode() + " 제품 " + getClass().getSimpleName() + "를 " + volume + "으로 듣는다");
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
        sb.append(" Audio를 ").append(volume).append("으로 듣는다");
        return sb.toString();
    }
}
