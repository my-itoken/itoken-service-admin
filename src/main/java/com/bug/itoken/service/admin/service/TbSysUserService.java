package com.bug.itoken.service.admin.service;


import com.bug.itoken.service.admin.domain.TbSysUser;

public interface TbSysUserService {

    void register(TbSysUser tbSysUser);

    TbSysUser login(String loginCode,String plantPassword);
}
