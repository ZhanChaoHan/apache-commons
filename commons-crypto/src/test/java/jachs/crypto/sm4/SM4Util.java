package jachs.crypto.sm4;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

public class SM4Util {
    /**
     * 加密秘钥，长度必须为16位
     */
    private static final String KEY = "1234567890abcdef";
    /**
     * 初始化向量
     */
    private static final String IV = "qwertyuiopas2356";
    /**
     * 加密算法
     */
    public static final String ALGORITHM = "SM4";
    /**
     * 加密工作模式：GCM
     * 数据填充模式：PKCS5Padding
     */
    public static final String ALGORITHM_MODEL_GCM_PADDING = "SM4/GCM/NoPadding";
    /**
     * 随机数的长度
     */
    public static final int NONCE_LENGTH = 128;

    static {
        // 添加Bouncy Castle provider
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * 使用传输的密钥和初始化向量进行加密
     *
     * @param plainText 需要加密的内容
     * @return 加密之后的内容
     * @throws Exception 加密过程中可能发生的异常
     */
    public static String encryptWithGCM(String plainText, String key, String iv) throws Exception {
        return encryptWithGCM(plainText, key.getBytes(), iv.getBytes());
    }

    /**
     * 使用传输的密钥和初始化向量进行加密
     *
     * @param plainText 需要加密的内容
     * @param key       密钥
     * @param iv        初始化向量
     * @return 加密之后的内容
     * @throws Exception 加密过程中可能发生的异常
     */
    public static String decryptWithGCM(String plainText, String key, String iv) throws Exception {
        return decryptWithGCM(plainText, key.getBytes(), iv.getBytes());
    }

    /**
     * 使用配置的密钥和初始化向量进行加密
     *
     * @param plainText 需要加密的内容
     * @return 加密之后的内容
     * @throws Exception 加密过程中可能发生的异常
     */
    public static String encryptWithGCM(String plainText) throws Exception {
        return encryptWithGCM(plainText, KEY.getBytes(), IV.getBytes());
    }

    /**
     * 使用配置的密钥和初始化向量进行解密
     *
     * @param cipherText 需要解密的内容
     * @return 解密之后的内容
     * @throws Exception 解密过程中可能发生的异常
     */
    public static String decryptWithGCM(String cipherText) throws Exception {
        return decryptWithGCM(cipherText, KEY.getBytes(), IV.getBytes());
    }

    /**
     * 使用SM4-GCM模式加密
     *
     * @param plainText 需要加密的内容
     * @param keyBytes  密钥字节数组
     * @param ivBytes   初始化向量字节数组
     * @return 加密之后的内容
     * @throws Exception 加密过程中可能发生的异常
     */
    public static String encryptWithGCM(String plainText, byte[] keyBytes, byte[] ivBytes) throws Exception {
        SecretKeySpec sm4Key = new SecretKeySpec(keyBytes, ALGORITHM);
        GCMParameterSpec ivSpec = new GCMParameterSpec(NONCE_LENGTH, ivBytes);

        Cipher cipher = Cipher.getInstance(ALGORITHM_MODEL_GCM_PADDING, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, sm4Key, ivSpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 使用SM4-GCM模式解密
     *
     * @param cipherText 需要解密的内容
     * @param keyBytes   密钥字节数组
     * @param ivBytes    初始化向量字节数据
     * @return 解密之后内容
     * @throws Exception 解密过程中可能发生的异常
     */
    public static String decryptWithGCM(String cipherText, byte[] keyBytes, byte[] ivBytes) throws Exception {
        SecretKeySpec sm4Key = new SecretKeySpec(keyBytes, ALGORITHM);
        GCMParameterSpec ivSpec = new GCMParameterSpec(NONCE_LENGTH, ivBytes);

        Cipher cipher = Cipher.getInstance(ALGORITHM_MODEL_GCM_PADDING, "BC");
        cipher.init(Cipher.DECRYPT_MODE, sm4Key, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    /**
     * 使用SecureRandom生成指定长度的密钥或IV
     *
     * @param length 密钥或IV的长度（字节数）
     * @return 生成的随机字节数组
     */
    public static byte[] generateKey(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        return bytes;
    }

    /**
     * 生成指定长度的初始化向量（IV）
     *
     * @param length IV的长度（字节数）
     * @return 生成的随机字节数组
     */
    public static byte[] generateIV(int length) {
        // IV的生成方式与密钥相同，使用SecureRandom
        return generateKey(length);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("使用配置的密钥和初始化向量");
        String plainText = "1234567";
        String cipherText = encryptWithGCM(plainText);
        System.out.println("加密后：" + cipherText);

        String decryptedText = decryptWithGCM(cipherText);
        System.out.println("解密后：" + decryptedText);

        System.out.println();
        System.out.println("使用代码随机生成的密钥和初始化向量");
        // 使用随机的
        byte[] key = generateKey(16);
        byte[] iv = generateIV(16);
        String cipherText1 = encryptWithGCM(plainText, key, iv);
        System.out.println("加密后：" + cipherText1);

        String decryptedText1 = decryptWithGCM(cipherText1, key, iv);
        System.out.println("解密后：" + decryptedText1);

        System.out.println();
        System.out.println("使用外部传输的密钥和初始化向量");
        String cipherText2 = encryptWithGCM(plainText, KEY, IV);
        System.out.println("加密后：" + cipherText2);

        String decryptedText2 = decryptWithGCM(cipherText2, KEY, IV);
        System.out.println("解密后：" + decryptedText2);
    }
}

