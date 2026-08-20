package ex0814.서인석.WS_07_Exception.service;

import ex0814.서인석.WS_07_Exception.exception.BalanceLackException;
import ex0814.서인석.WS_07_Exception.exception.UserAccountNotFoundException;
import ex0814.서인석.WS_07_Exception.dto.AccountDto;
import ex0814.서인석.WS_07_Exception.dto.UserDto;

import java.util.List;

public interface BankService {
    List<AccountDto> getAccountList(int userSeq);
    UserDto getUserDetail(int userSeq);
    List<AccountDto> getAccountList();
    List<AccountDto> getAccountListSortByBalance();
    List<AccountDto> getAccountListSortByUserSeq();
    AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;
    int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException;
}
