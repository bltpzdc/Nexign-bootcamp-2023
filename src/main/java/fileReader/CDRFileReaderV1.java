package fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CDRFileReaderV1 implements FileReader{
    private InputStream inputStream;
    private BufferedReader reader;
    private final String fileName;

    public CDRFileReaderV1(String fileName){
        this.fileName = fileName;
    }
    @Override
    public boolean init(){
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (NullPointerException e){
            System.err.println("Can't find \"cdr.txt\" in resources.");
            return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        reader.close();
        inputStream.close();
    }

    @Override
    public String nextLine() throws IOException {
        return reader.readLine();
    }
}

