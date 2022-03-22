package com.alex.blog.service.impl;

import com.alex.blog.dao.mapper.TagMapper;
import com.alex.blog.dao.pojo.Tag;
import com.alex.blog.service.TagService;
import com.alex.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags=tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    public TagVo copy(Tag tag){
        TagVo tagVo=new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList=new ArrayList<>();
        for (Tag tag:tagList){
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

}
