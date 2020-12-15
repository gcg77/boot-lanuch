package com.boot.bootlanuch.controller;


import com.boot.bootlanuch.entity.SysUser;
import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gcg
 * @since 2020-12-15
 */
@RestController
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @ApiOperation(value = "添加用戶")
    @PostMapping("/sysUser")
    public ResponseBase addUser(@RequestBody SysUser user) {
        sysUserService.save(user);
        return ResponseBase.success();
    }
}

