package ex0814.서인석.WS_07_Exception.view;

import ex0814.서인석.WS_07_Exception.exception.BalanceLackException;
import ex0814.서인석.WS_07_Exception.exception.UserAccountNotFoundException;
import ex0814.서인석.WS_07_Exception.dto.AccountDto;
import ex0814.서인석.WS_07_Exception.service.BankServiceImpl;

import java.util.List;

public class TestView02 {
	public static void main(String[] args) {
		
		BankServiceImpl bankService = new BankServiceImpl();
/*
		System.out.println("1. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList()  );
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
*/

		System.out.println("5. 고객의 일련번호와 계좌 일련번호를 받아 계좌정보 출력 ------");
        try {
            AccountDto account = bankService.getUserAccount(111, 100);
            System.out.println("account = " + account);
        } catch (UserAccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("6. 고객의 일련번호, 계좌 일련번호, 출금금액을 입력받아 출력 ------");
        try {
            int balance = bankService.withdraw(111, 10, 100);
            System.out.println("출금 후 잔액  = " + balance);
        } catch (BalanceLackException | UserAccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
	}
	
	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(List<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

}
