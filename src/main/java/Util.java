import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Util {
    public static boolean writeToFile(String filePath, byte[] key) {
        File f = new File(filePath);
        f.getParentFile().mkdirs();
        boolean fileWritingStatus = false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f);
            fos.write(key);
            fos.flush();
            fos.close();
            fileWritingStatus = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWritingStatus;
    }
}
