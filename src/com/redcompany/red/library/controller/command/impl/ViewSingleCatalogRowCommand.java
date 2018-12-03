package com.redcompany.red.library.controller.command.impl;

import com.redcompany.red.library.controller.command.BasicCommand;
import com.redcompany.red.library.controller.console.view.ResultConsoleView;
import com.redcompany.red.library.data.collection.LibraryCommand;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.service.LibraryService;
import com.redcompany.red.library.service.impl.RegularLibraryServiceImpl;

import java.util.Map;

public class ViewSingleCatalogRowCommand implements BasicCommand {

    private LibraryService libraryService;
    private Book book;

    @Override
    public void performAction(Map<String, Object> userdata, LibraryCommand libraryCommand) {

        libraryService = new RegularLibraryServiceImpl();

        book = libraryService.getBookFromCatalog(userdata, libraryCommand);
        ResultConsoleView.showResult(book);

    }
}
