package com.boot.bootlanuch.service;


import com.boot.bootlanuch.model.book.BooksInfo;
import org.springframework.stereotype.Service;
/**
 * @author gcg
 */
@Service
public interface BookService {
    /**
     * 保存书籍
     * @param booksInfo
     * @return
     */
    public String saveBook(BooksInfo booksInfo);
}
