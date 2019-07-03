public class EncryptionManager {
    public static void main(String args[]){
        GenerateEncryptionKeyPair generator=new GenerateEncryptionKeyPair();
        generator.createKeyPar("RSA",1024);
        System.out.println(generator.getPrivateKey().t);
        System.out.println(generator.getPublicKey());
        Util.writeToFile("/tmp/publicKey",generator.getPublicKey().getEncoded());
        Util.writeToFile("/tmp/privateKey",generator.getPrivateKey().getEncoded());
        System.out.println("Successfully generated");
    }
}
