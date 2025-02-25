import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String ALGORITHM = "AES";

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static String encrypt(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String outputFile = "encrypted_employees.csv";
        SecretKey key;
        try {
            key = generateKey();
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
                 FileWriter writer = new FileWriter(outputFile)) {
                writer.append("ID,Name,Department,Salary\n");
                String line;
                while ((line = br.readLine()) != null) {
                    String encryptedLine = encrypt(line, key);
                    writer.append(encryptedLine + "\n");
                }
            }
            try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
                while ((line = br.readLine()) != null) {
                    String decryptedLine = decrypt(line, key);
                    System.out.println(decryptedLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}