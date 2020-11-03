package com;

import com.cloud.shop.ContentAppStart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class Text {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public InputStream getInputStream() throws FileNotFoundException {
        File file=new File("C:\\Users\\86176\\Pictures\\Saved Pictures\\bilibili.jpg");
        FileInputStream fileInputStream=new FileInputStream(file);
        return fileInputStream;
    }

    public String getString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes=new byte[1024];
        int ch;
        while ((ch=inputStream.read(bytes))>-1){
            byteArrayOutputStream.write(bytes,0,ch);
        }
        inputStream.close();
        BASE64Encoder encoder=new BASE64Encoder();
        return encoder.encode(byteArrayOutputStream.toByteArray());
    }

    public void save(String encode){
        stringRedisTemplate.boundValueOps("bilibili.jpg").set(encode);
        System.out.println("=======================================================================================");
    }

    public void decode() throws IOException {
        String string = (String) stringRedisTemplate.boundValueOps("bilibili.jpg").get();
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(string);
        FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\bilibili.jpg"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    @Test
    public void fun(){
        Text text = new Text();
        try {
            text.save(text.getString(text.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
