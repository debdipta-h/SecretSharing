import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @author debdipta.halder
 * <p>
 * This is a key manager which is used to read data from a given private key and public key.
 */
public class KeyManager {
    private PrivateKey privateKey;
    private PublicKey publicKey;
    private KeyFactory keyFactory;
    private RSAPublicKeySpec publicKeySpec;
    private RSAPrivateKeySpec privateKeySpec;

    public KeyManager(PrivateKey privateKey, PublicKey publicKey) throws NoSuchAlgorithmException {
        keyFactory = KeyFactory.getInstance("RSA");
        setPrivateKey(privateKey);
        setPublicKey(publicKey);
    }

    private void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    private void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public BigInteger getPublicKeyExponent() {
        try {
            publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            return publicKeySpec.getPublicExponent();
        } catch (Exception e) {
            System.out.println("Error while extracting the exponent of the public key");

        }
        return null;
    }

    public BigInteger getPublicKeyModulus() {
        try {
            publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            return publicKeySpec.getModulus();
        } catch (Exception e) {
            System.out.println("Error while extracting the exponent of the public key");

        }
        return null;

    }

    public BigInteger getPrivateKeyModulus() {
        try {
            privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
            return privateKeySpec.getModulus();
        } catch (Exception e) {
            System.out.println("Error while extracting the exponent of the public key");

        }
        return null;
    }

    public BigInteger getPrivateKeyExponent() {
        try {
            privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
            return privateKeySpec.getPrivateExponent();
        } catch (Exception e) {
            System.out.println("Error while extracting the exponent of the public key");

        }
        return null;
    }

}
