package com.hotstrip.code.design.chapter13;

import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TxtTest {

    @Test
    public void testRead() throws FileNotFoundException {
//        String txtFilePath = "/Users/zhangxin/Documents/大都会/互联互通用户重复记录/互联互通重复用户记录.txt";
//        String csvFilePath = "/Users/zhangxin/Documents/大都会/互联互通用户重复记录/互联互通重复用户记录.csv";
//
//        BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
//        // 指定路径和编码
//        CsvWriter writer = CsvUtil.getWriter(csvFilePath, CharsetUtil.CHARSET_UTF_8);
//        // 按行写出
//        AtomicInteger index = new AtomicInteger();
//        reader.lines().forEach(line -> {
//            String[] row = line.split("\\s+");
//            if (index.get() > 0) {
//                row[0] = "`" + row[0];
//                row[1] = "`" + row[1];
//                row[2] = "`" + row[2];
//                row[5] = "`" + row[5];
//                row[6] = "`" + row[6];
//                row[7] = "`" + row[7];
//                if (row.length > 9) {
//                    row[9] = row[9] + row[10];
//                }
//            }
//            writer.write(row);
//            index.getAndIncrement();
//        });
    }

    @Test
    public void test1() {
        SecureRandom random = new SecureRandom();
        for (int i=0; i<100; i++) {
            int machineId = (Math.abs(random.nextInt()) % 8) + 3;
            log.info("machineId: {}", machineId);
        }
    }

}
