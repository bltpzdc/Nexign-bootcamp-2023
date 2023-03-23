package fileReader;

import java.io.IOException;

public interface FileReader {
    String nextLine() throws IOException;
    void close() throws IOException;
}
