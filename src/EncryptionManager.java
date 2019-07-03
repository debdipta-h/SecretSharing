import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptionManager {
    public static void main(String args[]){
        GenerateEncryptionKeyPair generator=new GenerateEncryptionKeyPair();
        generator.createKeyPar("RSA",1024);
        System.out.println("This is the private key: "+generator.getPrivateKey().toString());
        System.out.println("This is the public key: "+new String(generator.getPublicKey().getEncoded()));
        try {
            KeyFactory keyFactory =KeyFactory.getInstance("RSA");
            PrivateKey prv_recovered = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(generator.getPrivateKey().getEncoded()));
            PublicKey pub_recovered = keyFactory.generatePublic(new X509EncodedKeySpec(generator.getPublicKey().getEncoded()));
            System.out.println("lulu"+prv_recovered.toString());
            System.out.println("pupu"+pub_recovered.toString());
        } catch (NoSuchAlgorithmException|InvalidKeySpecException e) {
            e.printStackTrace();
        }
        //Util.writeToFile("/tmp/publicKey",generator.getPublicKey().getEncoded());
        //Util.writeToFile("/tmp/privateKey",generator.getPrivateKey().getEncoded());
        System.out.println("Successfully generated");
    }
}
