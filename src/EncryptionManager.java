import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptionManager {
    public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        GenerateEncryptionKeyPair generator = new GenerateEncryptionKeyPair();
        generator.createKeyPair("RSA", 1024);
        // System.out.println(generator.getPrivateKey());
        //System.out.println(generator.getPublicKey());
        //Util.writeToFile("/tmp/publicKey",generator.getPublicKey().getEncoded());
        //Util.writeToFile("/tmp/privateKey",generator.getPrivateKey().getEncoded());
        System.out.println("Successfully generated");
//        BigInteger modulus= generato
        String msg = "PlatformTest@2018";
        AsymmetricCryptography cryptography = new AsymmetricCryptography("RSA");
        System.out.println("Encrypting the message");
        String encrypted_msg = cryptography.encryptMessage(msg, generator.getPublicKey());
        System.out.println(encrypted_msg);
        System.out.println("decrypting the encrypted message");
        String decryptedP_msg = cryptography.decryptMessage(encrypted_msg, generator.getPrivateKey());
        System.out.println(decryptedP_msg);
    }
}
