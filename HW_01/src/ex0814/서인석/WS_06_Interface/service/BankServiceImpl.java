package ex0814.서인석.WS_06_Interface.service;

import ex0814.서인석.WS_06_Interface.dto.*;

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
     * 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드
     * */
    @Override
    public List<AccountDto> getAccountListSortByBalance() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy);
        return shallowCopy;
    }

    /*
     * 고객 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드
     * */
    @Override
    public List<AccountDto> getAccountListSortByUserSeq() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy, (a, b) -> b.getUserSeq() - a.getUserSeq());
        return shallowCopy;
    }
}
