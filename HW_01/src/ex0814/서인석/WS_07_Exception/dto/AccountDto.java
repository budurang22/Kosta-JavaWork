package ex0814.서인석.WS_07_Exception.dto;

/**
 *  고객의 계좌정보 관리하는 객체
 * */
public class AccountDto implements Comparable<AccountDto> {

    private int accountSeq;
    private String accountNumber;
    private int balance;
    private int userSeq;

    public AccountDto() {

    }

    public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
        this.accountSeq = accountSeq;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userSeq = userSeq;
    }

    public int getAccountSeq() {
        return accountSeq;
    }

    public void setAccountSeq(int accountSeq) {
        this.accountSeq = accountSeq;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountDto ");
        sb.append("accountSeq= ").append(accountSeq);
        sb.append(", accountNumber= ").append(accountNumber).append('\'');
        sb.append(", balance= ").append(balance);
        sb.append(", userSeq= ").append(userSeq);
        return sb.toString();
    }

    @Override
    public int compareTo(AccountDto other) {
        return this.getBalance() - other.getBalance();
    }
}
