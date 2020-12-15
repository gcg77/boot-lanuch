package com.boot.bootlanuch.service;

import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;

import java.util.List;


public interface UserService {
    public Integer addUser(TUser user);
    public List<TUser> findUserList();
    public void deleteUser(Integer id);
    public void updateUser(TUser user);
    public List<TUser> findUsesrByExample(Integer id);
    public void addMasterUser(TUserOds user);
    public void addCoreUser(TUserOdsCore user);

}
