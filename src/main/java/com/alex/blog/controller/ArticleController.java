package com.alex.blog.controller;

import com.alex.blog.service.ArticleService;
import com.alex.blog.service.impl.ArticleServiceImpl;
import com.alex.blog.vo.ArticleVo;
import com.alex.blog.vo.Result;
import com.alex.blog.vo.param.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//json数据进行交互
@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 首页文章列表
     *
     * @param pageParams
     * @return
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        List<ArticleVo> articles = articleService.listArticle(pageParams);

        return Result.success(articles);
    }

    /**
     * 首页最热文章
     * @return
     */
    @PostMapping("hot")
    public Result HotArticle() {
        int limit=5;
       return articleService.hotArticles(limit);
    }

    /**
     * 首页最新文章
     * @return
     */
    @PostMapping("new")
    public Result newArticles() {
        int limit=5;
        return articleService.newArticles(limit);
    }

    @PostMapping("listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }
}
