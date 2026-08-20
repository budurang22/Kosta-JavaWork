package ex0814.서인석.WS_07_Exception.dto;

public class InstallAccountDto extends AccountDto {
    private int period;
    private int amount;

    public InstallAccountDto() {}

    public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.period = period;
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" period = ").append(period);
        sb.append(", amount = ").append(amount);
        return sb.toString();
    }
}
