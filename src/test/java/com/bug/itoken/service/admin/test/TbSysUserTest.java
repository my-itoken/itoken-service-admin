package com.bug.itoken.service.admin.test;

import com.bug.itoken.service.admin.ServiceAdminApplication;
import com.bug.itoken.service.admin.domain.TbSysUser;
import com.bug.itoken.service.admin.mapper.TbSysUserMapper;
import com.bug.itoken.service.admin.service.TbSysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
public class TbSysUserTest {
    @Autowired
    private TbSysUserService tbSysUserService;

    @Test
    public void register(){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("lusifer@funtl.com");
        tbSysUser.setUserName("Lusifer");
        tbSysUser.setUserType("1");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("0");
        tbSysUser.setCorpName("iToken");
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        System.out.println(tbSysUser.getPassword());
        tbSysUserService.register(tbSysUser);
    }

    @Test
    public void login(){
        tbSysUserService.login("lusifer@funtl.com",DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
