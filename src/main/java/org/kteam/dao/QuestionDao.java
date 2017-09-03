package org.kteam.dao;

import org.apache.ibatis.annotations.Param;
import org.kteam.entity.Question;


import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public interface QuestionDao {
    Question queryById(int id);
    List<Question> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    int addQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestionById(int id);
    int countNum();
    List<Question> queryAllPlug();
}
