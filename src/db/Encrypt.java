package db;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Encrypt {
	public static String EncryptMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md5=MessageDigest.getInstance("MD5");//返回实现指定摘要算法的 MessageDigest 对象。
													//MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法
        BASE64Encoder base64en = new BASE64Encoder();
     
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));   //加密后的字符串
        return newstr;

	}

}
//getBytes(String charsetName) 
//使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
//public byte[] digest(byte[] input)使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算。也就是说，此方法首先调用 update(input)
//，向 update 方法传递 input 数组，然后调用 digest()。 