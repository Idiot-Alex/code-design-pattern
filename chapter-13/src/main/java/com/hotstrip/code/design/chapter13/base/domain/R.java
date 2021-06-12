package com.hotstrip.code.design.chapter13.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class R {

    /**
     * success result
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static Map ok(int code, String msg, Object data) {
        HashMap res = new HashMap();
        res.put("code", code);
        res.put("msg", msg);
        res.put("data", data);
        return res;
    }

    /**
     * error result
     * @param code
     * @param msg
     * @return
     */
    public static Map error(int code, String msg) {
        HashMap res = new HashMap();
        res.put("code", code);
        res.put("msg", msg);
        return res;
    }
}
