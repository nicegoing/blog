package com.alex.blog.dao.mapper;

import com.alex.blog.dao.pojo.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据文章id查看标签列表
     *
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);
}
