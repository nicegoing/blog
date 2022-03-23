package com.alex.blog.service.impl;

import com.alex.blog.dao.mapper.TagMapper;
import com.alex.blog.dao.pojo.Tag;
import com.alex.blog.service.TagService;
import com.alex.blog.vo.Result;
import com.alex.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    /**
     * 标签所拥有的文章数量最多，就是最热标签
     * 查询时根据tagId进行分组计数，取前limit
     *
     * @param limit
     * @return
     */
    @Override
    public Result hots(int limit) {
        List<Long> tagIdList=tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIdList)){
            return Result.success(Collections.emptyList());
        }
        List<Tag> tags=tagMapper.findTagByTagIds(tagIdList);
        return Result.success(tags);
    }

    public TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

}
