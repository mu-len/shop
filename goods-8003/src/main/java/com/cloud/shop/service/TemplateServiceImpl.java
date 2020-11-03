package com.cloud.shop.service;

import com.cloud.shop.dao.TemplateMapper;
import com.cloud.shop.entitlse.Template;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService{

    @Resource
    private TemplateMapper templateMapper;

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List<Template> findTemplatePageList() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findTemplatePageList";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<Template> templatePageList = templateMapper.findTemplatePageList();
            redisTemplate.boundValueOps(key).set(templatePageList);
            list.add(key);
        }
        return (List<Template>) o;
    }

    @Override
    public List<Template> findTemplateLikeName(String name) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findTemplateLikeName"+name.trim();
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<Template> templateLikeName = templateMapper.findTemplateLikeName(name);
            redisTemplate.boundValueOps(key).set(templateLikeName);
            list.add(key);
        }
        return (List<Template>) o;
    }

    @Override
    public Template findTemplateById(Long id) {
        return templateMapper.findTemplateById(id);
    }

    @Override
    public int createTemplate(Template template) {
        int i = templateMapper.createTemplate(template);
        if(i>0){this.deleteTemplateRedis();}
        return i;
    }

    @Override
    public int updateTemplate(Template template) {
        int i = templateMapper.updateTemplate(template);
        if(i>0){this.deleteTemplateRedis();}
        return i;
    }

    @Override
    public int deleteTemplate(Long id) {
        int i = templateMapper.deleteTemplate(id);
        if(i>0){this.deleteTemplateRedis();}
        return i;
    }

    @Override
    public int deleteTemplates(Long[] ids) {
        int i = templateMapper.deleteTemplates(ids);
        if(i>0){this.deleteTemplateRedis();}
        return i;
    }

    public void deleteTemplateRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
