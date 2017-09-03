import org.junit.Test;
import org.kteam.entity.Account;
import org.kteam.service.impl.AccountManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/16 0016.
 */
public class AccountManagerImplTest  extends  BaseTest{
    @Autowired
    private AccountManagerImpl accountManagerImpl;

    @Test
    public void logintest(){
        try {
            Account a = new Account();
            a.setAccountName("robin");
            a.setAccountPsw("robin520.");
            a.setId(12345);
            accountManagerImpl.Login(a);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
