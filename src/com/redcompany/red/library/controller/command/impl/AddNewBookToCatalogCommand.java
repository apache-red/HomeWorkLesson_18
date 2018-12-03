package com.redcompany.red.library.controller.command.impl;

import com.redcompany.red.library.controller.command.BasicCommand;
import com.redcompany.red.library.data.collection.LibraryCommand;
import com.redcompany.red.library.service.LibraryService;
import com.redcompany.red.library.service.impl.RegularLibraryServiceImpl;

import java.util.Map;

public class AddNewBookToCatalogCommand implements BasicCommand {

    private LibraryService libraryService;

    @Override
    public void performAction(Map<String, Object> userdata, LibraryCommand libraryCommand) {


        libraryService = new RegularLibraryServiceImpl();
        libraryService.addNewBookToCatalog(userdata, libraryCommand);
    }
}
