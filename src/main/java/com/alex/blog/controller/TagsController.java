package com.alex.blog.controller;

import com.alex.blog.service.TagService;
import com.alex.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagsController {
    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result hot() {
        int limit=5;
        return tagService.hots(limit);
    }
}
