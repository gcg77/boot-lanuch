package com.boot.bootlanuch.controller;

import com.boot.bootlanuch.entity.TUser;
import com.boot.bootlanuch.entity.core.TUserOdsCore;
import com.boot.bootlanuch.entity.master.TUserOds;
import com.boot.bootlanuch.entity.master.UserToken;
import com.boot.bootlanuch.exception.BusinessException;
import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.response.RestResponse;
import com.boot.bootlanuch.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gcg
 */
@RestController
@Slf4j
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
    public RestResponse addMasterUser(@RequestBody TUserOds user) {
        userService.addMasterUser(user);
        return RestResponse.success().put("data", user);
    }

    @ApiOperation(value = "向core库添加用戶")
    @PostMapping("/userCore")
    public RestResponse addCoreUser(@Valid @RequestBody TUserOdsCore user) {
        userService.addCoreUser(user);
        return RestResponse.success().put("data", user);
    }

    @ApiOperation(value = "向core和master库添加用戶")
    @PostMapping("/userCoreAndMaster")
    public RestResponse addCoreAndMasterUser(@RequestBody TUserOdsCore user) {
        userService.addCoreAndMasterUser(user);
        return RestResponse.success().put("data", user);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/userlogin")
    public RestResponse userLogin(@RequestParam("username") String username) throws BusinessException {
        UserToken userToken = userService.userLogin(username);
        return RestResponse.success().put("data", userToken);
    }

    @ApiOperation(value = "根据id查询用户")
    @GetMapping("/coreuser/{id}")
    public RestResponse findCoreUser(@PathVariable("id") Integer id) {
        TUserOdsCore coreUser = userService.findCoreUser(id);
        return RestResponse.success().put("data", coreUser);
    }
}
