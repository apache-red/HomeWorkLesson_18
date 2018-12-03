package com.redcompany.red.library.controller.command.impl;

import com.redcompany.red.library.controller.command.BasicCommand;
import com.redcompany.red.library.data.collection.LibraryCommand;
import com.redcompany.red.library.service.DBService;
import com.redcompany.red.library.service.impl.RegularDBServiceImpl;

import java.util.Map;

public class DBGetBookscommand implements BasicCommand {

    private DBService dbService;

    @Override
    public void performAction(Map<String, Object> userdata, LibraryCommand libraryCommand) {

        dbService = new RegularDBServiceImpl();
        System.out.println(dbService.getBookList());
    }
}
