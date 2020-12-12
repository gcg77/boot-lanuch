package com.boot.bootlanuch.service;


import com.boot.bootlanuch.model.book.BooksInfo;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public String saveBook(BooksInfo booksInfo);
}
