package ex0813.서인석.WS_04_Collection.service;

import ex0813.서인석.WS_04_Collection.dto.AccountDto;
import ex0813.서인석.WS_04_Collection.dto.UserDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 고객과 계좌에 관련된 서비스
 * (Business Logic 을 처리하는 객체)
 * */

public class BankService {

	// ArrayList 사용하여 AccountDto, UserDto 타입 설정
	ArrayList<UserDto> userList;
    ArrayList<AccountDto> accountList;
    /**
	 * 생성자에서 테스트를 위한 고객 및 계좌 객체를 생성하고 배열에 저장한다
	 * */
	public BankService() {
		// 배열 생성
        userList = new ArrayList<UserDto>();
        accountList = new ArrayList<AccountDto>();
		
        // 각 배열방에 고객과 계좌를 생성한다.
        //고객 4명
        userList.add(new UserDto(100, "장희정", "8253jang@daum.net", "010-8875-8253", false));
        userList.add(new UserDto(200, "이효리", "lee@daum.net", "010-2222-3333", false));
        userList.add(new UserDto(300, "송중기", "song@naver.com", "010-5554-2222", false));
        userList.add(new UserDto(400, "삼순이", "sam@daum.com", "010-2222-2222", false));

        //계좌는 6개 정도
        accountList.add(new AccountDto(1, "1111-11111", 1000000, 100));
        accountList.add(new AccountDto(2, "2222-22222", 250000, 100));
        accountList.add(new AccountDto(3, "3333-33333", 350000, 100));
        accountList.add(new AccountDto(4, "4444-44444", 150000, 200));
        accountList.add(new AccountDto(5, "5555-55555", 250000, 200));
        accountList.add(new AccountDto(6, "6666-66666", 350000, 300));

	} // 생성자 끝
	
    /**
     * 특정 사용자의 계좌 목록을(AccountDto) 배열로 리턴 하는 메소드를 작성한다
     * @return : AccountDto[] 형태로 리턴
	*/

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
    public List<AccountDto> getAccountList() {
        return new ArrayList<>(accountList);
    }

    /*
    * 잔고 기준으로 정렬한 모든 계좌 목록을 리턴 하는 메소드
    * */

    public List<AccountDto> getAccountListSortByBalance() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy);

        return shallowCopy;
    }

    public List<AccountDto> getAccountListSortByUserSeq() {
        List<AccountDto> shallowCopy = new ArrayList<>(accountList);
        Collections.sort(shallowCopy, (a, b) -> b.getUserSeq() - a.getUserSeq());

        return shallowCopy;
    }

}