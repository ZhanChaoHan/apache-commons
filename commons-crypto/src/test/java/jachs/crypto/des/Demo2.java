package jachs.crypto.des;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.net.util.Base64;
import org.junit.Test;
 
public class Demo2 {
    /** 用于加密解密的同一把密钥 */
    public static final String ORIGNKEY = "key";
    Base64 base64=new Base64 ();
    /**
     * 加密算法
     */
    public  String desEncript(String clearText, String originKey) throws Exception
    {
        Cipher cipher= Cipher.getInstance("DES"); /*提供加密的方式：DES*/
        SecretKeySpec key=getKey(originKey);  /*对密钥进行操作，产生16个48位长的子密钥*/
        cipher.init(Cipher.ENCRYPT_MODE,key); /*初始化cipher，选定模式，这里为加密模式，并同时传入密钥*/
        byte[] doFinal=cipher.doFinal(clearText.getBytes());   /*开始加密操作*/
        byte[] encodeByte= base64.encode(doFinal);    /*对加密后的数据按照Base64进行编码*/
        return new String(encodeByte);
    }
 
    /**
     * 解密算法
     */
    public  String desDecript(String cipherText, String originKey) throws Exception
    {
        Cipher cipher=Cipher.getInstance("DES");   /*初始化加密方式*/
        Key key=getKey(originKey);  /*获取密钥*/
        cipher.init(Cipher.DECRYPT_MODE,key);  /*初始化操作方式*/
        byte[] decode=base64.decode(cipherText);  /*按照Base64解码*/
        byte[] doFinal=cipher.doFinal(decode);   /*执行解码操作*/
        return new String(doFinal);   /*转换成相应字符串并返回*/
    }
 
    /**
     * 获取密钥算法
     */
    public static SecretKeySpec getKey(String originKey)
    {
        byte[] buffer=new byte[8];
        byte[] originBytes=originKey.getBytes();
        /**
         * 防止输入的密钥长度超过64位
         */
        for(int i=0;i<8&&i<originBytes.length;i++)
        {
            buffer[i]=originBytes[i];  /*如果originBytes不足8,buffer剩余的补零*/
        }
        SecretKeySpec key=new SecretKeySpec(buffer,"DES"); /*第一个参数是密钥字节数组，第二个参数是加密方式*/
        return key;  /*返回操作之后得到的密钥*/
    }
    
    
    @Test
    public void t1() throws Exception {
        String message="你好";
        String enStr=desEncript(message,ORIGNKEY);
        String deStr=desDecript(enStr,ORIGNKEY);
        
        System.out.println(enStr);
        System.out.println(deStr);
    }
}
