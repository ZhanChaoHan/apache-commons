package org.apache.commons.crypto.examples.jdk;


 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
 
import org.apache.commons.codec.binary.Hex;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DesTest {
    private static String src = "hello DES";
 
    public static void main(String[] args) {
        jdkDES();
    }
 
    public static void jdkDES() {
        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);// 指定key长度,同是也是密钥长度(56位)
            SecretKey secretKey = keyGenerator.generateKey();// 生成key的材料
            byte[] key = secretKey.getEncoded();// 生成key
            // key转换成密钥
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);// 转换后的密钥
 
            // 加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");// 算法类型/工作方式/填充方式
            cipher.init(Cipher.ENCRYPT_MODE, key2);// 指定为加密模式
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdkDES加密: " + Hex.encodeHexString(result));// 转换为16进制
 
            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key2);// 相同密钥，指定为解密模式
            result = cipher.doFinal(result);// 根据加密内容解密
            System.out.println("jdkDES解密： " + new String(result));// 转换字符串
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}
