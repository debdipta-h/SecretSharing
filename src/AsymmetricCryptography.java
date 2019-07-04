import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymmetricCryptography {
    private Cipher cipher;
    public AsymmetricCryptography(String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher=Cipher.getInstance(algorithm);
    }

    public String encryptMessage(String message, PublicKey publicKey) throws InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
    }

    public String decryptMessage(String message,PrivateKey privateKey) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        this.cipher.init(Cipher.DECRYPT_MODE,privateKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(message)),"UTF-8");
    }




}
