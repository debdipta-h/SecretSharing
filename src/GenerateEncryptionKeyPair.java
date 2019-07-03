import java.security.*;

/**
 * @author debdipta.halder
 * <p>
 * This class generatesa key pair as and when required for any service who requires it.
 */

public class GenerateEncryptionKeyPair {

    private KeyPairGenerator keyPairGenerator;
    private KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;


    private void getKeyPairGeneratorInstance(String algorithm, int keyLength) throws NoSuchAlgorithmException {
        this.keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        this.keyPairGenerator.initialize(keyLength);
    }


    public void createKeyPar(String algorithm, int keyLength) {
        try {
            getKeyPairGeneratorInstance(algorithm, keyLength);
            this.keyPair = this.keyPairGenerator.generateKeyPair();
            setPrivateKey(keyPair.getPrivate());
            setPublicKey(keyPair.getPublic());


        } catch (NoSuchAlgorithmException e) {
            System.out.println("Unable to create keypair");
            e.printStackTrace();
        }

    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    private void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    private void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }
}