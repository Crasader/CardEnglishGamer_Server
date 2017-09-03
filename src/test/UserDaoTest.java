import org.kteam.dao.UserMapper;
import org.kteam.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hisenyuan on 2017/8/2 at 11:18.
 */
public class UserDaoTest extends BaseTest {
  @Autowired
  private UserMapper userMapper;

  /**
   * 测试添加用户
   */
  @Test
  public void insert(){
    try {
      User u = new User();
      u.setUserName("阿星");
      u.setUserAddress("北京市朝阳区");
      u.setUserPhone("13820080001");
      u.setUserNumber("20080004");
      int insert = userMapper.insert(u);
      System.out.println(insert);
    }catch (Exception e){
      e.printStackTrace();

    }

  }
}
