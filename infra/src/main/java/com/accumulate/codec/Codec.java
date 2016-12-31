package com.accumulate.codec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author tjwang
 * 编解码器
 */
public class Codec {

	public static String encrptPassword(String password, String salt) {
		// 对密码进行MD5加密
		Md5PasswordEncoder md5PasswordEncoder = buildMd5PasswordEncoder(true);
		String md5Password = md5PasswordEncoder.encodePassword(password, salt);
		return md5Password;
	}

	public static boolean validPassword(String password, String salt, String md5Password) {
		String v = encrptPassword(password, salt);
		return v.equals(md5Password);
	}

	public static String generateApiKey() {
		String uuid = UUID.randomUUID().toString().replace("-","");
		return buildMd5PasswordEncoder(false).encodePassword(uuid, String.valueOf(System.currentTimeMillis()));
	}

	public static String generateToken(String msg) {
		try {

			long current = System.currentTimeMillis();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(msg.getBytes());
			byte now[] = (new Long(current)).toString().getBytes();
			md.update(now);
			return toHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	private static String toHex(byte buffer[]) {
		StringBuffer sb = new StringBuffer(buffer.length * 2);
		for (int i = 0; i < buffer.length; i++) {
			sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));
			sb.append(Character.forDigit(buffer[i] & 15, 16));
		}

		return sb.toString();
	}

	/**
	 * 生成6位动态码
	 * @param key -- 生成因子
	 * @param timeStepInMillis --时间（30 * 1000 -- 100 * 1000）
     * @return
     */
	public static String generateAuthCode(String key, long timeStepInMillis){
		String secret = new String(Hex.encode(new Base32().decode(key)));
		return TOTP.generateTOTP(secret,
				Long.toHexString(System.currentTimeMillis() / timeStepInMillis),
				"6",
				"HmacSHA1");
	}

	/**
	 * 构建一个MD5编码器
	 * @return  Md5PasswordEncoder
	 */
	private static Md5PasswordEncoder buildMd5PasswordEncoder(boolean base64) {
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		md5PasswordEncoder.setEncodeHashAsBase64(base64);
		md5PasswordEncoder.setIterations(1024);
		return md5PasswordEncoder;
	}

	/**
	 * 解码Base64
	 * @param gssTokenStr
	 * @return
	 */
	public static byte[] decodeBase64(String base64) {
		return Base64.decodeBase64(base64);
	}

    public static byte[] encodeBase64(String str){
        return Base64.encodeBase64(str.getBytes());
    }

	public static String md5(byte[] byteArray) {
		return DigestUtils.md5Hex(byteArray);
	}


}
