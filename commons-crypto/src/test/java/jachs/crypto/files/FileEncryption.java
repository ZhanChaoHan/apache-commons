package jachs.crypto.files;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;


/***
 * 文件加密解密
 * @author zhanchaohan
 */
public class FileEncryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static void encryptFile(String inputFilePath, String encryptedFilePath, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] inputBytes = Files.readAllBytes(Paths.get(inputFilePath));
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        Files.write(Paths.get(encryptedFilePath), encryptedBytes);
    }

    private static void decryptFile(String encryptedFilePath, String decryptedFilePath, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] encryptedBytes = Files.readAllBytes(Paths.get(encryptedFilePath));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        Files.write(Paths.get(decryptedFilePath), decryptedBytes);
    }
    
    
    
    public static void main(String[] args) {
        String inputFilePath = "D:\\EE\\AA.txt";
        String encryptedFilePath = "D:\\\\EE\\\\BB.txt";
        String decryptedFilePath = "D:\\\\EE\\\\CC.txt";

        try {
            SecretKey secretKey = generateSecretKey();
            encryptFile(inputFilePath, encryptedFilePath, secretKey);
            decryptFile(encryptedFilePath, decryptedFilePath, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
