package jachs.crypto.aes;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Demo1 {
    public static String encrypt(String key, String value) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedValue = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue);
    }
    
    public static String decrypt(String key, String encryptedValue) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(decryptedValue);
    }
    
    public static void main ( String[] args ) throws Exception {
        String key = "1234567890123456";
        String value = "Hello World";
        String encryptedValue = encrypt(key, value);
        System.out.println("Encrypted Value: " + encryptedValue);
        String decryptedValue = decrypt(key, encryptedValue);
        System.out.println("Decrypted Value: " + decryptedValue);
    }
}
