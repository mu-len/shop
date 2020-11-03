package com.cloud.shop.utils;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SaveRedis {

    public static String byByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes=new byte[1024];
        int ch;
        while ((ch=inputStream.read(bytes))>-1){
            byteArrayOutputStream.write(bytes,0,ch);
        }
        BASE64Encoder encoder=new BASE64Encoder();
        String encode = encoder.encode(byteArrayOutputStream.toByteArray());
        return encode;
    }

}
