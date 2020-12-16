package com.boot.bootlanuch.service.impl;

import com.boot.bootlanuch.dao.TUserDao;
import com.boot.bootlanuch.dao.core.TUserOdsCoreDao;
import com.boot.bootlanuch.dao.master.TUserOdsDao;
import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.TUserExample;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private TUserDao userDao;
    @Resource
    private TUserOdsDao tUserMasterOdsDao;
    @Resource
    private TUserOdsCoreDao tUserOdsCoreDao;
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
    public List<TUser> findByExample(Integer id) {
        TUserExample tUserExample=new TUserExample();
        tUserExample.or().andIdEqualTo(id);
        List<TUser> userList=userDao.selectByExample(tUserExample);
        return userList;
    }

    @Override
    public void addMasterUser(TUserOds user) {
        tUserMasterOdsDao.insert(user);
    }

    @Override
    public void addCoreUser(TUserOdsCore user) {
        tUserOdsCoreDao.insert(user);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addCoreAndMasterUser(TUserOdsCore user) {
        TUserOds userOds=new TUserOds();
        BeanUtils.copyProperties(user,userOds);
        tUserMasterOdsDao.insert(userOds);
        tUserOdsCoreDao.insert(user);
    }
}
