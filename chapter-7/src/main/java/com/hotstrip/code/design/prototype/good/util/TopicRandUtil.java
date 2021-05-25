package com.hotstrip.code.design.prototype.good.util;

import java.util.*;

/**
 * @author hotstrip
 * 题目混排工具包
 */
public class TopicRandUtil {

    /**
     * 混排题目选项和答案
     * @param option
     * @param key
     * @return
     */
    public static Topic random(final Map<String, String> option, final String key) {
        Set<String> ketSet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(ketSet);
        Collections.shuffle(keyList);

        HashMap<String, String> optionNew = new HashMap<>();
        int index = 0;
        String keyNew = " ";

        for (String next : ketSet) {
            String randomKey = keyList.get(index++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }
}
