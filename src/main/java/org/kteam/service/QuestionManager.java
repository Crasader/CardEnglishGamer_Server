package org.kteam.service;

import org.kteam.entity.Question;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public interface QuestionManager {
    Question getById(int ID);
    List<Question> getList(int start, int pageNum);
    int addQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestionById(int ID);
    int countNum();
    List<Question> getListPlug();
}
