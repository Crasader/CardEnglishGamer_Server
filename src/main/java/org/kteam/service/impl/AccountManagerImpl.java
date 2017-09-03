package org.kteam.service.impl;

import org.kteam.dao.AccountMapper;
import org.kteam.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/16 0016.
 */

@Service("AccountManagerImpl")
@Scope
public class AccountManagerImpl {

    @Autowired
    private AccountMapper accountMapper;

    public short Login(Account account){
        short statu = 0;
        Account account_found = accountMapper.queryByID(account);
        if(account_found == null){
            return statu;
        }else{
            if(account.getAccountPsw().equals(account_found.getAccountPsw())){
               statu =  2;	//用户密码正确返回2
            }else{
                statu =  1;	//用户密码错误返回1
            }
        }
        return statu;
    }

    public short Register(Account account){
        short statu = 0;
        Account account_found = accountMapper.queryByID(account);
        if(account_found != null){
            return statu;
        }else{
           statu = (short)accountMapper.insert(account);
        }
        return statu;
    }
}
