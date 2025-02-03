package stepic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class test_8 {
    public static void main(String[] args) {
        InputStream stream = getStream( new byte[] { 48, 49, 50, 51, 10, 13, 48, 49, 50, 51});
        try{
            System.out.println( readAsString_other(stream, StandardCharsets.US_ASCII) );
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    //Выводит строку с ошибкой - При чтении BufferedReader'ом теряются символы перевода строки
    public static String readAsString_1(InputStream inputStream, Charset charset) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public static String readAsString_my(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();
        int dataByte;
        while ((dataByte = reader.read()) != -1) {
            stringBuilder.append((char) dataByte);
        }
        return stringBuilder.toString();
    }

    public static String readAsString_other(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int block;
        while ((block = inputStream.read()) != -1) {
            outputStream.write(block);
        }
        return new String(outputStream.toByteArray(), charset);
    }
}
