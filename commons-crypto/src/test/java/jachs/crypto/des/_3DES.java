package jachs.crypto.des;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/***
 * 
 * @author zhanchaohan
 *
 */
public class _3DES {
    private static final String KEY_ALGORITHM = "DESede";
    private static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 生成 3DES 密钥
     */
    public static byte[] generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 使用 3DES 加密数据
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * 使用 3DES 解密数据
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    
    public static void main(String[] args) throws Exception {
        // 生成 3DES 密钥
        byte[] key = generateKey();
        // 明文
        byte[] plainText = "Hello, world!".getBytes();
        // 使用 3DES 加密数据
        byte[] cipherText = encrypt(plainText, key);
        // 使用 3DES 解密数据
        byte[] decryptedText = decrypt(cipherText, key);

        // 输出结果
        System.out.println("明文：" + new String(plainText));
        System.out.println("密文：" + new String(cipherText));
        System.out.println("解密后的明文：" + new String(decryptedText));
    }
}
