package com.hotstrip.code.design.chapter13;

import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DoSmt {

    private final String txtFilePath = "/Users/zhangxin/Documents/大都会/运营活动数据2021-08/0823数据提取/smt1.txt";
    private final String excelFilePath = "/Users/zhangxin/Documents/大都会/运营活动数据2021-08/0823数据提取/res.txt";

    @Test
    public void test() throws FileNotFoundException {
//        ConcurrentHashMap<String, String> map = initMap();
//
//        File file = new File(txtFilePath);
//        try {
//            log.info("current file: {}", file.getName());
//            txtToCsv2(file.getAbsolutePath(), excelFilePath, map);
//        } catch (FileNotFoundException e) {
//            log.error("catch exception, caused: {}...msg: {}", e.getCause(), e.getMessage());
//        }
    }

    private void txtToCsv2(String txtFilePath, String csvFilePath, ConcurrentHashMap<String, String> map) throws FileNotFoundException {
        AtomicInteger atomicInteger = new AtomicInteger();

        BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
        // 指定路径和编码
        CsvWriter writer = CsvUtil.getWriter(csvFilePath, CharsetUtil.CHARSET_GBK, true);
        // 按行写出
        reader.lines().forEach(line -> {
            if (atomicInteger.get() > 0) {
                log.info("row: {}", line);
                String[] row = line.split(",");
                // act_id,settle_dt,trans_time,dtb_user_id,orgin_at,discount_at,
                // acp_order_id,phone_no,token_id_seq,acc_no,phone_no_tm,acc_no_tm,mchnt_cd,id
                // act_id,
                row[0] = row[0];
                // settle_dt,
                row[1] = row[1];
                // trans_time,
                row[2] = row[2];
                // dtb_user_id,
                row[3] = row[3];
                // orgin_at,
                row[4] = row[4];
                // discount_at,
                row[5] = row[5];
                // acp_order_id,
                row[6] = row[6];
                // phone_no,
                row[7] = getPhone(row[7]);
                // token_id_seq  => acc_no
                row[8] = getAccNo(map.get(row[8]));
                // acc_no
                log.info("acc_no: {}", row[8]);
                writer.write(row);
            }
            atomicInteger.incrementAndGet();
        });
    }

    /**
     * AES 解密 脱敏
     * @param s
     * @return
     */
    private String getPhone(String s) {
        return phoneDisplay(AESTest.decrypt(s));
    }

    /**
     * 手机号脱敏
     * @param phone
     * @return
     */
    public static String phoneDisplay(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }


    /**
     * 卡号脱敏 前 6 位明文
     * 后四位明文
     * 中间加星号
     * @param s
     * @return
     */
    private String getAccNo(String s) {
        String accNo = AESTest.decrypt(s);
        accNo.substring(0, 6);
        String coma = "";
        for (int i=0; i<accNo.length()-10; i++) {
            coma += "*";
        }
        return accNo.substring(0, 6) + coma + accNo.substring(accNo.length() - 4);
    }

    /**
     * map
     * @return
     * @throws FileNotFoundException
     */
    private ConcurrentHashMap initMap() throws FileNotFoundException {
        String filePath = "/Users/zhangxin/Documents/大都会/运营活动数据2021-08/0823数据提取/tbl_dtbmgm_token_inf.txt";

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        // 按行写出
        reader.lines().forEach(line -> {
            if (atomicInteger.get() > 0) {
                String[] row = line.split(",");
                // token_id_seq  acc_no
                map.put(row[0], row[11]);
            }
            atomicInteger.incrementAndGet();
        });
        log.info("map size: {}", map.size());
        return map;
    }

}
