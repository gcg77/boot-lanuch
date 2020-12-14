package com.boot.bootlanuch.service.impl;

import com.boot.bootlanuch.dao.TUserDao;
import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.TUserExample;
import com.boot.bootlanuch.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private TUserDao userDao;
    @Override
    public Integer addUser(TUser user) {
        return userDao.insert(user);
    }

    @Override
    public List<TUser> findUserList() {
        return userDao.selectByExample(null);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(TUser user) {
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public List<TUser> findUsesrByExample(Integer id) {
        TUserExample tUserExample=new TUserExample();
        tUserExample.or().andIdEqualTo(id);
        List<TUser> userList=userDao.selectByExample(tUserExample);
        return userList;
    }
}
