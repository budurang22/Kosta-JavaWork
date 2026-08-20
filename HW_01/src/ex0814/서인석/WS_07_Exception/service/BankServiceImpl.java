package ex0814.서인석.WS_07_Exception.service;

import ex0814.서인석.WS_07_Exception.exception.BalanceLackException;
import ex0814.서인석.WS_07_Exception.exception.UserAccountNotFoundException;
import ex0814.서인석.WS_07_Exception.dto.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */
public class BankServiceImpl implements BankService {
    // ArrayList 사용하여 AccountDto, UserDto 타입 설정
    ArrayList<UserDto> userList;
    ArrayList<AccountDto> accountList;

    public BankServiceImpl() {

        /**
         * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
         * */

        userList = new ArrayList<UserDto>();
        accountList = new ArrayList<AccountDto>();

        userList.add( new UserDto(111, "홍길동", "hong@gildong@com", "010-1111-1111", false) );
        userList.add( new UserDto(222, "이길동", "lee@gildong@com", "010-2222-2222", true) );
        userList.add( new UserDto(333, "삼길동", "sam@gildong@com", "010-3333-3333", false) );

        accountList.add( new LoanAccountDto(60, "00600606006006", 500, 333, "House") );
        accountList.add( new LoanAccountDto(30, "00300303003003", 0, 111, "Building") );
        accountList.add( new LoanAccountDto(50, "00500505005005", 200, 222, "Car") );
        accountList.add( new SavingAccountDto(10, "00100101001001", 500, 111, 100) );
        accountList.add( new SavingAccountDto(70, "00700707007007", 500, 333, 200) );
        accountList.add( new SavingAccountDto(40, "00400404004004", 1000, 222, 50) );
        accountList.add( new InstallAccountDto(20, "00200202002002", 1000, 111, 12, 10000) );
    }

    /**
     * 특정 사용자의 계좌 목록을(AccountDto) 배열로 리턴 하는 메소드를 작성한다
     * @return : List<AccountDto> 형태로 리턴
     */
    @Override
    public List<AccountDto> getAccountList(int userSeq) {
        List<AccountDto> result = new ArrayList<>();

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserSeq() == userSeq) {
                result.add(accountList.get(i));
            }
        }
        return result;

    }

    /**
     특정 사용자의 고객 정보를 리턴 하는 메소드를 작성한다
     @param : 고객의 sequence
     @return : null이면 고객의정보없다
     **/
    @Override
    public UserDto getUserDetail(int userSeq) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserSeq() == userSeq) {
                return userList.get(i);
            }
        }
        return null;
    }

    /*
     * 3) 모든 계좌 목록을 리턴 하는 메소드
     * */
    @Override
    public List<AccountDto> getAccountList() {
        return new ArrayList<>(accountList);
    }

    /*
     * 잔고 기준으로 *정렬* 한 모든 계좌 목록을 리턴 하는 메소드
     * */
    @Override
    public List<AccountDto> getAccountListSortByBalance() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy);
        return shallowCopy;
    }

    /*
     * 고객 기준으로 *정렬* 한 모든 계좌 목록을 리턴 하는 메소드
     * */
    @Override
    public List<AccountDto> getAccountListSortByUserSeq() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy, (a, b) -> b.getUserSeq() - a.getUserSeq());
        return shallowCopy;
    }
    /// //////////////////////// WS07 추가 메소드
    /*
    * 고객의 일련번호와 계좌 일련번를 받아 계좌정보를 리턴 하는 메소드
    * 일치하는 계좌가 없을 경우 UserAccoutNotFoundException 예외를 발생시킴
    * "사용자 또는 계좌를 찾을 수 없습니다"
    * */
    @Override
    public AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException {
        for(AccountDto account : accountList) {
            if (account.getUserSeq() == userSeq && account.getAccountSeq() == accountSeq) {
                return account;
            }
        }
        throw new UserAccountNotFoundException("사용자 또는 계좌를 찾을 수 없습니다.");
    }

    /*
    * 고객의 일련번호, 계좌 일련번호, 출금금액을 입력받아 출금을 처리하는 메소드
    * 잔액이 부족할 경우 BalanceLackException 예외를 발생시킴
    * "잔액이 부족합니다"
    * */
    @Override
    public int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException {
        AccountDto account = getUserAccount(userSeq, accountSeq);
        if (account.getBalance() < amount) {
            throw new BalanceLackException("잔액이 부족합니다.");
        }
        account.setBalance(account.getBalance() - amount);
        return account.getBalance();
    }
}
