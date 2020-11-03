package com.cloud.shop.service;

import com.cloud.shop.entitlse.Template;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TemplateService {
    List<Template> findTemplatePageList();
    List<Template> findTemplateLikeName(String name);
    Template findTemplateById(Long id);
    int createTemplate(Template template);
    int updateTemplate(Template template);
    int deleteTemplate(Long id);
    int deleteTemplates(Long[] ids);
}
