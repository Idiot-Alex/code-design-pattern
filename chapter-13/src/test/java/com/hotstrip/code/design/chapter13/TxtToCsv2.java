package com.hotstrip.code.design.chapter13;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TxtToCsv2 {

    /**
     * txt 目录转换成 csv
     */
    @Test
    public void testTxtToCsv3() throws FileNotFoundException {
//        String txtFilePath = "/Users/zhangxin/Documents/大都会/运营活动数据20210601-20210620/农商6月营销活动数据/";
//        String csvFilePath = "/Users/zhangxin/Documents/大都会/运营活动数据20210601-20210620/csv/明细数据表.csv";
//
//        ConcurrentHashMap<String, String> map = initMap();
//
//        File directory = new File(txtFilePath);
//        Arrays.stream(directory.listFiles()).forEach(file -> {
//            try {
//                log.info("current file: {}", file.getName());
//                txtToCsv2(file.getAbsolutePath(), csvFilePath, map);
//            } catch (FileNotFoundException e) {
//                log.error("catch exception, caused: {}...msg: {}", e.getCause(), e.getMessage());
//            }
//        });

    }

    /**
     * 汇总当天交易优惠金额
     */
    @Test
    public void testCsvToCsv() {
//        String csvFilePath1 = "/Users/zhangxin/Documents/大都会/运营活动数据20210601-20210620/csv/明细数据表的副本.csv";
//        String csvFilePath2 = "/Users/zhangxin/Documents/大都会/运营活动数据20210601-20210620/csv/每天交易优惠金额汇总表.csv";
//
//        ConcurrentHashMap<String, BigDecimal> map = new ConcurrentHashMap();
//
//        CsvReader reader = CsvUtil.getReader();
//        //从文件中读取CSV数据
//        CsvData data = reader.read(FileUtil.file(csvFilePath1));
//        List<CsvRow> rows = data.getRows();
//        //遍历行
//        for (CsvRow csvRow : rows) {
//            String date = csvRow.getRawList().get(2);
//            String amt = csvRow.getRawList().get(4);
//
//            log.info("date: {}...amt: {}", date, amt);
//
//            // 判断 map 里有没有 date
//            if (map.containsKey(date)) {
//                BigDecimal new_amt = map.get(date).add(BigDecimal.valueOf(Long.parseLong(amt)));
//                map.put(date, new_amt);
//            } else {
//                map.put(date, BigDecimal.valueOf(Long.parseLong(amt)));
//            }
//
//            log.info("map...date: {}, amt: {}", date, map.get(date));
//        }
//        log.info("map size: {}", map.size());
//
//        // 指定路径和编码
//        CsvWriter writer = CsvUtil.getWriter(csvFilePath2, CharsetUtil.CHARSET_GBK);
//        map.entrySet().stream().forEach(ele -> {
//            writer.write(new String[] {ele.getKey(), String.valueOf(ele.getValue())});
//        });
    }

    @Test
    public void testTokenID() throws FileNotFoundException {
//        ConcurrentHashMap<String, String> map = initMap();
//        log.info(getAccNo(map.get("202008312031509320400000001345")));
        // 6228100252212205
        // 622810******2205
    }

    /**
     * map
     * @return
     * @throws FileNotFoundException
     */
//    private ConcurrentHashMap initMap() throws FileNotFoundException {
//        String filePath = "/Users/zhangxin/Documents/大都会/运营活动数据20210601-20210620/token_inf.txt";
//
//        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        AtomicInteger atomicInteger = new AtomicInteger();
//
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        // 按行写出
//        reader.lines().forEach(line -> {
//            if (atomicInteger.get() > 0) {
//                String[] row = line.split("\\s+");
//                map.put(getData(row[0]), getData(row[1]));
//            }
//            atomicInteger.incrementAndGet();
//        });
//        log.info("map size: {}", map.size());
//        return map;
//    }

    private void txtToCsv2(String txtFilePath, String csvFilePath, ConcurrentHashMap<String, String> map) throws FileNotFoundException {
//        AtomicInteger atomicInteger = new AtomicInteger();
//
//        BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
//        // 指定路径和编码
//        CsvWriter writer = CsvUtil.getWriter(csvFilePath, CharsetUtil.CHARSET_GBK, true);
//        // 按行写出
//        reader.lines().forEach(line -> {
//            if (atomicInteger.get() > 0) {
//                String[] row = line.split("\\s+");
//                row[0] = getData(row[0]);
//                row[1] = getDataToString(row[1]);
//                row[2] = getData(row[2]);
//                row[3] = getData(row[3]);
//                row[4] = getData(row[4]);
//                row[5] = getDataToString(row[5]);
//                row[6] = getPhone(row[6]);
//                row[7] = getData(row[7]);
//                // tokenId 加上 ` 变成字符串
//                row[8] = getAccNo(map.get(getData(row[8])));
//                writer.write(row);
//            }
//            atomicInteger.incrementAndGet();
//        });
    }


    /**
     * AES 解密 脱敏
     * @param s
     * @return
     */
    private String getPhone(String s) {
        final String data = getData(s);
        return phoneDisplay(AESTest.decrypt(data));
    }

    /**
     * remove "
     * @param s
     * @return
     */
    private String getData(String s) {
        return s.substring(1, s.length() - 1);
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
     * remove " and add `
     * @param s
     * @return
     */
    private String getDataToString(String s) {
        return "`" + s.substring(1, s.length() - 1);
    }

    /**
     * 手机号脱敏
     * @param phone
     * @return
     */
    public static String phoneDisplay(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(7);
    }
}
