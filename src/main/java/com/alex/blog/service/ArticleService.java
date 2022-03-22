package com.alex.blog.service;

import com.alex.blog.vo.ArticleVo;
import com.alex.blog.vo.param.PageParams;

import java.util.List;

public interface ArticleService {
    /**
     * 分页查询文章列表
     *
     * @param pageParams
     * @return
     */
    List<ArticleVo> listArticle(PageParams pageParams);
}
