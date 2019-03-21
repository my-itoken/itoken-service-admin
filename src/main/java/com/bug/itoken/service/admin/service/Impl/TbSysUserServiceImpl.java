package com.bug.itoken.service.admin.service.Impl;

import com.bug.itoken.service.admin.domain.TbSysUser;
import com.bug.itoken.service.admin.mapper.TbSysUserMapper;
import com.bug.itoken.service.admin.service.TbSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TbSysUserServiceImpl implements TbSysUserService {
    @Autowired
    private TbSysUserMapper tbSysUserMapper;
    @Override
    public void register(TbSysUser tbSysUser) {
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPassword) {
        Example example = new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        List<TbSysUser> tbSysUsers = tbSysUserMapper.selectByExample(example);
        System.out.println(tbSysUsers);
        return null;
    }
}
