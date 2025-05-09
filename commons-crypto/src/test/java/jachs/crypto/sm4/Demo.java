package jachs.crypto.sm4;

import org.junit.Test;

import org.junit.Test;

import org.junit.Test;

/***
 * @author zhanchaohan
 */
public class Demo {
    SM4Util su=new SM4Util();
    final String KEY = "1234567890abcdef";
    final String IV = "qwertyuiopas2356";
    
    
    @Test
    public void t1() throws Exception {
        System.out.println("使用配置的密钥和初始化向量");
        String plainText = "1234567";
        String cipherText = su.encryptWithGCM(plainText);
        System.out.println("加密后：" + cipherText);

        String decryptedText = su.decryptWithGCM(cipherText);
        System.out.println("解密后：" + decryptedText);

        System.out.println();
        System.out.println("使用代码随机生成的密钥和初始化向量");
        // 使用随机的
        byte[] key = su.generateKey(16);
        byte[] iv = su.generateIV(16);
        String cipherText1 = su.encryptWithGCM(plainText, key, iv);
        System.out.println("加密后：" + cipherText1);

        String decryptedText1 = su.decryptWithGCM(cipherText1, key, iv);
        System.out.println("解密后：" + decryptedText1);

        System.out.println();
        System.out.println("使用外部传输的密钥和初始化向量");
        String cipherText2 = su.encryptWithGCM(plainText, KEY, IV);
        System.out.println("加密后：" + cipherText2);

        String decryptedText2 = su.decryptWithGCM(cipherText2, KEY, IV);
        System.out.println("解密后：" + decryptedText2);
    }
}
