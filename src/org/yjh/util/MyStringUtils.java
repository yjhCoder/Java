package org.yjh.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

public class MyStringUtils {

    /**
     * 获得md5加密后的数据
     * 
     * @param value
     * @return
     */
    public static String getMD5Value(String value) {

	try {
	    // 1. 获得jdk提供消息摘要算法工具类
	    MessageDigest messageDiaDigest = MessageDigest.getInstance("MD5");
	    // 2. 加密的结果是10进制
	    byte[] md5ValueByteArray = messageDiaDigest.digest(value.getBytes());
	    // 3. 转换进制 将10转为16
	    System.out.println(Arrays.toString(md5ValueByteArray));
	    BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
	    return bigInteger.toString(16);

	} catch (Exception e) {
	    new RuntimeException(e);
	    //
	    return value;
	}
    }

    /**
     * 获得一个32长度的UUID值
     * 
     * @return
     */
    public static String getUUID() {
	return UUID.randomUUID().toString().replace("-", "");
    }

}
