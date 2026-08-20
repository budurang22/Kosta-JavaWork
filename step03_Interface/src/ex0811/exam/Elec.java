package ex0811.exam;

public class Elec {
    private String code;
    private int cost;

    // construct
    public Elec() {
    }

    public Elec(String code, int cost) {
        this.code = code;
        this.cost = cost;
    }

    // getter / setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // toString overriding
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Elec{");
        sb.append("code='").append(code).append('\'');
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}
