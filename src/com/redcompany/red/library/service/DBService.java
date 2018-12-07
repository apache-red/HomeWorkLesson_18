package com.redcompany.red.library.service;

import com.redcompany.red.library.data.mysql.BookDaoSQLImpl;
import com.redcompany.red.library.entity.Book;

import java.util.List;

public interface DBService {

    List<Book> getBookList( BookDaoSQLImpl bookDaoSQL);
}
