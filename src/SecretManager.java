import com.tiemens.secretshare.engine.SecretShare;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.HashMap;
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
    public static SecretData shareSecret(String secret,int requiredKeys, int totalKeys) throws UnsupportedEncodingException {
        Map<Integer,BigInteger>secretPieces= new HashMap<>();
        final BigInteger secretInt= new BigInteger(secret.getBytes("UTF-8"));
        final BigInteger modulus= SecretShare.createAppropriateModulusForSecret(secretInt);
        final SecretShare.PublicInfo publicInfo=new SecretShare.PublicInfo(totalKeys,requiredKeys,modulus,null);
        final SecretShare.SplitSecretOutput splitSecretOutput=new SecretShare(publicInfo).split(secretInt);
        final List<SecretShare.ShareInfo> sharedPieces=splitSecretOutput.getShareInfos();
        sharedPieces.stream().forEach(e->{
                 secretPieces.put(e.getIndex(),e.getShare());
        });
        return new SecretData(secretPieces,String.valueOf(requiredKeys).concat("|").concat(publicInfo.getPrimeModulus().toString()).concat("|").concat(String.valueOf(totalKeys)));
    }

    /**
     *This method is used to recreate the private key from the given shared keys
     * @return
     */
    public static PrivateKey reconstructSecret(SecretData secretData){
        Map<Integer,BigInteger> secretPieces= secretData.getSecretPieces();
        String[] secretInfo= secretData.getSecretData().split("|");
        /*SecretShare.PublicInfo publicInfo=
        final SecretShare secretSolver=
        secretPieces.values().stream().forEach(e->{

        });*/
        return null;
    }


    public static void main(String args[]){
            String secret="93804757803129239708212499432574330689669848156893664777565737768608149751841684756066093626457716247605248942952625125544539388914755594151222864399588116405954760511562499276884468092287290467891088843736954047077843552534240966645976681785199475988638517926495382562483769045698224432712094905362385085473@102541697865722832598153930167174685343667420123402333636804259272117697367712182774144806398297989253570383466620289107347630275904564198186724481913428979465099615449897724536548036032589335453721743573108045493501240345632079674797037688620928393165459602567373510647748803875288878264071913935792304349311";
        try {
            System.out.println(shareSecret(secret,3,5));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



}
