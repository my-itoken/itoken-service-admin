package com.bug.itoken.service.admin.controller;

import com.bug.itoken.common.dto.BaseResult;
import com.bug.itoken.service.admin.domain.TbSysUser;
import com.bug.itoken.service.admin.service.TbSysUserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TbSysUserController {

    @Autowired
    private TbSysUserService tbSysUserService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public BaseResult login(String loginCode,String password){
        if (StringUtils.isBlank(loginCode)||StringUtils.isBlank(password)){
            return BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("loginCode","用户名错误"),
                    new BaseResult.Error("password","密码错误")
            ));
        }
        TbSysUser user = tbSysUserService.login(loginCode, password);
        if (user!=null){
            return BaseResult.ok(user);
        }
        return BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error("","登录失败")
        ));
    }
}
