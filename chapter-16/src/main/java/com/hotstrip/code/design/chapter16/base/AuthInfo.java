package com.hotstrip.code.design.chapter16.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 授权信息实体类
 * @author Hotstrip
 * @date 2021-07-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {
    private String code;
    private String info;

    public AuthInfo(String code, String ...infos) {
        if (null == this.info) {
            this.info = "";
        }
        this.code = code;
        for (String str : infos){
            this.info = this.info.concat(str);
        }
    }
}
