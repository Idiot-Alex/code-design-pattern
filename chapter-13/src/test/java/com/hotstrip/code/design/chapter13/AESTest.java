package com.hotstrip.code.design.chapter13;
import java.security.Key;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/**
 * Created by 2heguangyao on 2021/5/7.
 */
public class AESTest {
    public static final String KEY_ALGORITHM = "AES";
    /**
     * 加密、解密/ 工作模式/ 填充方式
     */
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    //key放入配置文件
//	private static byte[] key = Base64.decodeBase64("yuQTWwuPRlJLB5DOO1grWw==");

    /**
     * 转换秘钥
     * @param key 二进制秘钥
     * @return Key 秘钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        //实例化AES秘钥材料
        SecretKey  secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    /**
     * 生成秘密秘钥
     * java7 仅仅支持56位密钥
     * Bouncy Castle 支持64位秘密
     * @return  二进制秘钥
     * @throws Exception
     */
    public static byte[] initKey() throws Exception {
        /**
         * 实例化秘钥生成器
         *如要使用64位秘钥须要替换为 KeyGenerator.getInstance(CIPHER__ALGORITHM, "BC")。
         *"BC"是Bouncy Castle安全提供者的缩写。
         */
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化秘钥生成器
        kg.init(128);
        //生成秘密秘钥
        SecretKey secretKey = kg.generateKey();
        //获得秘钥的二进制编码形式
        return secretKey.getEncoded();
    }

    /**
     * 加密
     * @param data  待加密数据
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static String encrypt(String data) {
		/*if(!AcpUtil.isOpenAESSwitch()){//加密开关
			return data;
		}*/
        if(!checkData(data) && !isNumeric(data) && !isCardId(data)){
            return data;
        }
        //原数据
        byte[] dataBase64 = data.getBytes();
        //还原秘钥
        Key k;
        try {
            byte[] key = Base64.decodeBase64("yuQTWwuPRlJLB5DOO1grWw==");
            k = toKey(key);
            //实例化
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化，设置加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);
            //运行操作
            return Base64.encodeBase64String(cipher.doFinal(dataBase64));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[msg=AES加密异常]");
        }
        return data;
    }

    /**
     * @param data 待解密数据
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static String decrypt(String data) {
		/*if(!AcpUtil.isOpenAESSwitch()){//解密密开关
			return data;
		}*/
        if(checkData(data) || isNumeric(data) || isCardId(data)){
            return data;
        }
        //原数据
        byte[] dataBase64 = Base64.decodeBase64(data);
        //还原秘钥
        Key k;
        try {
            byte[] key = Base64.decodeBase64("yuQTWwuPRlJLB5DOO1grWw==");
            k = toKey(key);
            //实例化
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //初始化，设置解密模式
            cipher.init(Cipher.DECRYPT_MODE, k);
            //运行操作
            return  new String(cipher.doFinal(dataBase64));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[msg=AES解密异常]");
        }
        return data;
    }
    //是否为中文
    public static boolean checkData(String countname) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(countname);
        if (m.find()) {
            return true;
        }
        return false;
    }
    //是否为数字
    public static boolean isNumeric(String str) {
        // Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");// 这个也行
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        }
        return false;
    }
    //是否为身份证号
    public static boolean isCardId(String data) {
        String regex = "\\d{15}|\\d{17}[\\dxX]";
        if(data.matches(regex)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        String inputStr = "aj4uy/LuBXpVvKQSVMrNtURjbL/p3qYe6PcZ04U3ImQ=";
        System.out.println("加密卡号：\t"+ inputStr);

        //String keys = "yuQTWwuPRlJLB5DOO1grWw==";
        //byte[] keyBase64 = Base64.decodeBase64(keys);
        try {
            //System.out.println("秘钥：\t" + keys);
            long timeStart = System.currentTimeMillis();
            //加密
            //String inputDataStr = encrypt(inputStr);
            //System.out.println("加密后：\t" + inputDataStr);

            String outputStr = decrypt(inputStr);

            long timeEnd = System.currentTimeMillis();

            Boolean bool = inputStr.equals(outputStr);
            System.out.println(bool);
            System.out.println("加密用时：" + (timeEnd - timeStart));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
