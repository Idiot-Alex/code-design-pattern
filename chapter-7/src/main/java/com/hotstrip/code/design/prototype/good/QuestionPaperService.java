package com.hotstrip.code.design.prototype.good;

import com.hotstrip.code.design.prototype.base.AnswerQuestion;
import com.hotstrip.code.design.prototype.base.ChoiceQuestion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hotstrip
 * 试卷 service
 */
public class QuestionPaperService {
    private QuestionBank questionBank = new QuestionBank();

    public QuestionPaperService() {
        Map<String, String> map01 = new HashMap<>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");

        Map<String, String> map02 = new HashMap<>();
        map02.put("A", "JAVA 程序的 main 方法必须写在类里面");
        map02.put("B", "JAVA 程序中可以有多个 main 方法");
        map02.put("C", "JAVA 程序中类名必须与文件名一样");
        map02.put("D", "JAVA 程序的 main 方法中如果只有一条语句，可以不用 {} （大括号）括起来");

        Map<String, String> map03 = new HashMap<>();
        map03.put("A", "变量由字母、下划线、数字、$ 符号随意组成");
        map03.put("B", "变量不能以数字作为开头");
        map03.put("C", "A 和 a 在 java 里面是同一个变量");
        map03.put("D", "不同类型的变量，可以起相同的名字");

        Map<String, String> map04 = new HashMap<>();
        map04.put("A", "STRING");
        map04.put("B", "x3x");
        map04.put("C", "void");
        map04.put("D", "de$f");

        Map<String, String> map05 = new HashMap<>();
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        questionBank.append(new ChoiceQuestion("JAVA 所定义的版本中不包括",
                map01, "D"));
        questionBank.append(new ChoiceQuestion("下列说法正确的是",
                map02, "A"));
        questionBank.append(new ChoiceQuestion("变量命名规范说法正确的是",
                map03, "B"));
        questionBank.append(new ChoiceQuestion("以下（）不是合法的标识符",
                map04, "C"));
        questionBank.append(new ChoiceQuestion("表达式（11+3*8）/4%3 的值是",
                map05, "C"));

        questionBank.append(new AnswerQuestion("小红马和小黑马生的小马有几条腿", "4 条腿"));
        questionBank.append(new AnswerQuestion("铁棒打头疼还是木棒打头疼", "头最疼"));
        questionBank.append(new AnswerQuestion("什么床不能睡觉", "牙床"));
        questionBank.append(new AnswerQuestion("为什么好马不吃回头草", "后面的草没了"));
    }

    /**
     * 使用 prototype 创建试卷
     * @param candidate
     * @param number
     * @return
     * @throws CloneNotSupportedException
     */
    public String createPaper(final String candidate, final String number) throws CloneNotSupportedException {
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);
        return questionBankClone.toString();
    }
}
