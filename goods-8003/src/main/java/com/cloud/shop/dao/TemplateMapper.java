package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateMapper {
    List<Template> findTemplatePageList();
    List<Template> findTemplateLikeName(String name);
    Template findTemplateById(Long id);
    int createTemplate(Template template);
    int updateTemplate(Template template);
    int deleteTemplate(Long id);
    int deleteTemplates(Long[] ids);
}
