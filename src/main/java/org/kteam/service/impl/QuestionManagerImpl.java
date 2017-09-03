package org.kteam.service.impl;

import org.kteam.dao.QuestionDao;
import org.kteam.entity.Question;
import org.kteam.service.QuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
@Service
public class QuestionManagerImpl implements QuestionManager{
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question getById(int ID) {
        return questionDao.queryById(ID);
    }

    @Override
    public List<Question> getList(int start, int pageNum) {
        return null;
    }

    @Override
    public int addQuestion(Question question) {
        return 0;
    }

    @Override
    public int updateQuestion(Question question) {
        return 0;
    }

    @Override
    public int deleteQuestionById(int ID) {
        return 0;
    }

    @Override
    public int countNum() {
        return 0;
    }

    @Override
    public List<Question> getListPlug() {
        return null;
    }
}
