package cn.xdlr.tl.utils;

import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA256Utils {
    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    /**
     * sha256_HMAC加密
     *
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String sha256(String message, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hash;
    }

    @Test
    public void test() {
        String sha256StrJava = sha256("123456", "377lBDFQmLSdoF3asqH6Qy9NAUMFRJYcNJUD9yfJZkQy0VfKm65Q6Sr9uWCDZXqR6FEHzNmC7bHx7cKhKu9YegDoLXPMnPWiVYKQ8iZgnNFyTrgtTLmRpbjB403sESrE");
        System.out.println(sha256StrJava);
        String sha256StrJava2 = sha256("hehe", "377lBDFQmLSdoF3asqH6Qy9NAUMFRJYcNJUD9yfJZkQy0VfKm65Q6Sr9uWCDZXqR6FEHzNmC7bHx7cKhKu9YegDoLXPMnPWiVYKQ8iZgnNFyTrgtTLmRpbjB403sESrE");
        System.out.println(sha256StrJava2);
    }
}