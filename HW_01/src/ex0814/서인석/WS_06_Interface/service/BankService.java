package ex0814.서인석.WS_06_Interface.service;

import ex0814.서인석.WS_06_Interface.dto.AccountDto;
import ex0814.서인석.WS_06_Interface.dto.UserDto;

import java.util.List;

public interface BankService {
    List<AccountDto> getAccountList(int userSeq);
    UserDto getUserDetail(int userSeq);
    List<AccountDto> getAccountList();
    List<AccountDto> getAccountListSortByBalance();
    List<AccountDto> getAccountListSortByUserSeq();
}
