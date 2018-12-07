package com.redcompany.red.library.controller.command.impl;

import com.redcompany.red.library.controller.command.BasicCommand;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.service.LibraryService;
import com.redcompany.red.library.service.impl.RegularLibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class FindBookByAuthor implements BasicCommand {

   private LibraryService libraryService;
   private List<Book> bookList;

    @Override
    public void performAction(Map<String, Object> userdata, DataBase dataBase) {

        libraryService = new RegularLibraryServiceImpl();
       bookList= libraryService.findBookByAuthorInCatalog(userdata, dataBase.gedLibraryData());
        System.out.println(bookList);
        //ResultConsoleView.showResult(bookList);
    }
}
