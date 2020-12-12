package com.boot.bootlanuch.controller;


import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.model.book.BookInfo;
import com.boot.bootlanuch.model.book.ReadInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class AjaxResponseController {
    @ApiOperation(value = "查看书籍信息")
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseBase findBookOne(@PathVariable("id") Integer id) {
        ReadInfo readInfo = ReadInfo.builder()
                .name("g12")
                .age("11")
                .build();
        BookInfo bookInfo = BookInfo.builder()
                .id(id)
                .auto("gcg")
                .money("111")
                .date(new Date())
                .remark("返回书籍信息")
                .read(readInfo)
                .build();
        return ResponseBase.success(bookInfo);
    }
    @ApiOperation(value ="增加书籍信息")
    @PostMapping("/book")
    public ResponseBase addBook(@RequestBody BookInfo bookInfo) {
        log.info("id" + bookInfo.getId());
        return ResponseBase.success();
    }
    @ApiOperation(value ="更新书籍信息")
    @PutMapping("/book")
    public ResponseBase updateBook(@RequestBody BookInfo bookInfo) {
        log.info("id" + bookInfo.getId());
        return ResponseBase.success();
    }
    @ApiOperation(value ="删除书籍信息")
    @DeleteMapping("/book")
    public ResponseBase deleteBook(@RequestParam("id") Integer id) {
        log.info("id" + id);
        return ResponseBase.success();
    }
}
