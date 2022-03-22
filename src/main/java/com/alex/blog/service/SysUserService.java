package com.alex.blog.service;

import com.alex.blog.dao.pojo.SysUser;

public interface SysUserService {

    SysUser findUserById(long id);
}
