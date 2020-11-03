package com.cloud.shop.service;

import com.cloud.shop.entitlse.Content;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@Service
public interface ContentService {

    List<Content> findContentPageList(Integer pageNum, Integer pageSize);
    Content findContentById(Long id);
    List<Content> findContentLikeName(String name);

    boolean upload(MultipartFile file);
    byte[] download(String name);

    int createContent(Content content);
    int updateContent(Content content);
    int deleteContents(Long[] ids);

    boolean textUpload();
    boolean textDownload();
}
