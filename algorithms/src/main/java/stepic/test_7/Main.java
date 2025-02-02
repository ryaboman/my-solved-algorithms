package stepic.test_7;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }
    public static void main(String[] args) {
        try {
            //InputStream inputStream = System.in;
            InputStream inputStream = getStream( new byte[] { 65, 13, 10, 10, 13});


            OutputStream ouputStream = System.out;
            int dataByte;
            int symbol_r = -1;
            while ( (dataByte = inputStream.read()) != -1 ){
                if(dataByte == '\r'){
                    if(symbol_r != -1){
                        System.out.print(symbol_r);
                        //ouputStream.write(symbol_r);
                    }
                    symbol_r = dataByte;
                    continue;
                }
                else if(dataByte == '\n' && symbol_r == '\r'){
                    System.out.print(dataByte);
                    //ouputStream.write(dataByte);
                }
                else{
                    if(symbol_r != -1){
                        System.out.print(symbol_r);
                        //ouputStream.write(symbol_r);
                    }
                    System.out.print(dataByte);
                    //ouputStream.write(dataByte);
                }
                symbol_r = -1;
            }
            if(symbol_r != -1){
                System.out.println(symbol_r);
            }
            System.out.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
