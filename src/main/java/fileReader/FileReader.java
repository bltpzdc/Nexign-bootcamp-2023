package fileReader;

import java.io.IOException;

public interface FileReader {
    boolean init();
    String nextLine() throws IOException;
    void close() throws IOException;
}
