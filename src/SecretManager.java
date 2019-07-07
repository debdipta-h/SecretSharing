import com.tiemens.secretshare.engine.SecretShare;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

/**
 * @author debdipta.halder
 *
 * This class is a manager class for secret sharing process.
 *
 */

public class SecretManager {

    /**
     *
     * @param requiredKeys
     * @param totalKeys
     * @return
     */
    public static Map<String,String> shareSecret(String secret,int requiredKeys, int totalKeys) throws UnsupportedEncodingException {
        final BigInteger secretInt= new BigInteger(secret.getBytes("UTF-8"));
        final BigInteger modulus= SecretShare.createAppropriateModulusForSecret(secretInt);
        final SecretShare.PublicInfo publicInfo=new SecretShare.PublicInfo(totalKeys,requiredKeys,modulus,null);
        final SecretShare.SplitSecretOutput splitSecretOutput=new SecretShare(publicInfo).split(secretInt);
        final List<SecretShare.ShareInfo> sharedPieces=splitSecretOutput.getShareInfos();
        return null;
    }

    /**
     *This method is used to recreate the private key from the given shared keys
     * @return
     */
    public static PrivateKey reconstructSecret(){
        return null;
    }



}
