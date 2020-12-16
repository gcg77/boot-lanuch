package com.boot.bootlanuch.controller;


import com.boot.bootlanuch.model.book.BooksInfo;
import com.boot.bootlanuch.model.family.Family;
import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.model.book.ReadInfo;
import com.boot.bootlanuch.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author gcg
 */
@RestController
@Slf4j
public class AjaxResponseController {
    @Resource
    Family family;

    @ApiOperation(value = "根据id查看书籍信息")
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseBase findBookOne(@PathVariable("id") Integer id) {
        ReadInfo readInfo = ReadInfo.builder()
                .name("g12")
                .age("11")
                .build();
        BooksInfo booksInfo = BooksInfo.builder()
                .id(id)
                .auto("gcg")
                .money("111")
                .date(new Date())
                .remark("返回书籍信息")
                .read(readInfo)
                .build();
        return ResponseBase.success(booksInfo);
    }

    @ApiOperation(value = "查看书籍信息")
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseBase findBook() {
        ReadInfo readInfo = ReadInfo.builder()
                .name("g12")
                .age("11")
                .build();
        BooksInfo booksInfo = BooksInfo.builder()
                .id(1)
                .auto("gcg")
                .money("111")
                .date(new Date())
                .remark("返回书籍信息")
                .read(readInfo)
                .build();
        return ResponseBase.success(booksInfo);
    }

    @ApiOperation(value = "增加书籍信息")
    @PostMapping("/book")
    public ResponseBase addBook(@RequestBody @Validated BooksInfo booksInfo) {
        log.info("family:" + family.toString());
        log.info("id" + booksInfo.getId());
        return ResponseBase.success(booksInfo);
    }

    @ApiOperation(value = "更新书籍信息")
    @PutMapping("/book")
    public ResponseBase updateBook(@RequestBody BooksInfo booksInfo) {
        log.info("id" + booksInfo.getId());
        return ResponseBase.success(booksInfo);
    }

    @ApiOperation(value = "删除书籍信息")
    @DeleteMapping("/book")
    public ResponseBase deleteBook(@RequestParam("id") Integer id) {
        log.info("id" + id);
        return ResponseBase.success();
    }
}
