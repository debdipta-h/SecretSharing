import java.math.BigInteger;
import java.util.Map;

public class SecretData {
    private Map<Integer, BigInteger> secretPieces;
    private String secretData;

    public SecretData(Map<Integer, BigInteger> secretPieces, String secretData) {
        this.secretPieces = secretPieces;
        this.secretData = secretData;
    }

    public Map<Integer, BigInteger> getSecretPieces() {
        return secretPieces;
    }

    public String getSecretData() {
        return secretData;
    }


}
