package com.boot.bootlanuch.service;

import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.entity.master.UserToken;

import java.util.List;

/**
 * @author gcg
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public Integer addUser(TUser user);

    /**
     * 查找用户
     * @return
     */
    public List<TUser> findUserList();

    /**
     * 根据ID删除用户
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(TUser user);

    /**
     * 根据条件查询用户信息
     * @param id
     * @return
     */
    public List<TUser> findByExample(Integer id);

    /**
     *添加master数据库的用户
     * @param user
     */
    public void addMasterUser(TUserOds user);

    /**
     * 添加core数据库的用户
     * @param user
     */
    public void addCoreUser(TUserOdsCore user);

    /**
     * 添加core和master用户信息
     * @param user
     */
    public void addCoreAndMasterUser(TUserOdsCore user);

    /**
     * 用户登录
     * @param username
     * @return
     */
    public UserToken userLogin(String username);

    /**
     * 获取userid
     * @param token
     * @return
     */
    public UserToken userToken(String token);
}
