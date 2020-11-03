package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<Content> findContentPageList();
    Content findContentById(Long id);
    List<Content> findContentLikeName(String name);
    int createContent(Content content);
    int updateContent(Content content);
    int deleteContents(Long[] ids);

}
