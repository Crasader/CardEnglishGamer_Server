import org.junit.Test;
import org.kteam.entity.Question;
import org.kteam.service.QuestionManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class QuestionTest extends BaseTest {
    @Autowired
    private QuestionManager questionManager;
    @Test
    public void query(){
        Question q = questionManager.getById(123);
        System.out.println(q.getChoose2());
    }

}
