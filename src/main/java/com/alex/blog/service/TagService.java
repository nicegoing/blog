package com.alex.blog.service;

import com.alex.blog.vo.Result;
import com.alex.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}
