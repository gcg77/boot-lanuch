package com.boot.bootlanuch.controller;

import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.entity.master.UserToken;
import com.boot.bootlanuch.exception.BusinessException;
import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gcg
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @ApiOperation(value = "添加用戶")
    @PostMapping("/user")
    public ResponseBase addUser(@RequestBody TUser user) {
        userService.addUser(user);
        return ResponseBase.success();
    }

    @ApiOperation(value = "查找用户")
    @GetMapping("/user")
    public ResponseBase findUser() {
        List<TUser> userList = userService.findUserList();
        return ResponseBase.success(userList);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/user")
    public ResponseBase deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return ResponseBase.success();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("/user")
    public ResponseBase updateUser(@RequestBody TUser user) {
        userService.updateUser(user);
        return ResponseBase.success();
    }
    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/user/{id}")
    public ResponseBase findByExample(@PathVariable("id") Integer id) {
        List<TUser> userList = userService.findByExample(id);
        return ResponseBase.success(userList);
    }
    @ApiOperation(value = "向master库添加用戶")
    @PostMapping("/userMaster")
    public ResponseBase addMasterUser(@RequestBody TUserOds user) {
        userService.addMasterUser(user);
        return ResponseBase.success(user);
    }
    @ApiOperation(value = "向core库添加用戶")
    @PostMapping("/userCore")
    public ResponseBase addCoreUser(@RequestBody TUserOdsCore user) {
        userService.addCoreUser(user);
        return ResponseBase.success(user);
    }
    @ApiOperation(value = "向core和master库添加用戶")
    @PostMapping("/userCoreAndMaster")
    public ResponseBase addCoreAndMasterUser(@RequestBody TUserOdsCore user) {
        userService.addCoreAndMasterUser(user);
        return ResponseBase.success(user);
    }
    @ApiOperation(value = "用户登录")
    @PostMapping("/userlogin")
    public ResponseBase userLogin(@RequestParam("username") String username) throws BusinessException {
            UserToken userToken=userService.userLogin(username);
            return ResponseBase.success(userToken);
    }
}
