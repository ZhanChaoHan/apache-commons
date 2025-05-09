package jachs.crypto.sm4;

import org.junit.Test;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
/***
 * @author zhanchaohan
 */
public class HutoolDemo {
    
    @Test
    public void t1() {
        String content = "fisco bcos";
        SymmetricCrypto sm4 = SmUtil.sm4();

        String encryptHex = sm4.encryptHex(content);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encryptHex+"\r\n"+decryptStr);
    }
    
    //定制自己的密钥,128 bit = 128 / 8 = 16 byte,key最少16个字符
    @Test
    public void t2() {
        String content = "fisco bcos";
        // key必须是16位
        String key="1234567890123456";
        SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes());
        String encryptHex = sm4.encryptHex(content);
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(encryptHex+"\r\n"+decryptStr);
    }
}
