package stepic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test_6 {
    public static void main(String[] args) {
        try {
            InputStream stream = getStream( new byte[] { 0x33, 0x45, 0x01});
            int result = checkSumOfStream(stream);
            System.out.print(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int dataByte = 0;
        int Cn = 0;
        while( (dataByte = inputStream.read()) != -1 ){
            Cn = Integer.rotateLeft(Cn, 1) ^ dataByte;
        }
        return Cn;
    }
}
