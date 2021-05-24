package com.hotstrip.code.design.prototype.bad;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class QuestionPaperServiceTest extends TestCase {

    @Test
    public void testCreatePaper() {
        QuestionPaperService questionPaperService = new QuestionPaperService();

        log.info(questionPaperService.createPaper("花花", "10000001"));
        log.info(questionPaperService.createPaper("豆豆", "10000002"));
        log.info(questionPaperService.createPaper("大宝", "10000003"));
    }
}