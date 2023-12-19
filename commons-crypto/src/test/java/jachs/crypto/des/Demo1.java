package jachs.crypto.des;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Demo1 {
    //加密算是是des
    private static final String ALGORITHM = "DES";
    //转换格式,DES在实际应用中有多种模式（ECB、CBC、CBR等）和填充方式（PKCS5Padding、NoPadding、ZeroPadding）
    //此处以最为广泛使用的ECB模式、PKCS5填充举例
    private static final String TRANSFORMATION = "DES/ECB/PKCS5Padding";
    
    public static byte[] encrypt(String plainText, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
 
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 
        return cipher.doFinal(plainText.getBytes());
    }
    
   
    public static String decrypt(byte[] encryptedBytes, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
 
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
 
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
    
    String key = "ABCD1234";//密钥长度必须是8个字符
    String plainText="你好";
    
    @Test
    public void t1() throws Exception {
        byte[] encryptedBytes = encrypt(plainText, key);
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("加密: " + encryptedText);
 
        String decryptedText = decrypt(encryptedBytes, key);
        System.out.println("解密: " + decryptedText);
    }
}
