package com.boot.bootlanuch.service.impl;

import com.boot.bootlanuch.dao.TUserDao;
import com.boot.bootlanuch.dao.core.TUserOdsCoreDao;
import com.boot.bootlanuch.dao.master.TUserOdsDao;
import com.boot.bootlanuch.dao.master.UserTokenDao;
import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.TUserExample;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.entity.master.TUserOdsExample;
import com.boot.bootlanuch.entity.master.UserToken;
import com.boot.bootlanuch.entity.master.UserTokenExample;
import com.boot.bootlanuch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author admin
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private TUserDao userDao;
    @Resource
    private TUserOdsDao tUserMasterOdsDao;
    @Resource
    private TUserOdsCoreDao tUserOdsCoreDao;
    @Resource
    private UserTokenDao userTokenDao;
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

    @Override
    public UserToken userLogin(String username) {
        TUserOdsExample tUserExample=new TUserOdsExample();
        tUserExample.or().andUsernameEqualTo(username);
        List<TUserOds> userList=tUserMasterOdsDao.selectByExample(tUserExample);
        Integer userId=null;
        if(userList!=null&&userList.size()>0){
            userId=userList.get(0).getId();
        }
        log.info("id:"+userId);
        UserTokenExample userTokenExample=new UserTokenExample();
        userTokenExample.or().andUseridEqualTo(userId);
        List<UserToken> userTokens=userTokenDao.selectByExample(userTokenExample);
        UserToken userToken=new UserToken();
        userToken.setUserid(userId);
        userToken.setToken(UUID.randomUUID().toString().replace("-",""));
        if(userTokens!=null&&userTokens.size()>0){
            userToken.setId(userTokens.get(0).getId());
            userTokenDao.updateByPrimaryKey(userToken);
        }else{
            userTokenDao.insert(userToken);
        }
        return userToken;
    }

    @Override
    public String getToken(Integer userid) {
        UserTokenExample userTokenExample=new UserTokenExample();
        userTokenExample.or().andUseridEqualTo(userid);
        List<UserToken> userTokens=userTokenDao.selectByExample(userTokenExample);
        String token="";
        if(userTokens!=null&&userTokens.size()>0){
            token=userTokens.get(0).getToken();
        }
        return token;
    }
}
