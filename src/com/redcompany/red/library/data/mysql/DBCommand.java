package com.redcompany.red.library.data.mysql;

import com.redcompany.red.library.entity.Book;


import java.util.List;

public interface DBCommand {

    List<Book> getBookList();
}
