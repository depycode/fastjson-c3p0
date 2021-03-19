package com.fastjson.vul;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static byte[] toByteArray(InputStream in) throws IOException {
        byte[] classBytes;
        classBytes = new byte[in.available()];
        in.read(classBytes);
        in.close();
        return classBytes;
    }

    public static String bytesToHexString(byte[] bArray, int length) {
        StringBuffer sb = new StringBuffer(length);

        for(int i = 0; i < length; ++i) {
            String sTemp = Integer.toHexString(255 & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }

            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        InputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\fastjson\\vul\\"+"cc8.dat");
        byte[] data = toByteArray(in);
        in.close();
        String HexString = bytesToHexString(data, data.length);
        System.out.println(HexString);
    }
}
