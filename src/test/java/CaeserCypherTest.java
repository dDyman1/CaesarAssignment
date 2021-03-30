import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CaeserCypherTest {

    CaeserCypher c = new CaeserCypher();
    File tFile;
    void setup(String info, String fileName){
        tFile = new File(fileName + ".txt");
        try(FileOutputStream fos = new FileOutputStream(tFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = info.getBytes();
            bos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void encrypt() throws IOException {
        String val = "This is a test file for MCO364";
        String n = "encrypted";
        setup(val, n);
        c.encrypt(-1, tFile);


        Path path = Paths.get(n+".txt");
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            assertEquals("Sghr hr z sdrs ehkd enq LBN253", line);
        }
        scanner.close();
    }

    @Test
    void decrypt() throws IOException {
        String val = "Sghr hr z sdrs ehkd enq LBN253";
        String n = "decrypted";
        setup(val, n);
        c.decrypt(-1, tFile);


        Path path = Paths.get(n+".txt");
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            assertEquals("This is a test file for MCO364", line);
        }
        scanner.close();

    }

    @Test
    void keyFinder() {
        String val = "Uijt jt b uftu gjmf gps NDP475";
        String n = "keyFind";
        setup(val, n);

        assertEquals(1, c.keyFinder(tFile));
    }
}