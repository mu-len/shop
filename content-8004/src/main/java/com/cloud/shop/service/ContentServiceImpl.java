package com.cloud.shop.service;

import com.cloud.shop.dao.ContentMapper;
import com.cloud.shop.entitlse.Content;
import com.cloud.shop.utils.SaveRedis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    @Resource
    private ContentMapper contentMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List<Content> findContentPageList(Integer pageNum, Integer pageSize) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findContentPageList"+pageNum+pageSize;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            PageHelper.startPage(pageNum,pageSize);
            List<Content> contentPageList = contentMapper.findContentPageList();
            PageInfo<Content> pageInfo=new PageInfo<>(contentPageList);
            redisTemplate.boundValueOps(key).set(pageInfo.getList());
            list.add(key);
            return pageInfo.getList();
        }
        return (List<Content>) o;
    }

    @Override
    public Content findContentById(Long id) {
        return contentMapper.findContentById(id);
    }

    @Override
    public List<Content> findContentLikeName(String name) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findContentLikeName"+name;
        Object o = redisTemplate.boundValueOps(key).get();
        if(null==o){
            List<Content> contentLikeName = contentMapper.findContentLikeName(name);
            redisTemplate.boundValueOps(key).set(contentLikeName);
            list.add(key);
        }
        return (List<Content>) o;
    }

    @Override
    public boolean upload(MultipartFile file) {
        try {
            String name = file.getName();
            String s = SaveRedis.byByte(file.getInputStream());
            redisTemplate.boundValueOps(name).set(s);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public byte[] download(String name) {
        String string = (String) redisTemplate.boundValueOps(name).get();
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] bytes=null;
        try {
            bytes = decoder.decodeBuffer(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    @Override
    public int createContent(Content content) {
        int i = contentMapper.createContent(content);
        if(i>0){this.deleteContentRedis();}
        return i;
    }

    @Override
    public int updateContent(Content content) {
        int i = contentMapper.updateContent(content);
        if(i>0){this.deleteContentRedis();}
        return i;
    }

    @Override
    public int deleteContents(Long[] ids) {
        int i = contentMapper.deleteContents(ids);
        if(i>0){this.deleteContentRedis();}
        return i;
    }

    @Override
    public boolean textUpload() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\86176\\Pictures\\Saved Pictures\\bilibili.jpg"));
            String s = SaveRedis.byByte(fileInputStream);
            redisTemplate.boundValueOps("bilibili").set(s);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean textDownload() {
        Object string = redisTemplate.boundValueOps("bilibili").get();
        if(string==null){
            return false;
        }
        String s= (String) string;
        BASE64Decoder decoder=new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(s);
            FileOutputStream outputStream=new FileOutputStream(new File("D:\\bilibili.jpg"));
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public void deleteContentRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
