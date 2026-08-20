package ex0813.서인석.WS_04_Collection.view;

import ex0813.서인석.WS_04_Collection.dto.AccountDto;
import ex0813.서인석.WS_04_Collection.dto.UserDto;
import ex0813.서인석.WS_04_Collection.service.BankService;

import java.util.ArrayList;
import java.util.List;

public class TestView {

	public static void main(String[] args) {
		System.out.println("***** 1. 고객 seq 100 에 해당하는 계좌정보 검색하기 *****");
		BankService service = new BankService();
		
        List<AccountDto> accountList = service.getAccountList(100);
		
		if(accountList == null || accountList.isEmpty()) {
			System.out.println("회원의 계좌정보가 없습니다. ");
		}else {
			System.out.println("회원계좌개수 : " + accountList.size());
			for(AccountDto dto : accountList) {
				System.out.println(dto.getAccountSeq() +" , "
			+ dto.getAccountNumber()+" , " + dto.getUserSeq());

			}
		}

		System.out.println("\n\n***** 2. userSeq에  해당하는 고객의 정보 *************");
		UserDto userDto = service.getUserDetail(100);//300 userSeq
		if(userDto!= null) {
		  System.out.print(userDto.getUserSeq() +" , " + userDto.getName()+" , " +
		            userDto.getEmail()+" , ");
		  System.out.println(userDto.getPhone() +" , " + userDto.isSleep());
			
		}else {
			System.out.println("회원의 정보가 없습니다.");
		}


	}//메인끝

}// 클래스 끝





