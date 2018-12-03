package com.redcompany.red.library.service.impl;

import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;
import com.redcompany.red.library.data.mysql.DBCommand;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.service.DBService;

import java.util.List;

public class RegularDBServiceImpl implements DBService {
   private DBCommand dbCommand;
   private List<Book> bookList;

    @Override
    public List<Book> getBookList() {
        System.out.println();

        BookDaoSQLImpl bookDaoSQL = new BookDaoSQLImpl();
        bookList = bookDaoSQL.getBookList();
        System.out.println();
        return bookList;
    }
}