package com.alex.blog.service.impl;

import com.alex.blog.dao.mapper.SysUserMapper;
import com.alex.blog.dao.pojo.SysUser;
import com.alex.blog.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findUserById(long id) {
        SysUser sysUser= sysUserMapper.selectById(id);
        if (sysUser==null){
            sysUser=new SysUser();
            sysUser.setNickname("未名");
        }
        return sysUser;
    }
}
