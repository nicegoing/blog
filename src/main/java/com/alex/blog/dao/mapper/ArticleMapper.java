package com.alex.blog.dao.mapper;

import com.alex.blog.dao.dos.Archive;
import com.alex.blog.dao.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Archive> listArchives();
}
