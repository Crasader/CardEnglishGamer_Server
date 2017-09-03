import org.junit.Test;
import org.kteam.dao.AccountMapper;
import org.kteam.dao.UserMapper;
import org.kteam.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/13 0013.
 */
public class AccountDaoTest extends BaseTest {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 测试添加用户
     */
    @Test
    public void insert(){
        try {
            Account a = new Account();
            a.setAccountName("robin");
            a.setAccountPsw("robin520.");
            a.setId(12345);
            Account c = accountMapper.queryByID(a);
            System.out.println(c);
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
