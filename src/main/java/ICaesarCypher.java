import java.io.File;

public interface ICaesarCypher {

    public void encrypt(int key, File decryptedF);

    public void decrypt(int key, File encryptedF);

    public int keyFinder(File encryptedF);

}
