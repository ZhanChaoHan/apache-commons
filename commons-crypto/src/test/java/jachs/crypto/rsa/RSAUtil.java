package jachs.crypto.rsa;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
 
/***
 * 
 * @author zhanchaohan
 *
 */
public class RSAUtil {
    private static String eKey = "151921844699844218625546358250800749508910705507524843756059881719275328142249347338662967910549681516701135610032563906823087458332856347403497255833803914470548393528857802677073855357424853525446795552666069410782210088655958433239963391921691519753221355294472481388195650287943708467010997083592442224449";
    private static String nKey = "21015778319079801013636644732280407738646686863859704730860530471742034302439446099559856006495968540098067886977283858406700078745076818504809975256316707583191530030035227886481529984617466421103167678081339979192676425588581620789960498175191576143828583493125639533691896963139122435888674976036028946775823973694365899051656973710675213381319048045821668060450202382711854637624354027090185568477316005955341489937442168529277014964465834825480355545096182745587197641696088898670457454648608984815688803047261815100609204284878747225942419781059141586261525054921205854115375653064651993267889252585496250445919";
    private static String dKey = "10825682069936784739614554801476068844406424729722417277170170377196969143469016770323844279277162799169758936390983016072302205270449399290146173168367611517029548075563414814334349295476896934436387838923660943344521768172396152617206174699268012017583344630494305692013998599393555648309926333747504968663526863294217777474421998958681664285295167108822287757075810670966531279262487766256143261595915745344511331349215309682559840573517848106523755624882204802122425621204888576944327022834100544160631205394108537556253887697705813809985242312576395677586346705951829474963156055703287868942128584443320672465193";
 
    static String code = "你好, RSA!";
    
    public static void main(String[] args) {
        //生成公钥对和私钥对
        // getKey();
        System.out.println("原文：" + code);
        String encrypt = encrypt(eKey, nKey, code);
        System.out.println("加密后：" + encrypt);
        String decrypt = decrypt(dKey, nKey, encrypt);
        System.out.println("解密后：" + decrypt);
    }
 
    /**
     * 生成密钥对
     */
    public static void getKey() {
        int keySize = 1024;// 越大越安全，但速度减慢，一般使用1024或2048
        SecureRandom secureRandom = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(keySize, secureRandom);// p
        BigInteger q = BigInteger.probablePrime(keySize, secureRandom);// q
        BigInteger e = BigInteger.probablePrime(keySize, secureRandom);// 1 < e < φ(n)=(p-1)(q-1)
        BigInteger n = p.multiply(q);// n = p * q
        BigInteger $n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));// φ(n) = (p-1) * (q-1)
        // 计算模反元素d
        BigInteger d = e.modInverse($n);// ed % φ(n) = 1
        int bitCount = n.bitCount();
        System.out.println("密钥长度:" + bitCount);
        System.out.println("nKey:" + n);
        System.out.println("eKey:" + e);
        System.out.println("dKey:" + d);
    }
 
    /**
     * 加密
     * @param eKey
     * @param nKey
     * @param v
     * @return
     * @date 2021年2月25日 下午1:08:19
     */
    public static String encrypt(String eKey, String nKey, String v) {
        v = Base64.getEncoder().encodeToString(v.getBytes(StandardCharsets.UTF_8));// 汉字不支持，可以先编码
        BigInteger e = new BigInteger(eKey);
        BigInteger n = new BigInteger(nKey);
        byte[] encode = new BigInteger(v.getBytes(StandardCharsets.UTF_8)).modPow(e, n).toByteArray();
        return Base64.getEncoder().encodeToString(encode);
    }
 
    /**
     * 解密
     * @param dKey
     * @param nKey
     * @param v
     * @return
     * @date 2021年2月25日 下午1:08:19
     */
    public static String decrypt(String dKey, String nKey, String v) {
        BigInteger d = new BigInteger(dKey);
        BigInteger n = new BigInteger(nKey);
        byte[] decode = new BigInteger(Base64.getDecoder().decode(v)).modPow(d, n).toByteArray();
        decode = Base64.getDecoder().decode(decode);
        return new String(decode, StandardCharsets.UTF_8);
 
    }
}