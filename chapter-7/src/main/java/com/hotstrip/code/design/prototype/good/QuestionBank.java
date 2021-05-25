package com.hotstrip.code.design.prototype.good;

import com.hotstrip.code.design.prototype.base.AnswerQuestion;
import com.hotstrip.code.design.prototype.base.ChoiceQuestion;
import com.hotstrip.code.design.prototype.good.util.Topic;
import com.hotstrip.code.design.prototype.good.util.TopicRandUtil;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @author hotstrip
 * 题库复制对象类
 */
public class QuestionBank implements Cloneable {
    // 考生
    @Setter
    private String candidate;
    // 考号
    @Setter
    private String number;
    // 选择题
    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();
    // 问答题
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    /**
     * 添加选择题
     * @param choiceQuestion
     * @return
     */
    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        this.choiceQuestionList.add(choiceQuestion);
        return this;
    }

    /**
     * 添加问答题
     * @param answerQuestion
     * @return
     */
    public QuestionBank append(AnswerQuestion answerQuestion) {
        this.answerQuestionList.add(answerQuestion);
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        // 题目混排
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        // 答案混排
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion choiceQuestion:choiceQuestionList) {
            Topic topic = TopicRandUtil.random(choiceQuestion.getOption(), choiceQuestion.getKey());
            choiceQuestion.setOption(topic.getOption());
            choiceQuestion.setKey(topic.getKey());
        }
        return questionBank;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n")
                .append("考号：" + number + "\r\n")
                .append("-----------------------\r\n")
                .append("一、选择题\r\n");
        for (int i = 0; i < choiceQuestionList.size(); i++) {
            detail.append("第").append(i + 1).append("题：")
                    .append(choiceQuestionList.get(i).getName())
                    .append("\r\n");
            Map<String, String> option = choiceQuestionList.get(i).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");

            }
            detail.append("答案：")
                    .append(choiceQuestionList.get(i).getKey())
                    .append("\r\n");
        }
        detail.append("二、问答题\r\n");
        for (int i = 0; i < answerQuestionList.size(); i++) {
            detail.append("第").append(i + 1).append("题：")
                    .append(answerQuestionList.get(i).getName())
                    .append("\r\n");
            detail.append("答案：")
                    .append(answerQuestionList.get(i).getKey())
                    .append("\r\n");
        }
        return detail.toString();
    }
}
