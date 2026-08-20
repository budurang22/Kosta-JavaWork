package ex0814.서인석.WS_05_Extends.dto;

public class LoanAccountDto extends AccountDto {
    private String mortgage;

    public LoanAccountDto() {}

    public LoanAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, String mortgage) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.mortgage = mortgage;
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" mortgage = ").append(mortgage);
        return sb.toString();
    }
}
