package com.boot.bootlanuch.controller;

import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public ResponseBase findUsesrByExample(@PathVariable("id") Integer id) {
        List<TUser> userList = userService.findUsesrByExample(id);
        return ResponseBase.success(userList);
    }
}
